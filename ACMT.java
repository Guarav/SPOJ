package OC;

import java.util.Scanner;

/**
 * Created by poplig on 7/4/15.
 */
public class ACMT {

    public static void main(String  []args) {

        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while(t-->0) {

            int e, n;
            e = scanner.nextInt();
            n = scanner.nextInt();

            if(e == 0 || n == 0) {
                System.out.println(0);
                continue;
            }
            
            int max, min;
            max = Math.max(e, n);
            min = e + n - max;
            
            int totalCount = 0;
            

            if( min > max/2 ) {
                
                totalCount += (min + max)/3;
                
            } else {
                
                totalCount += min;
            }
            
            System.out.println(totalCount);

        }

    }

}
