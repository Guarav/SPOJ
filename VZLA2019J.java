import java.util.Scanner;

/**
 * Created by poplig on 10/29/19.
 */
public class Main {

    public static void main(String [] args) {

        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();
        int caseNumb = 1;

        while(t-->0) {
            int k = scanner.nextInt();
            boolean survival = true;

            int prev = -1;
            while (k --> 0) {
                int next = scanner.nextInt();

                if(prev != -1 && next - prev <=1 ) {
                    survival = false;
                }
                prev = next;
            }

            if(survival) {
                System.out.println("Case #" + caseNumb++ +  ": Survival!");
            } else {
                System.out.println("Case #" + caseNumb++ +  ": Oh no!");
            }

        }

    }

}
