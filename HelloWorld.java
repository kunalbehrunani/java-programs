public class HelloWorld {
  public static void main(String[] args) {
    System.out.println("Hello World");

    LinkedListV2 ll = new LinkedListV2();
    ll.insertAtEnd(10);
    ll.insertAtEnd(24);
    ll.insertAtEnd(36);
    ll.print();
    ll.insertAtIndex(1, 94);
    ll.print();
    ll.insertAtIndex(10, 112);
    ll.print();
    ll.insertAtIndex(0, 199);
    ll.print();
  }
}
