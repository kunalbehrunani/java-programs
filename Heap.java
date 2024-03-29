
/*
 * For prototype, below is a representation of Max Heap
 */
public class Heap {
  private int size;
  private int maxSize;
  private int[] elements;

  Heap(int s) {
    /*
     * An Array to store the Heap (a kind of complete binary tree stored in array
     * representation) is initialized with size = s
     * Initially the size of the heap is 0 as no elements are inserted yet.
     */
    this.size = 0;
    this.maxSize = s;
    this.elements = new int[s + 1];

    /*
     * Heap is implemented in 1-based indexing
     */
    this.elements[0] = -1;
    return;
  }

  /*
   * Get the (Current) Size of the Heap
   */
  public int size() {
    return this.size;
  }

  /*
   * Get the Maximum Size of the Heap
   */
  public int maxSize() {
    return this.maxSize;
  }

  /*
   * Print the Heap
   */
  public void print() {
    if (this.size < 1) {
      System.out.print("Error: Heap is Empty.\n");
      return;
    }
    System.out.print("Heap : ");
    for (int i = 1; i <= this.size; i += 1) {
      System.out.print(this.elements[i] + ", ");
    }
    System.out.print("\n");
  }

  /*
   * Add new Element in the Heap
   */
  public void add(int ele) {
    if (this.size() >= this.maxSize) {
      System.out.print("Error: Heap is Full.\n");
      return;
    }
    this.size += 1;
    this.elements[this.size] = ele;
    this.restoreUp(this.size);
    return;
  }

  private void restoreUp(int index) {
    int childIndex = index;
    int parentIndex = (int) (childIndex / 2);
    int size = this.size;

    // if (parentIndex < 1) {
    // return;
    // }
    while (childIndex <= size && parentIndex > 0) {
      if (this.elements[parentIndex] >= this.elements[childIndex]) {
        break;
      }

      /*
       * Swap Child and Parent to make them follow the Max Heap Nature.
       */
      int temp = this.elements[childIndex];
      this.elements[childIndex] = this.elements[parentIndex];
      this.elements[parentIndex] = temp;

      childIndex = parentIndex;
      parentIndex = childIndex / 2;
    }
    return;
  }

  public int delete() {
    if (this.size < 1) {
      // throw new Error("Heap is Empty.");
      System.out.print("Error: Heap Size is Empty.\n");
      return -1;
    }
    /*
     * Swap Root and last element in the Heap
     */
    int temp = this.elements[1];
    this.elements[1] = this.elements[this.size];
    this.elements[this.size] = temp;

    this.size -= 1;

    this.restoreDown(1);
    System.out.print("Deleted (Max) Item: " + temp + "\n");
    return temp;
  }

  private void restoreDown(int index) {
    int parentIndex = index;
    int leftChildIndex = 2 * index;
    int rightChildIndex = 2 * index + 1;

    if (leftChildIndex > this.size) {
      /*
       * Do Nothing
       */
    } else if (leftChildIndex == this.size()) {
      /*
       * Compare Parent with Left Child Only
       */
      if (this.elements[parentIndex] < this.elements[leftChildIndex]) {
        int temp = this.elements[parentIndex];
        this.elements[parentIndex] = this.elements[leftChildIndex];
        this.elements[leftChildIndex] = temp;
      }
    } else {
      /*
       * Compare Parent with Both Right & Left Child
       */
      if (this.elements[leftChildIndex] < this.elements[rightChildIndex]) {
        int temp = this.elements[parentIndex];
        this.elements[parentIndex] = this.elements[rightChildIndex];
        this.elements[rightChildIndex] = temp;
        this.restoreDown(rightChildIndex);
      } else {
        int temp = this.elements[parentIndex];
        this.elements[parentIndex] = this.elements[leftChildIndex];
        this.elements[leftChildIndex] = temp;
        this.restoreDown(leftChildIndex);
      }
    }
    return;
  }
}
