import java.io.*;

public class PassingArgumentsInFunction {
    public static void main(String[] args) throws IOException {
        // int x = 1;
        // updateInt(x);
        // System.out.println("x: " + x);

        String str = new String("xyz");
        updateString(str);
        System.out.println("-- in method main, str: " + str);

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
         * not (Ref: updateStringV1)
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
        System.out.println("-- in method updateStringV1, str: " + str);

        str = new String("pqr");
        /*
         * At this point, the copy of the reference that was passed in this function
         * calls points to the new string object created (in the local scope ie. this
         * function). When we return from this function, the original string would
         * remain unchanged.
         */
        System.out.println("-- in method updateStringV1, str: " + str);

        return;
    }

}
