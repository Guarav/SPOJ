import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by gaurav on 4/19/14.
 */
public class Main {

    private List<Integer> firstList = new ArrayList<Integer>();

    private List<Integer> secondList = new ArrayList<Integer>();

    public static void main(String [] args)
    {
//        while(true){
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            List<Integer> list1 = new ArrayList<Integer>(n);
            List<Integer> list2 = new ArrayList<Integer>(n);
            for(int i = 0;i < n; ++i)
                list1.add(scanner.nextInt());

            for(int i = 0;i < n; ++i)
                list2.add(scanner.nextInt());

            int ans = new Main(list1, list2).getMaxBattles();
            System.out.println(ans);
//        }


    }

    Main(List<Integer> list1, List<Integer> list2)
    {
        this.firstList = list1;
        this.secondList = list2;
    }

    public int getMaxBattles()
    {
        // sort both the lists
        Collections.sort(this.firstList);
        Collections.sort(this.secondList);

        int totalBattles = 0;
        int length = this.firstList.size();
        int firstListMinElement = this.firstList.get(0);

        // find the elements in second list which are greater than firstListMinElement

        for(int i = 0, j = 0; i < length && j < length;)
        {
            if( this.secondList.get(j) > this.firstList.get(i)   )
            {
                totalBattles++;
                ++i;
                ++j;
            }
            else
            {
                ++j;
            }
        }

        return totalBattles;



    }

}


