import java.io.*;
import java.util.*;

import javax.swing.plaf.multi.MultiInternalFrameUI;

public class Test {
    public static void main (String[] args) throws IOException {
        BufferedReader bfn = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer input = new StringTokenizer(bfn.readLine());

        int[] arr = new int[] {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1};

        int n = arr.length;

        int st = arr[0] - 1;
        int ed = arr[n-1] + 1;
        for (int i = st; i <= ed; i += 1) {
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

    // Print to console functions
    private static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i += 1) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println("");
    }
    private static void printArr(char[] arr) {
        for (int i = 0; i < arr.length; i += 1) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println("");
    }
    private static void printMat(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        
        System.out.println("Matrix: ");
        for (int i = 0; i < n; i += 1) {
          for (int j = 0; j < m; j += 1) {
            System.out.print(arr[i][j] + "    ");
          }
          System.out.println("");
        }
    }
    private static void printEle(int ele) {
        System.out.println("ele: " + ele);
    }
    private static void printEle(String ele) {
        System.out.println("ele: " + ele);
    }
    private static void printEle(StringBuilder ele) {
        System.out.println("ele: " + ele);
    }
    private static void printEle(char ele) {
        System.out.println("ele: " + ele);
    }
    private static void printSet(HashSet<Integer> hs) {
        System.out.print("HashSet: ");
        for (int ele: hs) {
            System.out.print( ele + ", ");
        }
        System.out.println("");
    } 
}
