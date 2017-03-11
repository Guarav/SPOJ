import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by poplig on 3/12/17.
 */
public class AGGRCOW {

    public static void main(String [] args) {
        InputReader inputReader = new InputReader(System.in);

        int t = inputReader.nextInt();

        while (t-->0) {
            int n = inputReader.nextInt();
            int c = inputReader.nextInt();


            int []posn = new int[n];
            for(int i=0;i < n; ++i) {
                posn[i] = inputReader.nextInt();
            }


            // sort the array.
            Arrays.sort(posn);

            // apply the binary search on the function func.
            int ans = applyBS(posn, n, c);

            System.out.println(ans);


        }



    }

    public static int applyBS(int []pos, int n, int c) {

        int low = 0;
        int high = pos[n-1];

        while (low < high) {

            int mid = (low+high) / 2;

            if(func(pos, mid, c, n)) {
                low = mid + 1;
            } else {
                high = mid;
            }

        }

        return low-1;
    }



    public static boolean func(int [] pos, int mid, int c, int n) {

        int prev = pos[0];
        int count = 1;

        for(int i=1;i < n; ++i) {

            if(pos[i]-prev >= mid) {
                count++;
                if(count == c) {
                    return true;
                }

                prev = pos[i];
            }
        }

        return false;

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

