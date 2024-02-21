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

  private Node _head;

  /*
   * Constructor for LinkedListV2 Class, initializes an empty linked list
   */
  LinkedListV2() {
    this._head = null;
  }

  /*
   * Returns the head of the initialized (instance of) linked list (class)
   */
  public Node head() {
    return this._head;
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
    System.out.print("** Linked List: \n");
    while (itrNode != null) {
      System.out.print(itrNode.data + " -> ");
      itrNode = itrNode.next;
    }
    System.out.print("NULL\n\n");
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
      this._head = newNode;
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
    this._head = newHead;
    return;
  }

  /*
   * Insert element at a given position in linked list
   * If size of linked list is less than the specified index, element will be
   * inserted at the end of the linked list
   * 1 -> 2 -> 3 -> 4
   * 0 1 2 3
   */
  public void insertAtIndex(int targetIndex, int value) {
    Node newNode = new Node(value);

    if (this.head() == null) {
      /*
       * Linked List is empty hence, insert element at beginning.
       */
      this._head = newNode;
      return;
    }

    if (targetIndex == 0) {
      newNode.next = this.head();
      this._head = newNode;
      return;
    }

    int currentIndex = 0;
    Node prevNode = null;
    Node currNode = this.head();

    while (currentIndex < targetIndex && currNode != null) {
      prevNode = currNode;
      currNode = currNode.next;
      currentIndex += 1;
    }

    prevNode.next = newNode;
    newNode.next = currNode;
    return;
  }
}
