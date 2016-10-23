import java.util.Scanner;

/**
 * Created by poplig on 10/23/16.
 */
public class FRNDZND {

    public static void main(String [] args) {
        Scanner scanner  = new Scanner(System.in);
        int n = scanner.nextInt();
        int q = scanner.nextInt();

        int [] ar = new int[n];

        for(int i = 0;i < n; ++i) {
            ar[i] = scanner.nextInt();
        }

        while (q-->0) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();

            if(r - l + 1 == 1) {
                System.out.println(ar[l-1]);
            } else {
                System.out.println(0);
            }
        }
    }

}
