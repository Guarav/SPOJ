
import java.util.*;

/**
 * Created by gaurav on 5/14/14.
 */
public class Main {

    private int a;

    private int b;

    private int n;

    private int maxVal ;

    private Map<Integer, Integer> memoizedVals = new HashMap<Integer, Integer>();

    public static void main(String [] args)
    {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int testCase = 1;
        while(t-->0)
        {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int n = scanner.nextInt();

//            int ans = new Main(a, b, n).getMinimumDays();
            long ans = new Main(a, b, n).getMinimumDays1();
            if(ans > n)
                System.out.println("Case " + testCase + ": Not Possible");
            else
                System.out.println("Case " + testCase + ": " + ans);

            testCase++;
        }
    }

    Main(int a, int b, int n)
    {
        this.a = a;
        this.b = b;
        this.n = n;
        this.maxVal = n / Math.min(a, b);
    }

    public int getMinimumDays()
    {
        int dp[] = new int[this.n + 1];

        // initialise all with -1
        for(int i = 0;i <= this.n; ++i)
            dp[i] = -1;

        int min = Math.min(this.a, this.b);
        int max = a + b - min;

        if( this.n < min )
            return -1;

        dp[min] = 1;
        dp[max] = 1;

        for(int i = min + 1; i < max; ++i)
        {
            int m = dp[i-min];

            if(m != -1)
                dp[i] = m + 1;

        }

        

        for(int i = max + 1; i <= this.n; ++i)
        {
            int m = dp[i-min];
            int n = (i - max) >=0 ? dp[i-max] : -1;


            if(m != -1 && n != -1 )
            {
                dp[i] = Math.min(m, n) + 1;
            }
            else if(m != -1)
            {
                dp[i] = m + 1;
            }
            else if(n != -1)
                dp[i] = n + 1;


        }

        return dp[this.n];

    }

    public long getMinimumDays1()
    {
        long dp[] = new long[this.n + 1];

        for(int i = 0; i < this.n + 1; ++i)
            dp[i] = Integer.MAX_VALUE;

        dp[0] = 0;

        int s[] = {a, b};

        for(int i = 1; i <= this.n; ++i)
        {
            for(int j = 0; j < 2; ++j)
            {
                if( s[j] <= i )
                {
                    dp[i] = Math.min(dp[i], dp[i-s[j]] + 1);
                }
            }
        }

        return dp[this.n];
    }



}


