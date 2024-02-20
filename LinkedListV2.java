public class LinkedListV2 {

  public class Node {
    int data;

    Node next;

    /*
     * Constructor for Node Class
     */
    Node(int value) {
      this.data = value;
      this.next = null;
    }
  }

  private Node head;

  /*
   * Constructor for LinkedListV2 Class, initializes an empty linked list
   */
  LinkedListV2() {
    this.head = null;
  }

  /*
   * Returns the head of the initialized (instance of) linked list (class)
   */
  public Node head() {
    return this.head;
  }

  /*
   * Print the Linked List
   */
  public void print() {
    Node itrNode = this.head();
    if (itrNode == null) {
      System.out.print("    Error: LinkedList is Empty\n");
      return;
    }
    System.out.print("    Linked List: \n");
    while (itrNode != null) {
      System.out.print(itrNode.data + " -> ");
      itrNode = itrNode.next;
    }
    System.out.print("END\n");
    return;
  }

  /*
   * Insert element at the end of the linked list
   */
  public void insertAtEnd(int value) {
    /*
     * Create new Node with data == "value"
     */
    Node newNode = new Node(value);

    Node itrNode = this.head();
    if (itrNode == null) {
      this.head = newNode;
    } else {
      while (itrNode.next != null) {
        itrNode = itrNode.next;
      }
      itrNode.next = newNode;
    }
    return;
  }

  /*
   * Insert element at the beginning of the linked list
   */
  public void insertAtBeginning(int value) {
    Node newHead = new Node(value);
    Node currHead = this.head();
    newHead.next = currHead;
    this.head = newHead;
    return;
  }
}
