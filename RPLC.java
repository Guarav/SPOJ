import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by poplig on 2/26/17.
 */
public class Main {

    public static void main(String [] args) {

        InputReader inputReader = new InputReader(System.in);
        int t = inputReader.nextInt();

        for(int cs = 0; cs < t; ++cs ) {
            int n = inputReader.nextInt();

            long totalSum = 0;
            long minRequired = 0;
            for(int i = 0; i < n; ++i) {
                long num = inputReader.nextLong();

                totalSum += num;

                if(totalSum <= 0) {
                    minRequired += 1 - totalSum;
                    totalSum = 1;
                }

            }

            System.out.println("Scenario #" + (cs+1)  + ": " + minRequired);
         }

    }

}


class InputReader {
    private BufferedReader reader;
    private StringTokenizer tokenizer;

    public InputReader(InputStream stream) {
        reader = new BufferedReader(new InputStreamReader(stream));
        tokenizer = null;
    }

    public String next() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return tokenizer.nextToken();
    }

    public String nextLine() {
        String line = "";
        try {
            line = reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return line;
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public double nextDouble() {
        return Double.parseDouble(next());
    }

    public long nextLong() {
        return Long.parseLong(next());
    }

}
