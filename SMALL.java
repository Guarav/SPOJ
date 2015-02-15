import java.util.Scanner;

/**
 * Created by poplig on 1/26/15.
 */
public class Main {

    private static int max = 10001;

    private static long smallest[] = new long[max];

    private static boolean[] primeSieve = new boolean[max];

    private static int[] primeNumbers = new int[max];

    private static int maxCount = 0;

    private static long mod = 1000000007L;

    private static long[] finalAns = new long[max];

    private static int[] hashedPrimes = new int[max];

    public static void main(String[] args) {

        preCompute();


        // Get the input, and process.
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-->0) {
            int n = scanner.nextInt();

            // Print the answer.
            System.out.println(finalAns[n] % mod);

        }
    }

    public static void preCompute() {
        // prepare the prime numbers to be used later.
        preparePrimes();

        // calculate the required ans for every integer 1 to max.
        hashedPrimes[1] = 1;
        hashedPrimes[2] = 1;

        finalAns[1] = 1;
        finalAns[2] = 2;

        for(int i = 3; i < max; ++i) {

            int temp = i;
            for(int j = 0; j < maxCount; ++j) {


                if(i > primeNumbers[j]) {
                    if(i % primeNumbers[j] == 0) {
                        // reduce to lowest form anf get the count.
                        int count = 0;
                        while (temp % primeNumbers[j] == 0) {
                            temp = temp / primeNumbers[j];
                            count++;
                        }

                        // now we have the prime number and its count.
                        hashedPrimes[primeNumbers[j]] = Math.max(count, hashedPrimes[primeNumbers[j]]);
                    }
                } else {
                    break;
                }
            }

            if(temp != 1) {
                hashedPrimes[temp] = Math.max(1, hashedPrimes[temp]);
            }

            // Get the ans for i by iterating it.
            long ans = 1;
            for(int k = 1;k < max; ++k) {

                if(hashedPrimes[k] > 0) {

                    int temp1 = hashedPrimes[k];
                    while (temp1-- > 0) {
                        ans = (ans*k) % mod;
                    }

                }
            }

            // Store the answer.
            finalAns[i] = ans;

        }
    }

    public static void preparePrimes() {
        for (int i = 2; i < max; ++i) {
            primeSieve[i] = true;
        }

        for (int i = 2; i < 101; ++i) {
            if (primeSieve[i]) {
                for (int j = 2; i * j < max; ++j) {
                    primeSieve[i * j] = false;
                }
            }
        }

        // Collect all the prime numbers.
        for (int i = 0; i < max; ++i) {
            if (primeSieve[i]) {
                primeNumbers[maxCount++] = i;
            }
        }
    }

    Main() {

    }

}


