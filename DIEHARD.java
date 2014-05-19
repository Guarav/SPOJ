package OC;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by gaurav on 5/19/14.
 */
public class Main {

    private int memoized[][][] = new int[2001][2001][2];

    public static void main(String [] args)
    {
        Scanner scanner  = new Scanner(System.in);
        int t = scanner.nextInt();
        Main diehard = new Main();
        while(t-->0)
        {
            int a = scanner.nextInt();
            int h = scanner.nextInt();
            int ans = diehard.getMaximumTime(a, h);
            System.out.println( ans );
        }

    }


    public int getMaximumTime(int a, int h)
    {
        // starting point is by adding 3 to a and 2 to h
        int startA = a + 3;
        int startH = h + 2;

        return getMaximumTime(startA, startH, 1) + 1;
    }

    private int getMaximumTime(int a, int h, int level)
    {

        if( a <= 0 || h <= 0 )
            return -1;


        if( memoized[a][h][level] != 0 )
            return memoized[a][h][level];

        if( level % 2 == 0 )
        {
            // add to air
            return  ( memoized[a][h][level] = 1 + getMaximumTime(a + 3, h + 2, (level + 1)%2) );
        }
        else
        {
            return ( memoized[a][h][level] = 1 + Math.max(getMaximumTime(a - 5, h - 10, (level + 1)%2), getMaximumTime(a - 20, h + 5, (level + 1)%2)) );
        }

    }

    Main()
    {

    }

}

