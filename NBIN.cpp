import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by gaurav on 4/18/14.
 */
public class Main {

    private static List<Long> preComputedNumbersList = new ArrayList<Long>();

    private static final int maxBits = 75;

    public static void main(String [] args)
    {
        preComputeValues();

        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        Main Main = new Main();
        while(t-->0)
        {
            long input = scanner.nextLong();
            Main.printNthNumberBinaryForm(input);
        }


    }

    public void printNthNumberBinaryForm(long n)
    {
        // get ith bit number representation for which this n coming
        List<Integer> oneBitPosn = new ArrayList<Integer>();
        int ibit = getIthBit(n);
        long left = n - preComputedNumbersList.get(ibit-1) - 1;
//        System.out.println(left + " with bit " + ibit);
        oneBitPosn.add(ibit);
        while(left > 0)
        {
            int tempIbit = getIthBit(left);
            oneBitPosn.add(tempIbit);
            if(tempIbit == 1)
                break;
            left = left - preComputedNumbersList.get(tempIbit-1) - 1;
        }

        for(int i = ibit ; i >= 1 ;--i)
        {
            if( oneBitPosn.contains(i) )
                System.out.print(1);
            else
                System.out.print(0);
        }
        System.out.println();
    }

    public int getIthBit(long n)
    {
        for(int i = 1; i <= maxBits; ++i)
        {
            if( preComputedNumbersList.get(i) >= n )
                return i;
        }

        return maxBits;
    }

    public static void preComputeValues()
    {
        preComputedNumbersList.add(0L);
        preComputedNumbersList.add(1L);
        preComputedNumbersList.add(2L);
        preComputedNumbersList.add(4L);
        long prevVal = 4;

        for(int i = 4; i <= maxBits; ++i)
        {
            long temp = prevVal + preComputedNumbersList.get(i-2) + 1;
            preComputedNumbersList.add(temp);
//            System.out.println(i + "   " + temp);
            prevVal = temp;
        }
    }

    Main()
    {

    }

}




