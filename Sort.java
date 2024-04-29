public class Sort {

  public void heapSort(int[] arr) {
    /*
     * Assume the input array is an "array representation" of a heap. But since
     * elements are not following the "heap" nature, ie. parent is always greater
     * than or equal to it's childs, the initial size of the heap is supposed to be
     * zero. And all elements are inserted in the heap iteratively. Then, all
     * elements are deleted from the heap and deleted elements are stored in the
     * remaining space of the heap (array).
     */

  }

  public void add(int[] arr, int size, int ele) {
    size += 1;
    arr[size] = ele;
    this.restoreUp(arr, size);
    return;
  }

  private void restoreUp(int[] arr, int index) {
    int childIndex = index;
    int parentIndex = (int) (childIndex / 2);

    while (parentIndex > 0) {
      if (arr[parentIndex] >= arr[childIndex]) {
        break;
      }

      /*
       * Swap Child and Parent to make them follow the Max Heap Nature.
       */
      int temp = arr[childIndex];
      arr[childIndex] = arr[parentIndex];
      arr[parentIndex] = temp;

      childIndex = parentIndex;
      parentIndex = childIndex / 2;
    }
    return;
  }

  public int delete(int[] arr, int size) {
    /*
     * Swap Root and last element in the Heap
     */
    int temp = arr[1];
    arr[1] = arr[size];
    arr[size] = temp;

    size -= 1;

    this.restoreDown(arr, 1, size);
    return temp;
  }

  private void restoreDown(int[] arr, int index, int size) {
    int parentIndex = index;
    int leftChildIndex = 2 * index;
    int rightChildIndex = 2 * index + 1;

    if (leftChildIndex > size) {
      /*
       * Do Nothing
       */
    } else if (leftChildIndex == size) {
      /*
       * Compare Parent with Left Child Only
       */
      if (arr[parentIndex] < arr[leftChildIndex]) {
        int temp = arr[parentIndex];
        arr[parentIndex] = arr[leftChildIndex];
        arr[leftChildIndex] = temp;
      }
    } else {
      /*
       * Compare Parent with Both Right & Left Child
       */
      if (arr[leftChildIndex] < arr[rightChildIndex]) {
        int temp = arr[parentIndex];
        arr[parentIndex] = arr[rightChildIndex];
        arr[rightChildIndex] = temp;
        this.restoreDown(rightChildIndex, arr);
      } else {
        int temp = arr[parentIndex];
        arr[parentIndex] = arr[leftChildIndex];
        arr[leftChildIndex] = temp;
        this.restoreDown(leftChildIndex, arr);
      }
    }
    return;
  }

}
