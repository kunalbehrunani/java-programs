import java.io.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BinarySearch {
    public static void main (String[] args) throws IOException {
        int[] arr = new int[] {1, 3, 5, 6, 6, 6, 7, 7, 10, 10, 14, 16, 19, 19};

        for (int i = -1; i < 24; i += 1) {
            System.out.println("################################ index: " + i);
            binarySearch(arr, i);
        }

        return;
    }

    private static void binarySearch(int[] arr, int k) {
        int n = arr.length;

        // check if array is non-decreasing
        for (int i = 0; i < n-1; i += 1) {
            if (arr[i+1] < arr[i]) {
                System.out.println("Error: Array should be strictly non-decreasing");
                return;
            }
        }

        int i = 0;
        int j = n-1;
        while (i <= j && i >= 0 && j >= 0 && i < n && j < n) {
            int m = (i + j) / 2;
            if (arr[m] == k) {
                System.out.println("** Element Found");
                // compute 1st occurence
                int p = m;
                while (p >= 0 && arr[p] == k) {
                    p -= 1;
                }
                p += 1;
                System.out.println("** First Occurence Index: " + p);

                // compute last occurence
                int q = m;
                while (q < n && arr[q] == k) {
                    q += 1;
                }
                q -= 1;
                System.out.println("** Last Occurence Index: " + q);

                System.out.println("** Total Occurence Count: " + ((int)(q - p + 1)));
                

                return;
            } else if (arr[m] < k) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        System.out.println("** Element Not Found");
        System.out.println("** Lower Bound: " + ((j >= 0 && j < n) ? (arr[j]) : ("#NA")));
        System.out.println("** Upper Bound: " + ((i >= 0 && i < n) ? (arr[i]) : ("#NA")));
        
    }

}
