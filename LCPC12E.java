
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Created by poplig on 8/18/14.
 */
public class Main {

    private double a, b, c, d, e, f;

    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int testcase = 1;
        while(t-->0)
        {
            double a, b, c, d, e, f;
            a = scanner.nextDouble();
            b = scanner.nextDouble();
            c = scanner.nextDouble();
            d = scanner.nextDouble();
            e = scanner.nextDouble();
            f = scanner.nextDouble();

            new Main(a, b, c, d, e, f).printAns(testcase);
            testcase++;
        }
    }

    Main(double a, double b, double c, double d, double e, double f) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;

    }

    public void printAns(int num) {
        // distance between two centers
        double dist = Math.sqrt( Math.pow( a - c, 2) + Math.pow(b - d, 2) );

        // updating the radius of second circle
        f = f / Math.sqrt(2);

        double firstTerm = 4*dist*dist*e*e;

        double secondTerm = Math.pow( dist*dist - f*f + e*e, 2);



        double ans = firstTerm - secondTerm;
        if(dist == 0)
            ans = 0;
        else
            ans = Math.sqrt(ans) / dist;
        if(dist <= e + f)
            System.out.println(num + ". " + String.format("%.3f", ans));
        else
            System.out.println(num + ". " + "No problem");

    }
}
