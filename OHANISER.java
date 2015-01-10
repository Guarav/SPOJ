import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by poplig on 1/4/15.
 */
public class Main {

    private static final int max = 100001;

    private static final int mod = 1000000007;

    public static void main(String[] args) {

        InputReader inputReader = new InputReader(System.in);
        OutputWriter outputWriter = new OutputWriter(System.out);
//        Scanner scanner = new Scanner(System.in);
//        int t = scanner.nextInt();
        int t = inputReader.nextInt();
        int testcase = 1;
        while (t-- > 0) {
//            int n = scanner.nextInt();
            int n = inputReader.nextInt();
            if( n == 1) {
                outputWriter.println("Case " + testcase + ": 1" );
            } else {
                long ans = (n+1) * (getPower(2, n-2));
                outputWriter.println("Case " + testcase + ": " + ans%mod);
            }
            testcase++;

        }

        outputWriter.close();

    }

    public static long getPower(long base, long exponent) {
        if(exponent == 0) {
            return 1;
        }

        long temp = getPower(base, exponent/2);
        if(exponent % 2 == 0) {
            return (temp*temp)%mod;
        } else {
            return ( (temp*temp)%mod ) * (base);
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

class OutputWriter {
    private final PrintWriter writer;

    public OutputWriter(OutputStream outputStream) {
        writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
    }

    public OutputWriter(Writer writer) {
        this.writer = new PrintWriter(writer);
    }

    public void print(Object...objects) {
        for (int i = 0; i < objects.length; i++) {
            if (i != 0)
                writer.print(' ');
            writer.print(objects[i]);
        }
    }

    public void println(Object...objects) {
        print(objects);
        writer.println();
    }

    public void close() {
        writer.close();
    }

}


