
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Created by gaurav on 5/28/14.
 */
public class Main {

    public static void main(String [] args)
    {


        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while(t-->0)
        {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();


            double ans = getRadius(a, b, c);
            DecimalFormat format = new DecimalFormat("0.000000");
            ans = Double.parseDouble(format.format(ans));
            System.out.println(String.format("%.6f", ans));
        }
    }

    Main()
    {

    }

    public static double getRadius(int a, int b, int c)
    {
        double r1 = (double)1/a;
        double r2 = (double)1/b;
        double r3 = (double)1/c;
        double ans = r1 + r2 + r3 + 2*Math.sqrt(r1*r2 + r2*r3 + r3*r1);
        return 1/ans;

    }



}

