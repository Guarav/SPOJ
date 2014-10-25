import java.util.Scanner;

/**
 * Created by poplig on 10/25/14.
 */
public class Main {

    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int testCase = 1;
        while(t-->0) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();

            // Check if GCD(a,b)
            int gcd = gcd(a, b);

            // Check if c is a multiple of gcd
            if(c % gcd == 0) {
                System.out.println("Case " + testCase + ": Yes");
            } else {
                System.out.println("Case " + testCase + ": No");
            }

            testCase++;
        }
    }

    public static int gcd(int n, int m) {
        if(m<=n && n%m == 0)
            return m;
        if(n < m)
            return gcd(m,n);
        else
            return gcd(m,n%m);
    }

    Main() {

    }

}

