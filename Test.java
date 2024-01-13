import java.io.*;
import java.util.*;

import javax.swing.plaf.multi.MultiInternalFrameUI;

public class Test {
    public static void main (String[] args) throws IOException {
        BufferedReader bfn = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer input = new StringTokenizer(bfn.readLine());

        

        return;
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
