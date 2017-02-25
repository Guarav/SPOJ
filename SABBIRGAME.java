import java.util.Scanner;

/**
 * Created by poplig on 2/26/17.
 */
public class Main {

    public static void main(String [] args) {

        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while(t-->0) {
            int n = scanner.nextInt();

            long totalSum = 0;
            long minRequired = 0;
            for(int i = 0; i < n; ++i) {
                long num = scanner.nextLong();

                totalSum += num;

                if(totalSum <= 0) {
                    minRequired += 1 - totalSum;
                    totalSum = 1;
                }

            }

            System.out.println(minRequired);
         }

    }

}
