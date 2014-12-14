import java.util.Scanner;

/**
 * Created by poplig on 12/14/14.
 */
public class Main {

    public static void main(String [] args) {

        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        int testCase = 1;

        while(t-->0) {

            long x1 = scanner.nextLong();
            long y1 = scanner.nextLong();
            long x2 = scanner.nextLong();
            long y2 = scanner.nextLong();

            long denominator = (x1+y1) * (x2+y2+1);

            // Calculate the numerator.
            long numerator = x1*(x2+1) + y1*(y2+1);


            if(numerator == 0) {
                System.out.println("Case " + testCase + ": 0");
                testCase++;
                continue;
            }

            // Find the gcd of numerator and denominator.
            long gcd = gcd(numerator, denominator);

            numerator = numerator / gcd;

            denominator = denominator / gcd;

            System.out.println("Case " + testCase + ": " + numerator + "/" + denominator);

            testCase++;
        }

    }

    public static long gcd(long n, long m) {
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

