import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by poplig on 2/26/17.
 */
public class NHAY {

    public static void main(String [] args) throws Exception {

        InputReader inputReader = new InputReader(System.in);

        while(inputReader.nextLine() != null) {

            String needle = inputReader.next();
            String haystack = inputReader.next();

            int lastIndex = 0;
            int count = 0;
            while(lastIndex != -1){

                lastIndex = haystack.indexOf(needle,lastIndex);

                if(lastIndex != -1){
                    System.out.println(lastIndex);
                    count ++;
                    lastIndex += needle.length();
                }
            }

            if(count == 0) {
                System.out.println();
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
