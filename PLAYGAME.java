import java.util.Scanner;

/**
 * Created by poplig on 3/12/17.
 */
public class PLAYGAME {

    public static void main(String [] args) {

        Scanner scanner  = new Scanner(System.in);
        int t = scanner.nextInt();


        while(t-->0 ){
            long n = scanner.nextLong();

            if(n%3 == 0) {
                System.out.println("Ragini");
            } else {
                System.out.println("Hemlata");
            }
        }
    }

}
