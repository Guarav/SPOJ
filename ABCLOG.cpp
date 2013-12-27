#include<iostream>
#include<stdio.h>
#include<math.h>
#define max 64
using namespace std;
int getBinaryForm(long long  n, int bits[max])
{
    int index = 0;
    while(n)
    {
        bits[index++] = n % 2;
        n = n / 2;
    }
    return index;

}
int main()
{
    long long int n;
    while(1)
    {
        scanf("%lld", &n);
        if( n == -1)
            break;
        int inputBits[max];
        // get all the bits in input
        int count = getBinaryForm(n, inputBits);


        long long  total = 0;
        // now calculate the decimal with this binary
        for(int i = count-1;i >= 0;--i)
        {
            total += pow(2, (count-1)-i)* inputBits[i];
        }
        printf("%lld\n", total);
    }
    return 0;
}

