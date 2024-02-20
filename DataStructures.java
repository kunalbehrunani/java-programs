import java.io.*;
import java.util.*;
import java.util.LinkedList;

public class DataStructures {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    System.out.println("Enter the Code For Following Data Structures");
    System.out.println("1 -- Tree Map");
    System.out.println("1 -- Stack And Queue");

    StringTokenizer input = new StringTokenizer(br.readLine());
    int code = Integer.parseInt(input.nextToken());
    String dataStructure;
    switch (code) {
      case 1:
        dataStructure = "treeMap";
        break;
      case 2:
        dataStructure = "stackAndQueue";
        break;
      default:
        System.out.println("Wrong Input");
        return;
    }

    switch (dataStructure) {
      case "treeMap":
        treeMap();
        break;
      case "stackAndQueue":
        stackAndQueue();
        break;
      default:
        System.out.println("This data structure is not yet supported");
        break;
    }
    return;
  }

  public static void treeMap() {
    TreeMap<Integer, Integer> orderedHashMap = new TreeMap<>();
    orderedHashMap.put(10, 5);
    orderedHashMap.put(8, 9);
    orderedHashMap.put(3, 5);
    orderedHashMap.put(6, 11);

    System.out.println("Ordered Hash Map (Tree Map): ");
    for (int key : orderedHashMap.keySet()) {
      System.out.println("key: " + key + " | value: " + orderedHashMap.get(key));
    }
    return;
  }

  public static void stackAndQueue() {

    Stack<Integer> s1 = new Stack<>();
    s1.push(1);
    int topMostItem = s1.peek();
    System.out.println("topMostItem: " + topMostItem);

    boolean isStackEmpty = s1.empty();
    System.out.println("isStackEmpty: " + isStackEmpty);

    int totalNumberOfItemsInStack = s1.size();
    System.out.println("totalNumberOfItemsInStack: " + totalNumberOfItemsInStack);

    int poppedItem = s1.pop();
    System.out.println("poppedItem: " + poppedItem);

    isStackEmpty = s1.empty();
    System.out.println("isStackEmpty: " + isStackEmpty);

    System.out.println("******************************");
    System.out.println("******************************");
    System.out.println("******************************");

    /*
     * Queue is an Interface in Java
     * Hence, we cannot declare a Queue by writing simply "new Queue()"
     * Because Queue is an interface and not a class to be instantiated
     * Therefore, we need to implement Queue (which indirectly means implement FIFO
     * Nature)
     * using a class that implements the Queue Interface.
     * Below are a few classes in Java that implement this -
     * 1. Priority Queue
     * Queue<Integer> q1 = new PriorityQueue<Integer>();
     * 2. Linked List
     * Queue<Integer> q2 = new LinkedList<Integer>();
     * 3. Priority Blocking Queue
     * Queue<Integer> q3 = new PriorityBlockingQueue<Integer>();
     * 
     * Most oftenly Linked List is used for implementation of simple queue
     * And, Priority Queue Class is used for implementation of priority queue.
     * 
     */

    // Queue<Integer> q1 = new Queue<Integer>(); // Throws Error

    Queue<Integer> q2 = new LinkedList();

    q2.add(1);
    q2.add(2);
    // q2.add(3);

    /*
     * Throws Error If Queue is Empty.
     * Hence, Add Handling for isEmpty() check before using this operation.
     */
    int firstMostElement = q2.peek();
    System.out.println("firstMostElement: " + firstMostElement);

    boolean isQueueEmpty = q2.isEmpty();
    System.out.println("isQueueEmpty: " + isQueueEmpty);

    /*
     * Throws Error If Queue is Empty.
     * Hence, Add Handling for isEmpty() check before using this operation.
     */
    int firstMostPoppedElement = q2.poll();
    System.out.println("firstMostPoppedElement: " + firstMostPoppedElement);

    firstMostPoppedElement = q2.poll();
    System.out.println("firstMostPoppedElement: " + firstMostPoppedElement);

    isQueueEmpty = q2.isEmpty();
    System.out.println("isQueueEmpty: " + isQueueEmpty);

    /*
     * Returns 0 if Queue is empty.
     * Hence, this check can also be used instead of isEmpty() while using
     * operations like poll or peek etc.
     */
    int totalNumberOfItemsInQueue = q2.size();
    System.out.println("totalNumberOfItemsInQueue: " + totalNumberOfItemsInQueue);

  }

}
