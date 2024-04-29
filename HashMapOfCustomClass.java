import java.io.*;
import java.util.*;

/*
 * Custom (User Defined) Class
 */
class Interval {
  int start;
  int end;

  /*
   * Custom Class Constructor
   */
  public Interval(int st, int ed) {
    this.start = st;
    this.end = ed;
    return;
  }

  /*
   * Ref: https://www.geeksforgeeks.org/overriding-equals-method-in-java/
   */
  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }

    if (obj == null || !(obj instanceof Interval)) {
      return false;
    }

    /*
     * Typecase Object to Interval
     */
    Interval objInterval = (Interval) obj;

    /*
     * Define custom logics to declare the equality nature for various objects
     */
    if (this.start == objInterval.start && this.end == objInterval.end) {
      return true;
    }

    return false;
  }

  /*
   * Object variables in Java are always stored / identified by reference. Hence
   * when we create 2 objects with same value of distinct properties of the custom
   * class, and check if they're equal or not using Object.equals() method, it
   * returns false because JAVA internally compares the 2 objects using its
   * references (memory address) which obviously isn't equal for both of them.
   * 
   * If we wish to identify 2 instances of a custom class as equals based on the
   * values of it's parameters (or any other custom / user defined logic), then we need to override the "equals" method of the
   * custom class. Note that "equals" (and many other functions of the Object class
   * are by default inherited to any custom class that we create).
   * 
   * The same goes when we try to use a Hashmap with a custom class. Everytime we
   * "put" a custom class instantiated "key" in the hashmap, and then try to "get"
   * the "value" against this custom class instantiated "key", we get null.
   * Because, internally, JAVA uses "equals" & "hashCode" method of the object
   * class to identify if 2 keys (which are nothing but instances of the custom
   * class) are same or not.
   * 
   * Note - Just by defining an override function for "equals" method, will not
   * ensure that Hashmap's "get" and "put" function will identify 2 keys as equal.
   * We also need to define the default inherited method - "hashCode" from the
   * Object class as well. Why? hashCode function is responsible for returning a
   * unique hashCode for every instance of the class. If 2 instances of a class
   * are supposed to be equal, then there hashCode function should also return the
   * same value, and similarly, if 2 instances of a class are not supposed to be
   * equal, then there hashCode function should also return different values.
   * 
   * In common practice, we mostly define a custom class with upto 2 different
   * elements, and hence, a common algorithm for defining a hashCode function with
   * 2 input parameters is to find the max value of the 1st parameter (say for eg.
   * N), then our resultant hashcode should return param1 * MAX_VALUE + param2.
   * 
   * This way, the modulus operator will give us param2 and divide operator will
   * give us param1 and thus ensuring for 2 different pairs (param1, param2), the
   * hashCode will always be different and similarly for 2 same pairs (param1,
   * param2), the hashCode will always be same.
   * 
   */
  @Override
  public int hashCode() {
    int MAX_VALUE = 805;
    return this.start * MAX_VALUE + this.end;
  }
}

public class HashMapOfCustomClass {

  public static void main(String[] args) throws IOException {

    HashMap<Interval, Integer> map = new HashMap<Interval, Integer>();

    map.put(new Interval(1, 1), 10);
    map.put(new Interval(5, 7), 21);
    map.put(new Interval(8, 9), 26);

    Interval i1 = new Interval(1, 5);
    Interval i2 = new Interval(1, 5);
    Interval i3 = new Interval(2, 4);

    System.out.println(i1.equals(i2));
    System.out.println(i1.equals(i3));

    System.out.println(map.get(new Interval(2, 4)));
    System.out.println(map.get(new Interval(8, 9)));

  }

}
