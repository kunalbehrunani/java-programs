import java.io.*;

public class PassingArgumentsInFunction {
    public static void main(String[] args) throws IOException {
        // int x = 1;
        // updateInt(x);
        // System.out.println("x: " + x);

        // String str = new String("xyz");
        // updateString(str);
        // System.out.println("-- in method main, str: " + str);

        StringBuilder strB = new StringBuilder("xyz");
        updateStringBuilder(strB);
        System.out.println("-- in method main, strB: " + strB);

    }

    public static void updateInt(int x) {
        /*
         * Integers are primitive data types in Java.
         * Primitive data types are stored in Stack memory.
         * Whenever a primitive data type is passed in a function,
         * A copy of the primitive data type variable is created,
         * And, passed into the function.
         */
        x += 1;
        System.out.println("-- in method updateInt, x: " + x);
        return;
    }

    public static void updateString(String str) {
        /*
         * Strings (in Java) is a class instead of primitive. Therefore, at runtime, the
         * reference of the instance (object) of the string class, Is passed in the
         * function.
         * 
         * Hence, Ideally, if we alter the string in a function, the updated value
         * should reflect in the original string, in the main function, however, it is
         * not (Ref: updateString)
         * 
         * The reason for this is because objects of the "String" class are immutable
         * ie. Once instantiated, the value of the variable cannot be changed.
         * 
         * Then, why is that operations like += appear to change the value of string in
         * the local scope? It is because it appears to us that the value of the
         * variable str has changed. However, in reality, for operations like str = str
         * + "abc", a new object with the updated value is created (in the local scope)
         * and assigned to the variable name - "str". This explains why when we move out
         * of the scope of the function, and move back to main function, the original
         * value of the variable is not changed.
         * 
         * 
         * In other words, when an object is passed in a function, it seems that it is
         * passed by reference, but instead, a copy of the reference of the object is
         * passed in the function. whenever we alter the object value (inside the
         * function), the "copy of the reference" now points to the updated value (ie.
         * the new value). At any given time, the original reference of the object
         * points to the same old value. This precisely explains the immutable nature of
         * strings (which is nothing but an object of String class) in Java.
         */
        str += "abc";
        System.out.println("-- in method updateString, str: " + str);

        str = new String("pqr");
        /*
         * At this point, the copy of the reference that was passed in this function
         * calls points to the new string object created (in the local scope ie. this
         * function). When we return from this function, the original string would
         * remain unchanged.
         */
        System.out.println("-- in method updateString, str: " + str);

        return;
    }

    private static void updateStringBuilder(StringBuilder strB) {
        /*
         * Just like String class in Java represents a sequence of characters that are
         * immutable in nature ie. once a string class is initialized with a set of
         * characters, it cannot be changed. Every time a string value is changed, then
         * internally that means a new string was created and assigned to the copy of
         * reference.
         * 
         * Similar to it, StringBuilder is a class in Java that, upon instantiation,
         * represents a sequence of characters that are "mutable" in nature. Ie. when
         * passed in a function, the reference points to the original value. And when
         * the string(builder) is altered inside the function, the change reflects in
         * the original value of the StringBuilder.
         * 
         * StringBuilder is more preferred way for dealing with strings when we require
         * to do lot of operations on the string. The idea of StringBuilder can be
         * intuitively understood as - we can use StringBuilder to do as many
         * operations as we want and "build" our desired "string". Once our sequence of
         * characters as per our required string is ready, and we want to use it as
         * string,
         * we can leverage the ".toString()" method of this class. In other words, as
         * the name of this
         * class suggests, it allows us to build our string in whatever way we want
         * without being concerned with the immutable nature of String data types in
         * Java.
         * 
         * StringBuilder is similar to StringBuffer class in Java except StringBuilder
         * is more optimized for single threaded operations (which is most of the
         * cases), hence, it is preferred to use StringBuilder over StringBuffer
         * as well as String Class in Java.
         */
        strB.append("_abc");
        System.out.println("-- in method updateStringBuilder, strB: " + strB);
        return;
    }
}
