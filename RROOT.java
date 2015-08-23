import java.util.Scanner;

/**
 * Created by poplig on 8/23/15.
 */
public class Main {

    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while(t-->0) {
            int n = scanner.nextInt();

            if(n == 0) {
                System.out.println("0.000000");
                continue;
            }
            double sqrSide = (double)n / 2;


            double num = 1;
            double den = 3*Math.sqrt(sqrSide);
            
            if(den == 0.0) {
                System.out.println("0.000000");
                continue;
            }

            double ans = num / den;
            ans = 1 - ans;

            System.out.printf("%.6f\n", ans);
        }
    }

}
