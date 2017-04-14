import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by poplig on 4/15/17.
 */
public class Main {

    public static void main(String [] args) {
        InputReader inputReader = new InputReader(System.in);

        int t = inputReader.nextInt();
        while(t-->0) {
            long y = inputReader.nextLong();

            double temp = 1 + 8*y;
            double sqrt = Math.sqrt(temp);

            if(!(sqrt-Math.floor(sqrt) > 0)) {

                int ans = (int) (sqrt - 1)/ 2;
                System.out.println(ans);

            } else {
                System.out.println("NAI");
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

