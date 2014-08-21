
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by poplig on 8/22/14.
 */
public class Main {

    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int testcase = 1;
        while(t-->0) {
            int n = scanner.nextInt();
            int p = scanner.nextInt();
            boolean firstCond = true;
            boolean secondCond = true;
            boolean thirdCond = true;

            int maxPerTeam = 0;

            boolean arr[] = new boolean[p];

            for(int i = 0; i < n; ++i) {
                int localCount = 0;
                for(int j = 0; j < p; ++j) {
                    int input = scanner.nextInt();
                    if( input == 1  ) {
                        localCount++;
                        arr[j] = true;
                    }

                }

                if(localCount == 0)
                    secondCond = false;

                if(localCount > maxPerTeam)
                    maxPerTeam = localCount;

            }

            // check third condition
            if(maxPerTeam >= p)
                thirdCond = false;

            // check for first condition
            for(int i = 0; i < p; ++i) {
                if(!arr[i]) {
                    firstCond = false;
                    break;
                }
            }

            // calculate the final value here
            int ans = ( firstCond ? 4 : 0 ) + ( secondCond ? 2 : 0 ) + ( thirdCond ? 1 : 0 ) ;
            System.out.println("Case " + testcase + ": " + ans);
            testcase++;


        }
    }

    Main() {

    }

}
