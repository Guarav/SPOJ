import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by poplig on 8/9/15.
 */
public class Main {

    public static void main(String [] args) {
        InputReader inputReader = new InputReader(System.in);
        OutputWriter outputWriter = new OutputWriter(System.out);
        int t = inputReader.nextInt();
        int [] pattern = {6, 3, 9, 2};
        while(t-->0) {
            int n = inputReader.nextInt();
            int m = inputReader.nextInt();

            int numLastDigit = 5 + 4*pattern[m%4];
            numLastDigit = numLastDigit%10;

            int denLastDigit = 5 + 4*pattern[n%4];
            denLastDigit = denLastDigit%10;

            for(int i = 0; i < 10; ++i) {
                if(denLastDigit*i % 10 == numLastDigit) {
                    outputWriter.println(i);
                    break;
                }
            }


        }

        outputWriter.close();
    }

    Main() {

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


class OutputWriter {
    private final PrintWriter writer;

    public OutputWriter(OutputStream outputStream) {
        writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
    }

    public OutputWriter(Writer writer) {
        this.writer = new PrintWriter(writer);
    }

    public void print(Object... objects) {
        for (int i = 0; i < objects.length; i++) {
            if (i != 0)
                writer.print(' ');
            writer.print(objects[i]);
        }
    }

    public void println(Object... objects) {
        print(objects);
        writer.println();
    }

    public void close() {
        writer.close();
    }

}
