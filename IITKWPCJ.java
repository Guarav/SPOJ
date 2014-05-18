import java.util.Scanner;

/**
 * Created by gaurav on 5/14/14.
 */
public class Main {

    private String a;

    private String b;

    public static void main(String [] args)
    {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());
        while(t-->0)
        {
            String input = scanner.nextLine();
            String []temp = input.split("\\s+");
            String a = temp[0];
            String b = temp[1];

            boolean ans = new Main(a, b).isStringPower();
            if(ans)
                System.out.println("YES");
            else
                System.out.println("NO");
        }

    }

    Main(String a, String b)
    {
        this.a = a;
        this.b = b;
    }

    public boolean isStringPower()
    {
        if( a.length() > b.length() )
            return isStringPower(a, b);
        else
            return isStringPower(b, a);
    }

    private boolean isStringPower(String a, String b)
    {
        if(a.length() == b.length())
        {
            return a.equals(b);
        }
        if( a.length() == 0 || b.length() == 0 )
            return true;

        int firstIndex = a.indexOf(b);
        if(firstIndex != 0)
            return false;

        String newA = new StringBuffer(a).substring(firstIndex + b.length(), a.length());
        String newB = b;

        if(newA.length() > newB.length() )
            return isStringPower( newA, newB );
//            return false;
        return isStringPower(newB, newA);

    }



}


