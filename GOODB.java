import java.math.BigInteger;
import java.util.Scanner;

class Main
{
    public static BigInteger  mod = BigInteger.valueOf(1000000007);
    static public void main(String [] args)
    {
        int n, w, r, t;

        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        w = input.nextInt();
        r = input.nextInt();
        t = input.nextInt();
        BigInteger n1 = BigInteger.valueOf(n);
        BigInteger w1 = BigInteger.valueOf(w);
        BigInteger r1 = BigInteger.valueOf(r);
        BigInteger t1 = BigInteger.valueOf(t);
        BigInteger num = fact(n1);
        BigInteger den = fact(w1).multiply(fact(r1));
        den = den.multiply(fact(t1));
        BigInteger ans = num.divide(den);
        ans = ans.mod(mod);
        System.out.println(ans);


    }
    public static BigInteger fact(BigInteger n)
    {
        int num = n.intValue();
        int i = 1;
        BigInteger sum = BigInteger.valueOf(1);
        for(i = 1;i<=num;++i)
        {
            sum = sum.multiply(BigInteger.valueOf(i));

        }
        return sum;
    }
}

