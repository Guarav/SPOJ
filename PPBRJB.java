import java.util.Scanner;

/**
 * Created by poplig on 11/22/14.
 */
public class Main {

    private static int maxN = 41;

    private static int maxPrime = 217287;

    private static int [] waysArray = new int[maxN];

    private static int []primeSieve = new int[maxPrime];

    public static void main(String [] args) {
        // Do precomputations before.

        preCompute();

        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while(t-->0) {
            int n = scanner.nextInt();
            int ways = waysArray[n];
            System.out.println(primeSieve[ways]);
        }

    }

    public static void preCompute() {
        // Pre compute the number of ways.
        computeNumberOfWays();

        // Compute the prime numbers values using sieve.
        computePrimeSieve();
    }

    public static void computePrimeSieve() {

        for(int i = 2; i < maxPrime; ++i) {
            primeSieve[i] = 1;
        }

        for(int i = 2; i < 500; ++i) {
            if(primeSieve[i] == 1) {
                for(int j = 2; i*j < maxPrime; ++j) {
                    primeSieve[i*j] = 0;
                }
            }
        }


        // All the numbers which have value true will be prime.
        int prevValue = 0;
        for(int i = 1; i < maxPrime; ++i) {
            primeSieve[i] = primeSieve[i] + prevValue;
            prevValue = primeSieve[i];
        }
    }

    public static void computeNumberOfWays() {
        // Fill the initial values.
        waysArray[1] = 1;
        waysArray[2] = 1;
        waysArray[3] = 1;
        waysArray[4] = 2;

        for(int i = 5; i < maxN; ++i) {
            waysArray[i] = waysArray[i-1] + waysArray[i-4];
        }
    }

    Main () {

    }

}

