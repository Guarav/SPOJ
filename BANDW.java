import java.util.Scanner;

/**
 * Created by poplig on 8/19/14.
 */
public class Main {

    private String a, b;

    public static void main(String []args) {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            String input = scanner.nextLine();
            String [] inputArray = input.split("\\s+");
            if( inputArray[0].equalsIgnoreCase("*") )
                break;
            String a = inputArray[0];
            String b = inputArray[1];

            int ans = new Main(a, b).getMinimumSteps();
            System.out.println(ans);
        }
    }

    Main(String a, String b) {
        this.a = a;
        this.b = b;
    }

    public int getMinimumSteps() {

        int count = 0;
        boolean temp = false;

        for(int i = 0; i < a.length(); ++i) {

            if( a.charAt(i) != b.charAt(i) ) {
                if( !temp ) {
                    count++;
                }
                temp = true;

            } else {
              temp = false;
            }
        }

        return count;
    }




}

