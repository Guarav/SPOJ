
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by poplig on 2/28/15.
 */
public class Main {

    private static int maxElement = 1001;

    private int n;

    private int elem[] = new int[maxElement];

    public static void main(String [] args) {
//        Scanner scanner = new Scanner(System.in);
        InputReader inputReader = new InputReader(System.in);
//        int t = scanner.nextInt();
        int t = inputReader.nextInt();
        int [] elements = new int[maxElement];
        while(t-->0) {
            int n = inputReader.nextInt();
//            int n = scanner.nextInt();
            for(int i = 0; i < n; ++i) {
//                elements[i] = scanner.nextInt();
                elements[i] = inputReader.nextInt();
            }

            int ans = new Main(elements, n).getMaxSubsequence();
            System.out.println(ans);

        }
    }

    Main(int [] elem, int n) {
        this.elem = elem;
        this.n = n;
    }

    public int getMaxSubsequence() {

        Position [] positions = new Position[n];

        int maxFound = 0;
        for(int i = 0; i < n; ++i) {

            positions[i] = new Position(1, 1);

            for(int j = 0;j < i; ++j) {

                if( elem[j] > elem[i] ) {
                    // Case where there is  decrement.
                    // take the counter from the position and then take action.
                    int decCounter = positions[j].getDownCounter();

                    positions[i].setDownCounter(Math.max( decCounter+1, positions[i].getDownCounter() ));

                } else if(elem[j] < elem[i]) {
                    int upCounter = positions[j].getUpCounter();

                    positions[i].setUpCounter( Math.max(positions[i].getUpCounter(), upCounter + 1) );
                    positions[i].setDownCounter( Math.max(positions[i].getDownCounter(),
                            Math.max(positions[i].getUpCounter(), upCounter + 1) ));
                }


            }

            if(positions[i].getDownCounter() > maxFound) {
                maxFound = positions[i].getDownCounter();
            }

        }

        return maxFound;
    }

}

class Position {

    Position(int a, int b) {
        this.upCounter = a;
        this.downCounter = b;
    }

    int upCounter;

    int downCounter;

    public int getUpCounter() {
        return upCounter;
    }

    public int getDownCounter() {
        return downCounter;
    }

    public void setUpCounter(int upCounter) {
        this.upCounter = upCounter;
    }

    public void setDownCounter(int downCounter) {
        this.downCounter = downCounter;
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
