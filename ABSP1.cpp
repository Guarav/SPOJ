#include<iostream>
#include<stdio.h>
#define max 10001
using namespace std;
int main()
{
    int t, n;
    scanf("%d", &t);
    while(t-->0)
    {
        long long int sumArray[max];
        long long int totalSum = 0;
        long long int previousSum = 0;
        scanf("%d", &n);
        long long int ar[max];
        // taking the first elemnt of the array
        scanf("%lld", &ar[0]);

        sumArray[0] = 0;
        for(int i = 1;i < n; ++i)
        {
            scanf("%lld", &ar[i]);
            long long int temp = previousSum + (i-1)*(ar[i] - ar[i-1]) + ar[i] - ar[i-1];
            sumArray[i] = temp;
            previousSum = temp;
            totalSum += temp;
        }

        // just find the sum of the sumArray and it is the answer
        /*
        for(int i = 0;i < n; ++i)
            totalSum += sumArray[i];
        */

        printf("%lld\n", totalSum);

    }
    return 0;
}

