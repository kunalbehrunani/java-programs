import java.io.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

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
    }
}
