import java.io.*;

public class Test {
    public static void main (String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter Cordinates...");

        String rec1 = reader.readLine();
        String rec2 = reader.readLine();

        String[] rec1Parts = rec1.split(" ");
        String[] rec2Parts = rec2.split(" ");

        int rec1x1 = Integer.parseInt(rec1Parts[0]);
        int rec1y1 = Integer.parseInt(rec1Parts[1]);
        int rec1x2 = Integer.parseInt(rec1Parts[2]);
        int rec1y2 = Integer.parseInt(rec1Parts[3]);

        int rec2x1 = Integer.parseInt(rec2Parts[0]);
        int rec2y1 = Integer.parseInt(rec2Parts[1]);
        int rec2x2 = Integer.parseInt(rec2Parts[2]);
        int rec2y2 = Integer.parseInt(rec2Parts[3]);

        int minX = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxY = Integer.MIN_VALUE;

        int[] x = { rec1x1, rec1x2, rec2x1, rec2x2 };
        int[] y = { rec1y1, rec1y2, rec2y1, rec2y2 };

        for (int i = 0; i < 4; i += 1) {
            if (minX < x[i]) {
                minX = x[i];
            }
            if (maxX > x[i]) {
                maxX = x[i];
            }
            if (minY < y[i]) {
                minY = y[i];
            }
            if (maxY > y[i]) {
                maxY = y[i];
            }
        }
        int ans = Math.max(maxX - minX, maxY - minY);
        System.out.println(ans);



        
        

    }

    
}
