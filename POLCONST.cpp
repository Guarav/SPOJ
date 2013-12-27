#include<iostream>
#include<stdio.h>
#define max 1000001
using namespace std;
int primeNumbers[max];int primeCount = 0;int primeSieve[max];int fermats[max];
int getPrimeFactorsAndCheckFermat(int n)
{
    int temp = n, count = 0, erFound = false;
    for(int i = 0; i < primeCount;++i)
    {
        if(primeNumbers[i] > n)
            break;
        if(n % primeNumbers[i] == 0)
        {
            int count = 0;
            while(n % primeNumbers[i] == 0)
            {
                count++;
                n = n / primeNumbers[i];
            }
            if( primeNumbers[i] % 2 != 0  )
            {
                if(fermats[ primeNumbers[i] ] != 1 || count != 1)
                    erFound = true;
            }
        }
    }
    if(primeSieve[temp])
    {
        if( temp % 2 != 0)
        {
            if( fermats[temp] != 1)
                erFound = true;
        }
    }
    return !erFound;
}
int main()
{
    fermats[3] = 1;fermats[5] = 1;fermats[9] = 1;fermats[17] = 1;fermats[257] = 1;fermats[65537] = 1;
    for(int i = 0;i < max;++i)
        primeSieve[i] = 1;
    for(int i = 2;i < 1001;++i)
    {
        if(primeSieve[i] == 1)
        {
            for(int j = 2;j*i < max;++j)
                primeSieve[i*j] = 0;
        }
    }
    for(int i = 2;i < max;++i)
    {
        if(primeSieve[i] == 1)
            primeNumbers[primeCount++] = i;
    }
    int n, t;
    scanf("%d", &t);
    while(t-->0)
    {
        scanf("%d", &n);
        int erFound = getPrimeFactorsAndCheckFermat(n);
        if(erFound)
            printf("Yes\n");
        else
            printf("No\n");
    }
    return 0;
}
