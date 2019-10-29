import java.util.Scanner;

/**
 * Created by poplig on 10/29/19.
 */
public class VZLA2019I {

    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);

        long result = 1;

        for(int i = 0;i < 6; ++i) {

            long a = scanner.nextLong();
            result = result*a;
        }

        System.out.println(result);
    }

}
