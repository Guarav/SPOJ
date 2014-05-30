
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by gaurav on 5/30/14.
 */
public class Main {


    public static void main(String [] args)
    {
//        Scanner scanner = new Scanner(System.in);
        InputReader inputReader = new InputReader(System.in);
//        int t = Integer.parseInt(scanner.nextLine());
        int t = Integer.parseInt(inputReader.nextLine());
        while(t-->0)
        {
//            String input = scanner.nextLine().trim();
            String input = inputReader.nextLine().trim();
            Map<String, Boolean> map = new HashMap<String, Boolean>();
            String []words = input.split("\\s+");
            for(String s : words)
                map.put(s, true);


            if(input.isEmpty())
                System.out.println(0);
            else
                System.out.println(map.keySet().size());

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




