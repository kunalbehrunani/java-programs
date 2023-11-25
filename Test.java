import java.io.*;

public class Test {
    public static void main (String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();
        String[] inputParts = input.split(" ");

        int x = Integer.parseInt(inputParts[0]);
        int y = Integer.parseInt(inputParts[1]);
        int a = Integer.parseInt(inputParts[2]);
        int b = Integer.parseInt(inputParts[3]);

        int p = Integer.min(a, b);
        int q = Integer.max(a, b);

        int ans1 = Math.abs(x-y);
        int ans2 = Math.abs(x-p) + Math.abs(y-q);

        int ans = Math.min(ans1, ans2);
        
        System.out.println("x: " + x);
        System.out.println("y: " + y);
        System.out.println("a: " + a);
        System.out.println("b: " + b);
        System.out.println("p: " + p);
        System.out.println("q: " + q);
        System.out.println("ans1: " + ans1);
        System.out.println("ans2: " + ans2);
        System.out.println("ans: " + ans);
        

    }

    
}
