import java.io.*;
import java.util.*;
import java.util.LinkedList;

public class Graph {
  public static void main(String[] args) throws IOException {
    /*
     * 
     * 8 11
     * 1 2
     * 1 3
     * 1 4
     * 3 4
     * 2 4
     * 3 6
     * 4 7
     * 6 7
     * 7 5
     * 6 8
     * 7 8
     */
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
      /*
       * adjMat - Adjacency Matrix Representation of Graph
       * adjLst - Adjacency List Representation of Graph
       */

      // int[][] adjMat = inputGraphInAdjacencyMatrixRepresentation(br);
      ArrayList<ArrayList<Integer>> adjLst = inputGraphInAdjacencyListRepresentation(br);

      // adjLst = convertGraphFromAdjacencyMatrixToAdjacencyList(adjMat);

      System.out.print("\n----------------\n");
      printAdjacencyListGraph(adjLst);
      System.out.print("\n----------------\n");
      breadthFirstSearchTraversalOfGraph(adjLst, 1);

      System.out.print("\n-------V2---------\n");
      breadthFirstSearchTraversalOfGraphV2(adjLst, 1);

    }
    return;
  }

  public static int[][] inputGraphInAdjacencyMatrixRepresentation(BufferedReader br) throws IOException {
    System.out.print("\nEnter the size of the adjacency (square) matrix: ");
    StringTokenizer input = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(input.nextToken());
    int N = n + 1;

    /*
     * adjMat - Adjacency Matrix Representation of Graph
     */
    int[][] adjMat = new int[N][N];

    System.out.print("\nEnter the Matrix: \n");

    for (int i = 1; i < N; i += 1) {
      input = new StringTokenizer(br.readLine());
      for (int j = 1; j < N; j += 1) {
        adjMat[i][j] = Integer.parseInt(input.nextToken());
      }
    }
    return adjMat;
  }

  public static ArrayList<ArrayList<Integer>> inputGraphInAdjacencyListRepresentation(BufferedReader br)
      throws IOException {
    System.out.print(
        "\nEnter Details in the Following Format:\n   First Line Contains 2 Integers - \n      n (no. of nodes)\n      m (no. of edges). \n   Then 'm' lines follow each representing an edge.\n");
    StringTokenizer input = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(input.nextToken());
    int m = Integer.parseInt(input.nextToken());

    /*
     * Implement in 1 based Indexing
     */
    n += 1;
    m += 1;

    ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();

    boolean isGraphUnidirectional = true;

    for (int i = 0; i < n; i += 1) {
      ArrayList<Integer> temp = new ArrayList<>();
      adjList.add(temp);
    }

    for (int i = 1; i < m; i += 1) {
      input = new StringTokenizer(br.readLine());
      int firstNode = Integer.parseInt(input.nextToken());
      int secondNode = Integer.parseInt(input.nextToken());

      adjList.get(firstNode).add(secondNode);

      if (isGraphUnidirectional) {
        adjList.get(secondNode).add(firstNode);
      }
    }
    return adjList;
  }

  public static ArrayList<ArrayList<Integer>> convertGraphFromAdjacencyMatrixToAdjacencyList(int[][] adjMat) {
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

  public static void breadthFirstSearchTraversalOfGraph(ArrayList<ArrayList<Integer>> adjLst, int startingNode) {
    int n = adjLst.size();
    if (startingNode < 1 || startingNode > n) {
      System.out.print("\nError: Node is not present in the Graph");
      return;
    }
    Queue<Integer> queue = new LinkedList<Integer>();
    boolean[] isNodeVisited = new boolean[n];
    int[] distanceFromSourceNode = new int[n];

    for (int i = 1; i < n; i += 1) {
      isNodeVisited[i] = false;
      distanceFromSourceNode[i] = 0;
    }

    int currentDistance = 0;
    queue.add(startingNode);
    isNodeVisited[startingNode] = true;
    queue.add(-1);

    currentDistance += 1;

    System.out.print("\nBFS: ");

    while (queue.isEmpty() == false) {
      int currNode = queue.poll();
      if (currNode == -1) {
        System.out.print(" | ");
        currentDistance += 1;
        if (queue.size() > 1) {
          queue.add(-1);
        }
        continue;
      }
      System.out.print(currNode + ", ");
      ArrayList<Integer> neighbourNodes = adjLst.get(currNode);
      for (int i = 0; i < neighbourNodes.size(); i += 1) {
        int neighbourNode = neighbourNodes.get(i);
        if (isNodeVisited[neighbourNode] == false) {
          queue.add(neighbourNode);
          isNodeVisited[neighbourNode] = true;
          distanceFromSourceNode[neighbourNode] = currentDistance;
        }
      }

    }

    System.out.print("\nDistance From Source Node: ");
    for (int i = 1; i < n; i += 1) {
      System.out.print(distanceFromSourceNode[i] + ", ");
    }
    return;
  }

  /*
   * Cleaner Code for Computation of DistanceFromSourceNode Array
   */
  public static void breadthFirstSearchTraversalOfGraphV2(ArrayList<ArrayList<Integer>> adjLst, int startingNode) {
    int n = adjLst.size();
    if (startingNode < 1 || startingNode > n) {
      System.out.print("\nError: Node is not present in the Graph");
      return;
    }
    Queue<Integer> queue = new LinkedList<Integer>();
    boolean[] isNodeVisited = new boolean[n];
    int[] distanceFromSourceNode = new int[n];

    for (int i = 1; i < n; i += 1) {
      isNodeVisited[i] = false;
      distanceFromSourceNode[i] = 0;
    }

    queue.add(startingNode);
    isNodeVisited[startingNode] = true;

    System.out.print("\nBFS: ");

    while (queue.isEmpty() == false) {
      int currNode = queue.poll();

      System.out.print(currNode + ", ");

      ArrayList<Integer> neighbourNodes = adjLst.get(currNode);
      for (int i = 0; i < neighbourNodes.size(); i += 1) {
        int neighbourNode = neighbourNodes.get(i);
        if (isNodeVisited[neighbourNode] == false) {
          queue.add(neighbourNode);
          isNodeVisited[neighbourNode] = true;
          distanceFromSourceNode[neighbourNode] = distanceFromSourceNode[currNode] + 1;
        }
      }

    }

    System.out.print("\nDistance From Source Node: ");
    for (int i = 1; i < n; i += 1) {
      System.out.print(distanceFromSourceNode[i] + ", ");
    }
    return;
  }

}