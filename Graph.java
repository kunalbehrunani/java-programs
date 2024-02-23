import java.io.*;
import java.util.*;

public class Graph {
  public static void main(String[] args) throws IOException {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
      StringTokenizer input = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(input.nextToken());
      int N = n + 1;

      /*
       * adjMat - Adjacency Matrix Representation of Graph
       */
      int[][] adjMat = new int[N][N];

      for (int i = 1; i < N; i += 1) {
        input = new StringTokenizer(br.readLine());
        for (int j = 1; j < N; j += 1) {
          adjMat[i][j] = Integer.parseInt(input.nextToken());
        }
      }

      /*
       * adjLst - Adjacency List Representation of Graph
       */
      ArrayList<ArrayList<Integer>> adjLst = new ArrayList<ArrayList<Integer>>();
      adjLst = convertGraphFromAdjacencyListToAdjacencyMatrix(adjMat);
      printAdjacencyListGraph(adjLst);

    }
    return;
  }

  public static ArrayList<ArrayList<Integer>> convertGraphFromAdjacencyListToAdjacencyMatrix(int[][] adjMat) {
    ArrayList<ArrayList<Integer>> adjLst = new ArrayList<ArrayList<Integer>>();

    int n = adjMat.length;

    ArrayList<Integer> tempLst = new ArrayList<>();
    adjLst.add(tempLst);

    for (int i = 1; i < n; i += 1) {
      ArrayList<Integer> currLst = new ArrayList<>();
      adjLst.add(currLst);
      for (int j = 1; j < n; j += 1) {
        if (adjMat[i][j] == 1) {
          adjLst.get(i).add(j);
        }
      }
    }
    return adjLst;
  }

  public static void printAdjacencyListGraph(ArrayList<ArrayList<Integer>> adjLst) {
    int n = adjLst.size();
    for (int i = 1; i < n; i += 1) {
      System.out.print(i + ": ");
      ArrayList<Integer> currLst = adjLst.get(i);
      int currLstSize = currLst.size();
      for (int j = 0; j < currLstSize; j += 1) {
        System.out.print(currLst.get(j) + " ");
      }
      System.out.print("\n");
    }
    return;
  }
}