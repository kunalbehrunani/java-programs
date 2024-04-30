import java.io.*;
import java.util.*;

class Interval {
  int start;
  int end;

  Interval(int st, int ed) {
    this.start = st;
    this.end = ed;
    return;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (!(obj instanceof Interval)) {
      return false;
    }
    Interval objInterval = (Interval) obj;
    if (this.start == objInterval.start && this.end == objInterval.end) {
      return true;
    }
    return false;
  }

  @Override
  public int hashCode() {
    int MAX_VALUE = 805;
    return this.start * MAX_VALUE + this.end;
  }
}

public class DynamicProgramming {

  /*
   * Maintain a HashMap for Memoization
   */
  private static HashMap<Interval, Integer> hashMap = new HashMap<Interval, Integer>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer input = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(input.nextToken());

    input = new StringTokenizer(br.readLine());
    int[] wines = new int[n];
    for (int i = 0; i < n; i += 1) {
      wines[i] = Integer.parseInt(input.nextToken());
    }
    int result = findProfitBySellingWineShelf(wines, 0, n - 1, 1);
    System.out.println(result);
  }

  /*
   * PROBLEM STATEMENT -
   * 
   * You have a collection of N wines placed next to each other on a shelf. Let's
   * number the wines from left to right as they are standing on the shelf with
   * integers from 1 to N, respectively. The price of the ith wine is Pi (prices
   * of different wines can be different). Because the wines get better every
   * year, supposing today is the year 1, on year Y the price of the ith wine will
   * be Y∗Pi, that is Y times the value of wine that current year.
   * 
   * You want to sell all the wines you have, but you want to sell exactly one
   * wine per year, starting this year. One more constraint - each year you are
   * allowed to sell only either the leftmost or the rightmost wine on the shelf
   * and you are not allowed to reorder the wines on the shelf (i.e. they must
   * stay in the same order as they are in the beginning).
   * 
   * You want to find out, what is the maximum profit you can get, if you sell the
   * wines in optimal order. Since profit can be really large, report profit
   * modulo 109+7
   * 
   */
  private static int findProfitBySellingWineShelf(int[] arr, int start, int end, int currentYear) {

    /*
     * Memoization
     */
    if (hashMap.get(new Interval(start, end)) != null) {
      return hashMap.get(new Interval(start, end));
    }

    int currentProfit = 0;

    /*
     * Base Case
     */
    if (start == end) {
      currentProfit = (arr[start] * currentYear) % 1000000007;
    }
    /*
     * Transition
     * 
     * Note - The 2 else if conditions are intentially set to false, because no
     * definite answer can be found using greedy approach. We've to check all
     * possible scenarios to find the optimal answer.
     */
    else if (false /* arr[start] < arr[end] */) {
      currentProfit = (arr[start] * currentYear) % 1000000007
          + findProfitBySellingWineShelf(arr, start + 1, end, currentYear + 1);
    } else if (false /* arr[start] > arr[end] */) {
      currentProfit = (arr[end] * currentYear) % 1000000007
          + findProfitBySellingWineShelf(arr, start, end - 1, currentYear + 1);
    } else {
      int result1 = (arr[start] * currentYear) % 1000000007
          + findProfitBySellingWineShelf(arr, start + 1, end, currentYear + 1);
      int result2 = (arr[end] * currentYear) % 1000000007
          + findProfitBySellingWineShelf(arr, start, end - 1, currentYear + 1);
      currentProfit = Math.max(result1, result2);
    }

    /*
     * Memoization
     */
    hashMap.put(new Interval(start, end), (currentProfit % 1000000007));

    return currentProfit % 1000000007;

  }
}
