import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int target = Integer.parseInt(br.readLine());
            long[] d = new long[target + 1];

            // Handle base cases
            if (target >= 1) d[1] = 1;
            if (target >= 2) d[2] = 1;
            if (target >= 3) d[3] = 1;
            if (target >= 4) d[4] = 2;
            if (target >= 5) d[5] = 2;

            // Fill the dp array for values greater than 5
            for (int i = 6; i <= target; i++) {
                d[i] = d[i - 5] + d[i - 1];
            }

            // Print the result
            System.out.println(d[target]);
        }
    }
}
