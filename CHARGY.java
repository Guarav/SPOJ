import java.util.Scanner;
import java.util.Stack;

/**
 * Created by poplig on 6/6/19.
 */
public class CHARGY {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int prev = scanner.nextInt();

        Stack<Integer> stack = new Stack<>();

        stack.add(prev);

        int totalVanishes = 0;
        boolean lastVanish = false;

        for (int i = 1; i < n; ++i) {

            int current = scanner.nextInt();
            if (canVanish(stack, current)) {
                stack.pop();
            } else {
                stack.add(current);
            }

        }

        System.out.println(stack.size());

    }

    private static boolean canVanish(Stack<Integer> stack, int current) {

        if (stack.size() == 0) {
            return false;
        }
        int prev = stack.peek();

        if ((prev == -1 && current == 1) || (prev == 1 && current == -1)) {
            return true;
        }

        return false;
    }
}
