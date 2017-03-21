import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by poplig on 3/20/17.
 */
public class ADAQUEUE {


    private static int low = -1;

    private static int high = -1;

    private final static int FIRST_ELEMENT_INDEX = 1000010;

    private static boolean reverseMode;

    public static void readFront(int [] numberArray) {

        if((reverseMode && high > low) || (!reverseMode && low > high) || low == -1) {
            System.out.println("No job for Ada?");
            return;
        }

        System.out.println(numberArray[low]);
        if(reverseMode) {
            low--;
        } else {
            low++;
        }


    }

    public static void readBack(int [] numberArray) {

        if((reverseMode && high > low) || (!reverseMode && low > high) || low == -1) {
            System.out.println("No job for Ada?");
            return;
        }

        System.out.println(numberArray[high]);
        if(reverseMode) {
            high++;
        } else {
            high--;
        }


    }

    public static void addToFront(int [] numberArray, int value) {


        if(high == -1) {
            high = FIRST_ELEMENT_INDEX;
            low = FIRST_ELEMENT_INDEX;
        } else {
            if(reverseMode) {
                low++;
            } else {
                low--;
            }
        }


        numberArray[low] = value;

    }

    public static void addToBack(int []numberArray, int value) {

        if(low == -1) {
            high = FIRST_ELEMENT_INDEX;
            low = FIRST_ELEMENT_INDEX;
        } else {
            if(reverseMode) {
                high--;
            } else {
                high++;
            }
        }

        numberArray[high] = value;

    }

    public static void main (String [] args) {

        InputReader inputReader = new InputReader(System.in);
        int numQueries = inputReader.nextInt();

        int []numberArray = new int[2000020];
        reverseMode = false;

        while (numQueries --> 0) {

            String inputLine = inputReader.nextLine();

            // see if it contains 2 space separated inputs.
            String [] inputs = inputLine.split(" ");

            if(inputs.length == 1) {

                // possibilities
                // front. need to print front.
                if("front".equals(inputs[0])) {
                    readFront(numberArray);
                } else if("back".equals(inputs[0])) {
                    // back. need to print back.
                    readBack(numberArray);
                } else {

                    int temp = low;
                    low = high;
                    high = temp;
                    reverseMode = !reverseMode;
                }


            } else {

                int value = Integer.valueOf(inputs[1]);
                // possibilities.
                if("toFront".equals(inputs[0])) {
                    addToFront(numberArray, value);
                } else if("push_back".equals(inputs[0])) {
                    addToBack(numberArray, value);
                }

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

