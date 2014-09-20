import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by poplig on 9/20/14.
 */
public class Main {

    private static final int MAX = 1001;

    public static void main(String [] args) {
        InputReader inputReader = new InputReader(System.in);
//        Scanner scanner = new Scanner(System.in);
        // take the input.
        int n = inputReader.nextInt();
        int input[][] = new int[MAX][MAX];
        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < n; ++j) {
                input[i][j] = inputReader.nextInt();
            }
        }

        Main.printNumber(input, n);

    }

    Main() {

    }

    public static void printNumber(int input[][], int n) {


        // Special cases of n < 3.
        if(n == 2) {
            System.out.println("1 1");
            return;
        }



        // Get the sum with n-3.
        int tempSum1 = input[n-3][n-2] + input[n-3][n-1];

        // Get the sum with n-2.
        int tempSum2 = input[n-2][n-1];

        // Subtraction of tempSum1 and tempSum1 will give twice of n-3.
        int numb = ( tempSum1 - tempSum2 ) / 2;


        String result = "";

        // Get rest of the numbers by using the calculated number.
        for(int i = 0; i < n; ++i) {
            if(i == n - 3) {
                result += (numb + " ");
            } else if(i != n-1) {
                result += (input[i][n-3] - numb + " ");
            } else {
                result += (input[i][n-3] - numb);
            }
        }
        System.out.println(result);
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

    public String nextLine(){
        String line ="";
        try {
            line = reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return line;
    }

    public int nextInt(){
        return Integer.parseInt(next());
    }

    public double nextDouble(){
        return Double.parseDouble(next());
    }

    public long nextLong(){
        return Long.parseLong(next());
    }

}

