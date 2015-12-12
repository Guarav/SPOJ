import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by poplig on 12/12/15.
 */
public class Main {

    public static void main(String [] args) {

        Scanner scanner  = new Scanner(System.in);

        int l = scanner.nextInt();
        int r = scanner.nextInt();

        // find the list of binary digints for both numbers.
        List<Integer> lList = getBinaryListRepresentaion(l);
        List<Integer> rList = getBinaryListRepresentaion(r);


        // find n.
        int n = rList.size();

        // find prefix which have equal values.
        int p = 0;
        for(int i = 0; i < lList.size(); ++i) {

            if(! lList.get(i).equals(rList.get(i))) {
                break;
            }
            p++;

        }

        // ans is n-p times "1".
        int times = n - p;

        long  ans = (long) Math.pow(2, times) - 1;

        System.out.println(ans);



    }

    public static List<Integer> getBinaryListRepresentaion(int num) {

        List<Integer> list = new ArrayList<>();
        while(num > 0) {
            list.add(num % 2);
            num = num / 2;
        }


        int sizeLeft = 40 - list.size();

        // add 0 paddings to make the size 40;
        for(int i = 0; i < sizeLeft; ++i) {
            list.add(0);
        }



        // reverse the list.
        Collections.reverse(list);



        return list;

    }

}
