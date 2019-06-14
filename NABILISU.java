import java.util.Scanner;

/**
 * Created by poplig on 6/13/19.
 */
public class NABILISU {

    public static void main(String [] args) {

        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        for(int i = 0; i < t; ++i) {

            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();

            c = (c == 0) ? 1 : c;


            if( b + c == a) {
                System.out.println(String.format( "Case %s: YES", i+1));
            } else {
                System.out.println(String.format( "Case %s: NO", i+1));
            }


        }

    }

}
