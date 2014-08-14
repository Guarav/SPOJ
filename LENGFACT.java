

import java.util.Scanner;

/**
 * Created by poplig on 8/14/14.
 */
public class Main {

    private long n;

    private static final int maxSize = 1001;

    public static void main(String [] args)
    {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while(t-->0)
        {
            long n = scanner.nextLong();
            if(n < 2)
                System.out.println(1);
            else
            {
                long ans = new Main(n).getMain();
                System.out.println(ans);
            }

        }
    }

    

    Main(long n)
    {
        this.n = n;
    }

    public long getMain()
    {
        double ans = (Math.log10(2*Math.PI*n) / 2 + n*(Math.log10(n) - Math.log10(Math.E))) + 1;


        return (long)Math.floor(ans);
    }

}
