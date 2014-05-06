import java.io.*;
import java.util.*;
import java.util.concurrent.SynchronousQueue;

/**
 * Created by gaurav on 5/4/14.
 */
public class Main {


    private static final Map<Integer, List<Integer>> mapping = new HashMap<Integer ,List<Integer>>();

    private static PrintWriter printWriter = new PrintWriter(System.out);

    public static void main(String [] args)
    {
        precompute();


        InputReader inputReader = new InputReader(System.in);
        int t = inputReader.nextInt();
        while(t-->0)
        {
            int p = inputReader.nextInt();
            int x = inputReader.nextInt();
            new Main().calculate(p, x);
        }

        printWriter.close();


    }

    public static void precompute()
    {
        for(int i = 1; i < 10; ++i)
        {
            int j = 1;
            List<Integer> list = new ArrayList<Integer>();
            while(j < 10)
            {
                list.add(j);
                j++;
            }

            mapping.put(i, list);
        }
    }

    public void calculate(int noOfDigits, int multiplier)
    {
//        List<Integer> list = mapping.get(multiplier);
//        boolean res = false;
//        for(Integer i : list)
//        {
//            res = calculate(i, noOfDigits, multiplier);
//            if(res)
//                break;
//        }
//        if(!res)
//            printWriter.println("Impossible");

        // store all the last digits possible
        List<Integer> list = new ArrayList<Integer>();
        int j = 1;
        while( j < 10)
        {
            list.add(j);
            j++;
        }

        boolean ans = false;
        for(Integer i : list)
        {
            ans = cacluate1(noOfDigits, multiplier, i);
            if(ans)
                break;
        }

        if(!ans)
            printWriter.println("Impossible");





    }

    public boolean cacluate1(int noOfDigits, int multiplier, int lastDigit)
    {
        int numberArray[] = new int[noOfDigits];
        int []finalNumArray = new int[noOfDigits];
        numberArray[noOfDigits-1] = lastDigit;

        int carry = 0;
        for(int i = noOfDigits-1; i > 0; --i )
        {
            int temp = numberArray[i] * multiplier + carry;
            int res = temp % 10;
            numberArray[i-1] = res;
            carry = temp / 10;
        }



        if( numberArray[0] * multiplier + carry == numberArray[noOfDigits-1] && numberArray[0] != 0 )
        {
            for(int i = 0; i < noOfDigits; ++i)
//                System.out.print(numberArray[i]);
                printWriter.print(numberArray[i]);
            printWriter.println();

            return true;
        }

        return false;
    }

    public boolean calculate(int first, int noOfDigits, int multiplier)
    {
        // now we are supposed to find the last digit
        List<Integer> list = new ArrayList<Integer>();
        int num = multiplier*first;
        while(num < 10)
        {
            list.add(num);
            num++;
        }

//        now check for each num in list with which it is possible
        boolean res = false;
        for(Integer i : list)
        {
            res = calculate(first, noOfDigits, multiplier, i);
            if(res)
                break;
        }
        if(!res)
        {
            return false;
        }
        return true;


    }

    public boolean calculate(int first, int noOfDigits, int multiplier, int last)
    {
        int numberArray[] = new int[noOfDigits];
        int []finalNumArray = new int[noOfDigits];
        numberArray[0] = first;
        numberArray[noOfDigits-1] = last;

        int carry = 0;
        for(int i = noOfDigits-1; i > 0; --i )
        {
            int temp = numberArray[i] * multiplier + carry;
            int res = temp % 10;
            numberArray[i-1] = res;
            carry = temp / 10;
        }

        if( numberArray[0] == first && numberArray[0] * multiplier + carry < 10 )
        {
//            print the number and return true
            for(int i = 0; i < noOfDigits; ++i)
//                System.out.print(numberArray[i]);
                printWriter.print(numberArray[i]);
            printWriter.println();

            return true;
        }

        return false;

    }

    Main()
    {
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



