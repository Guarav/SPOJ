
import java.util.Scanner;

/**
 * Created by poplig on 9/7/14.
 */
public class Main {

    public static void main(String [] args) {

        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());
        while(t-->0) {
            String a = scanner.nextLine();
            String b = scanner.nextLine();

            if(a.length() == b.length() && ( new StringBuilder(b).append(b).toString()).contains(a)) {
                System.out.println("Si");
            } else {
                System.out.println("No");
            }
        }

    }

    Main() {
        // no op
    }

}

