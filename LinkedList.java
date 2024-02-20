import java.io.*;
import java.util.*;

public class LinkedList {

  /*
   * A sub class "Node" to define a Linked List Node.
   */
  static class Node {
    int data;
    /*
     * In C/C++, we would ideally define the "next" as a pointer of type Node.
     * However, in Java, there is no concept of pointers, instead references. Hence,
     * we declare a variable of type "Node" and assign it to a value, it'll store
     * the reference (ie. memory address of the next node in the linked list)
     */
    Node next;

    /*
     * Constructor of Node class
     */
    Node(int value) {
      this.data = value;
      this.next = null;
    }
  }

  /*
   * the HEAD of the Linked List is a public property of the class LinkedList
   */
  static Node head;

  public static void main(String[] args) throws IOException {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
      while (true) {
        System.out.print(
            "\nEnter one of the below keys for action: \n1 - Insert Element At the End of the Linked List\n2 - Print Linked List\n3 - Delete Node At the End of the Linked List\n9 - Quit the Program\n");
        StringTokenizer input = new StringTokenizer(br.readLine());
        int key = Integer.parseInt(input.nextToken());
        switch (key) {
          case 1:
            System.out.println("\nEnter Value: ");
            input = new StringTokenizer(br.readLine());
            int value = Integer.parseInt(input.nextToken());
            insertNodeInTheEnd(value);
            break;

          case 2:
            printLinkedList();
            break;

          case 3:
            deleteNodeInTheEnd();
            break;

          case 9:
            System.out.print("\nThank you for using LinkedList. Bye!\n");
            return;
          default:
            System.out.print("\nInvalid Input\n");
        }

      }

    }
  }

  private static void insertNodeInTheEnd(int value) {
    if (head == null) {
      Node temp = new Node(value);
      head = temp;
      return;
    }
    Node temp = head;
    while (temp.next != null) {
      temp = temp.next;
    }
    Node newNode = new Node(value);
    temp.next = newNode;
    return;
  }

  private static void printLinkedList() {
    System.out.print("\nLinked List: \n");
    Node temp = head;
    while (temp != null) {
      System.out.print(temp.data + " -> ");
      temp = temp.next;
    }
    return;
  }

  private static void deleteNodeInTheEnd() {
    Node temp = head;
    if (temp == null) {
      System.out.println("Error: LinkedList is empty already");
      return;
    }

    Node prev = null;
    while (temp.next != null) {
      prev = temp;
      temp = temp.next;
    }
    if (prev == null) {
      /*
       * Only One node (ie. the HEAD is present in the Linked List)
       */
      head = null;
    } else {
      prev.next = null;
    }
    return;
  }
}