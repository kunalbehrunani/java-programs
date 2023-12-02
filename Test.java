import java.io.*;
import java.util.*;

public class Test {
    public static void main (String[] args) throws IOException {
        try (Scanner scn = new Scanner (System.in)) {
            int n = scn.nextInt();

            int[] input = new int[n];
            System.out.println(" input[2]: " + input[2]);

            for (int i = 0; i < n; i += 1) {
              input[i] = scn.nextInt();
            }

            printArr(input);

            int[] tempArr = new int[n];
            int i = 0;
            while (i < n && input[i] < 0) {
              i += 1;
            }
            int j = i-1;
            int k = 0;
            while (j >= 0 && i < n && k < n) {
              int numJ = 0 - input[j];
              int numI = input[i];
              if (numI < numJ) {
                tempArr[k] = numI;
                i += 1;
              } else {
                tempArr[k] = numJ;
                j -= 1;
              }
              k += 1;
            }
            while (j >= 0) {
                tempArr[k] = 0 - input[j];
                j -= 1;
                k += 1;
            }
            while (i < n) {
                tempArr[k] = input[i];
                i += 1;
                k += 1;
            }
            printArr(tempArr);
            for (i = 0; i < n; i += 1) {
              System.out.print((tempArr[i] * tempArr[i]) + " ");
            }
        }
    
        return;
    }


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
    
}
