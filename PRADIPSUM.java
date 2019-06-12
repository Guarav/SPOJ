import java.util.Scanner;

/**
 * Created by poplig on 6/12/19.
 */
public class PRADIPSUM {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {

            long a = scanner.nextLong();
            long b = scanner.nextLong();

            long sum = 0;

            if (a > b) {
                sum = a * (a + 1) / 2 - b * (b - 1) / 2;
            } else {
                sum = b * (b + 1) / 2 - (a - 1) * a / 2;
            }

            System.out.println(sum);
        }

    }

}
