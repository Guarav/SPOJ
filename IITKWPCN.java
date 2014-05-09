import java.util.Scanner;

/**
 * Created by gaurav on 5/9/14.
 */
public class Main {

    public static void main(String [] args)
    {
        Scanner scanner  = new Scanner(System.in);
        int t = scanner.nextInt();
        while(t-->0)
        {
            int w = scanner.nextInt();
            int b = scanner.nextInt();
            if( b % 2 == 0 )
            {
                System.out.println("0.000000");
            }
            else
            {
                System.out.println("1.000000");
            }
        }
    }

    Main()
    {

    }

}



