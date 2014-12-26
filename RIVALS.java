import java.util.Scanner;

/**
 * Created by poplig on 12/26/14.
 * @link : http://www.spoj.com/problems/RIVALS/
 */
public class Main {

    private static final int max = 2000001;

    private static final int mod = 1000000007;

    private static long inv[] = new long[max];

    private static long invf[] = new long[max];

    private static long f[] = new long[max];

    private static long ar[] = new long[max];

    public static void main(String [] args) {

        preCompute();

        // Take the input.
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while(t-->0) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            long ncr = ( ( ( f[x+y] * invf[x] ) % mod ) * (invf[y]) ) % mod;
            System.out.println(ncr % mod);
        }

    }

    public static void preCompute() {

        f[0] = 1;
        for(int i=1;i<max;++i)
        {
            f[i] = (f[i-1]*i) % mod;
        }
        inv[1] = 1;
        for(int i=2;i<max;++i)
        {
            inv[i] = ((mod - mod/i)*inv[mod % i]) % mod;
        }
        invf[0] = invf[1] = 1;
        for(int i=2;i<max;++i)
        {
            invf[i] = (invf[i-1]*inv[i]) % mod;
        }
    }

    Main() {

    }

}


