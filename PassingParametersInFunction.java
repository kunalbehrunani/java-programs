import java.io.*;

public class PassingParametersInFunction {
    public static void main(String[] args) throws IOException {
        int x = 1;
        updateInt(x);
        System.out.println("x: " + x);
        return;
    }

    public static void updateInt(int x) {
        x += 1;
        return;
    }
}
