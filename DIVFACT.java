
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by poplig on 8/15/15.
 */
public class Main {

    private static final int MAX_NUMBER = 50000;
    private static int[] primeNumbers = new int[50000];
    private static int TOTAL_PRIME_NUMBERS = 0;
    private static int MOD = 1000000007;

    Main() {

    }

    public static void main(String[] args) {

        prepareSieve();


        InputReader inputReader = new InputReader(System.in);

        int t = inputReader.nextInt();

        while(t-->0) {

            int n = inputReader.nextInt();

            // calculate the number of prime number factors.
            long ans = 1;
            for(int i = 0; primeNumbers[i] <= n ; ++i) {

                int temp = primeNumbers[i];
                int count = 0;
                while (n / temp >= 1) {

                    count += n / temp;
                    temp = temp * primeNumbers[i];
                }

                if(count == 0 ) {
                    System.out.println(temp + " "  + primeNumbers[i]);
                }
                ans = (ans * (count + 1)) % MOD;

            }

            System.out.println(ans);
        }




    }

    // prepare sieve
    public static void prepareSieve() {

        boolean[] sieve = new boolean[50000];

        for (int i = 0; i < MAX_NUMBER; ++i) {
            sieve[i] = true;
        }

        for (int i = 2; i < 300; ++i) {
            if (sieve[i]) {

                for (int j = 2; i * j < MAX_NUMBER; ++j) {
                    sieve[i * j] = false;
                }
            }
        }

        // store the prime numbers.
        for (int i = 2; i < MAX_NUMBER; ++i) {
            if (sieve[i]) {
                primeNumbers[TOTAL_PRIME_NUMBERS++] = i;
            }
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
