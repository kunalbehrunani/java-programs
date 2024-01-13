import java.io.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BinarySearch {
    public static void main (String[] args) throws IOException {
        // int[] arr = new int[] {1, 3, 5, 6, 6, 6, 7, 7, 10, 10, 14, 16, 19, 19};
        int[] arr = new int[] {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 3, 3, 3, 3};

        int n = arr.length;
        int start = arr[0] - 1;
        int end = arr[n-1] + 1;
        for (int i = start; i <= end; i += 1) {
            System.out.println("################################ Element: " + i);
            // binarySearch(arr, i);
            // firstOccurence(arr, i);
            lastOccurence(arr, i);
        }

        return;
    }

    private static boolean checkIfArrayIsNonDecreasing(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n-1; i += 1) {
            if (arr[i+1] < arr[i]) {
                System.out.println("Error: Array should be strictly non-decreasing");
                return false;
            }
        }
        return true;
    }

    private static void binarySearch(int[] arr, int k) {
        /*
         * This below is Naive Approach.
         * Implemented Raw, without going through the notes from AlgoUniversity. 
         * Do not refer.
         */
        int n = arr.length;

        boolean isArrayNonDecreasing = checkIfArrayIsNonDecreasing(arr);
        if (!isArrayNonDecreasing) {
            return;
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

                // PS: First and last occurence is found linearly. Can it be found using patterns of binary search? ie. in logarathmic time complexiety.

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

    /*
     * This method finds if the given element k occurs in the given non-decreasing array - "arr"
     * If Yes, it'll return the first occurence of k
     * If Not, then it'll return the Lower & Upper Bound of k. 
     * Lower Bound: Greatest Number in the array which is less than k
     * Upper Bound: Smallest Number in the array which is greater than k
     */
    private static void firstOccurence(int[] arr, int k) {
        boolean isArrayNonDecreasing = checkIfArrayIsNonDecreasing(arr);
        if (!isArrayNonDecreasing) {
            return;
        }

        /* RULE OF INVARIANT
         * suppose arr[x] = k (where x is the first occurence of k)
         * Block B1 = 0 to x-1
         * Block B2 = x to n-1
         * Hence, initial search space - l to r, where l = 0 & r = n-1
         * l will always stay in B1
         * r will always stay in B2
         * Finally when l and r are adjacent, our answer will be r as it lies in Block B2.
         */

        int n = arr.length;
        int l = 0, r = n-1;

        if (arr[l] > k) {
            System.out.println("** Element Not Found");
            System.out.println("** Upper Bound: " + arr[l]);
            return;
        }
        if (arr[l] == k) {
            // We're checking this condition because as per our rule of invariant, we've defined our Block B1 with elements less than element k. 
            // If our left most element in array is equal to k itself, then it defies our declaration of blocks as per rule of invariant
            // and left most element is itself the answer.
            System.out.println("** Element Found: " + arr[l]);
            System.out.println("** First Occurence: " + l + "(index)");
            return;

        }
        if (arr[r] < k) {
            System.out.println("** Element Not Found");
            System.out.println("** Lower Bound: " + arr[r]);
            return;
        }
        while (l + 1 < r) {
            int m = l + (r-l)/2;
            if (arr[m] < k) {
                l = m;
            } else r = m;
        }

        if (arr[r] != k) {
            System.out.println("** Element Not Found");
            System.out.println("** Lower Bound: " + arr[l]);
            System.out.println("** Upper Bound: " + arr[r]);
            return;
        }

        System.out.println("** Element Found: " + arr[r]);
        System.out.println("** First Occurence: " + r + "(index)");


    }

    /*
     * This method finds if the given element k occurs in the given non-decreasing array - "arr"
     * If Yes, it'll return the Last occurence of k
     * If Not, then it'll return the Lower & Upper Bound of k. 
     * Lower Bound: Greatest Number in the array which is less than k
     * Upper Bound: Smallest Number in the array which is greater than k
     */
    private static void lastOccurence(int[] arr, int k) {
        boolean isArrayNonDecreasing = checkIfArrayIsNonDecreasing(arr);
        if (!isArrayNonDecreasing) {
            return;
        }

        /* RULE OF INVARIANT
         * suppose arr[x] = k (where x is the last occurence of k)
         * Block B1 = 0 to x
         * Block B2 = x+1 to n-1
         * Hence, initial search space - l to r, where l = 0 & r = n-1
         * l will always stay in B1
         * r will always stay in B2
         * Finally when l and r are adjacent, our answer will be l as it lies in Block B1.
         */

        int n = arr.length;
        int l = 0, r = n-1;

        if (arr[l] > k) {
            System.out.println("** Element Not Found");
            System.out.println("** Upper Bound: " + arr[l]);
            return;
        }
        if (arr[r] == k) {
            // We're checking this condition because as per our rule of invariant, we've defined our Block B2 with elements greater than element k. 
            // If our right most element in array is equal to k itself, then it defies our declaration of blocks as per rule of invariant
            // and right most element is itself the answer.
            System.out.println("** Element Found: " + k);
            System.out.println("** Last Occurence: " + r + "(index)");
            return;

        }
        if (arr[r] < k) {
            System.out.println("** Element Not Found");
            System.out.println("** Lower Bound: " + arr[r]);
            return;
        }
        while (l + 1 < r) {
            int m = l + (r-l)/2;
            if (arr[m] > k) {
                r = m;
            } else l = m;
        }

        if (arr[l] != k) {
            System.out.println("** Element Not Found");
            System.out.println("** Lower Bound: " + arr[l]);
            System.out.println("** Upper Bound: " + arr[r]);
            return;
        }

        System.out.println("** Element Found: " + k);
        System.out.println("** Last Occurence: " + l + "(index)");

    }
}
