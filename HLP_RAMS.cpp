#include<iostream>
#include<stdio.h>
using namespace std;

long long int calculateOddTerms(long long int n)
{
        if( n == 0 )
            return 1;
        else if( n == 1 )
            return 2;
        else if( !( n & (n-1) ) ) // power of 2
        {
            return 2;
        }
        else // of the form 2^n + r
        {
            long long int temp = 1;
            for(int i = 2; i < 64 && temp < n; ++i  )
            {
                temp = temp * 2;
            }

            temp = temp / 2;
            long long int r = n - temp;
            return 2*calculateOddTerms(r);
        }
}

int main()
{
    int t;
    long long int n;
    scanf("%d", &t);
    while(t-->0)
    {
        scanf("%lld", &n);
        long long int odd = calculateOddTerms(n);
        long long int even = n + 1 - odd;
        printf("%lld %lld\n", even, odd);



    }
    return 0;
}

