public class HelloWorld {
  public static void main(String[] args) {
    System.out.println("Hello World");

    LinkedListV2 ll = new LinkedListV2();
    ll.insertAtEnd(10);
    ll.insertAtEnd(20);
    ll.insertAtEnd(30);
    ll.insertAtIndex(1, 40);
    ll.insertAtIndex(10, 50);
    ll.insertAtIndex(0, 60);
    ll.print();

    LinkedListV2 ll2 = new LinkedListV2();
    ll2.insertAtEnd(25);
    ll2.insertAtEnd(50);
    ll2.insertAtIndex(1, 75);
    ll2.insertAtIndex(10, 100);
    ll2.print();
  }
}
