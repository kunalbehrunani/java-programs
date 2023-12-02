import java.io.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class UserInput {
    public static void main (String[] args) throws IOException {
        BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));

        // Read Input Sentence (a line) with 
        System.out.println("Enter Your Name");
        String name = reader.readLine();
        System.out.println("Hello, " + name);

        // Read an integer
        System.out.println("Enter your Salary");
        int salary = Integer.parseInt(reader.readLine());
        System.out.println(salary);
        System.out.println("Your earn very less, " + name + ". Rs. " + salary + "/- is not sufficient considering the inflation. Work hard buddy!!");

        // Read a line of integers
        System.out.println("Enter a new line to be read (Integers) - ");
        String input = reader.readLine();
        String[] inputParts = input.split(" ");

        int x = Integer.parseInt(inputParts[0]);
        long y = Long.parseLong(inputParts[1]);
        int a = Integer.parseInt(inputParts[2]);
        int b = Integer.parseInt(inputParts[3]);

        System.out.println("x: " + x);
        System.out.println("y: " + y);
        System.out.println("a: " + a);
        System.out.println("b: " + b);

        // Read a line of integers using String Tokenizer
        System.out.println("Enter a new line to be read (Integer, Long, Char, Float) - ");
        StringTokenizer st = new StringTokenizer(reader.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Long.parseLong(st.nextToken());
        char c = st.nextToken().toCharArray()[0];
        float z = Float.parseFloat(st.nextToken());

        System.out.println("x: " + x);
        System.out.println("y: " + y);
        System.out.println("c: " + c);
        System.out.println("z: " + z);

        // Note - BufferedReader is faster than Scanner and hence should be preferred in Competitive Programming
        // Note - String tokenizer is faster than .split() methods on input. Plus, it allows to accept values of different data types in the readLine()

        return;
    }
}
