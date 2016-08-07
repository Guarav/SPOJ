import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by poplig on 8/8/16.
 */
public class UFPR14D {



    public static void main(String []args) {
        InputReader inputReader = new InputReader(System.in);

        int n = inputReader.nextInt();
        int [] sumArray = new int[n];
        int sum = 0;
        for(int i = 0; i < n; ++i) {

            sum += inputReader.nextInt();
            sumArray[i] = sum;
        }

        int queriesCount = inputReader.nextInt();
        while (queriesCount-- > 0) {
            int a = inputReader.nextInt();
            int b = inputReader.nextInt();

            int lastSum = a > 1 ? sumArray[a-2] : 0;

            int diff = sumArray[b-1] - lastSum;
            System.out.println(diff);
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
