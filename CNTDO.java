import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * Created by poplig on 7/3/16.
 */
public class Main {

    public static void main(String [] args) {

        InputReader inputReader = new InputReader(System.in);
        int t = inputReader.nextInt();

        while (t-->0) {
            int n = inputReader.nextInt();
            Map<Integer, Boolean> numberPresence = new HashMap<Integer, Boolean>(n);
            for(int i = 0; i < n; ++i) {
                int numb = inputReader.nextInt();
                numberPresence.put(numb, true);
            }

            int count = 0;
            for(Integer key : numberPresence.keySet()) {
                if(numberPresence.get(key*2) != null) {
                    count++;
                }
            }

            System.out.println(count);
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
