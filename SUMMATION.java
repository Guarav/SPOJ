import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

/**
 * Created by poplig on 8/20/17.
 */
public class Main {

    public static void main(String []args) {

        InputReader inputReader = new InputReader(System.in);
        int t = inputReader.nextInt();

        for(int j = 0; j < t; ++j) {

            int n = inputReader.nextInt();

            BigInteger bigInteger = BigInteger.ZERO;
            for(int i = 0; i < n; ++i) {

                int num = inputReader.nextInt();
                bigInteger = bigInteger.add(BigInteger.valueOf(num));
            }

            bigInteger = bigInteger.multiply( BigInteger.valueOf(2).pow(n-1) );
            bigInteger = bigInteger.mod(BigInteger.valueOf(100000007));

            System.out.println("Case " + (j+1) + ": " + bigInteger);

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


