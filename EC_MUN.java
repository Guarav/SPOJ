

import java.util.*;

/**
 * Created by poplig on 9/13/14.
 */
public class Main {



    public static void main(String [] args) {

        int n, m;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        Map<Integer, List<Integer>> input = new HashMap<Integer, List<Integer>>();

        for(int i = 0; i < m; ++i) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            // Now there is entry from a -> b and b -> a
            // enter b in a's entry.
            List<Integer> list = input.get(a);
            if(list == null) {
                list = new ArrayList<Integer>();
                list.add(b);
                input.put(a, list);
            } else {
                list.add(b);
                input.put(a, list);
            }

            // enter a in b's entry.
            list = input.get(b);
            if(list == null) {
                list = new ArrayList<Integer>();
                list.add(a);
                input.put(b, list);
            } else {
                list.add(a);
                input.put(b, list);
            }
        }

        int count = 0;
        // Prepare a hash data structure to store the occurrence of that integer.
        boolean numberVisit[] = new boolean[n+1];
        // Now iterate through all the integers.

        for(int i = 1; i <= n;++i ) {
            if(!numberVisit[i]) {
                numberVisit[i] = true;
                // Use that and apply DFS to it.
                applyDFS(input, i, numberVisit);
                count++;
            }

        }

        // Output the ans.
        System.out.println(count - 1);

    }

    public static void applyDFS(Map<Integer, List<Integer>> input, int number, boolean isVisit[]) {
        List<Integer> list =  input.get(number);
        if(list == null) {
            return;
        } else {
            // Iterate through all the numbers.
            for(Integer num : list) {
                if(!isVisit[num]) {
                    isVisit[num] = true;
                    applyDFS(input, num, isVisit);
                }
            }
        }
    }

    Main() {
        // no op.
    }

}
