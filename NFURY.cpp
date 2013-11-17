#include<iostream>
#include<stdio.h>
using namespace std;
int main()
{
    int dp[1001];
    // initialising the dp array with -1  whcih signiifies values needs to be find
    for(int i = 1; i < 1001;++i)
        dp[i] = -1;
    // some initial values
    dp[1] = 1;
    dp[2] = 2;
    dp[3] = 3;
    dp[4] = 1;
    // first set for all perfect squares
    for(int i = 3; i <= 31;++i)
        dp[i*i] = 1;

    // lets iterate through them
    for(int i = 5; i <= 1000;++i )
    {
        int val = i;
        int minFound = 1000;
        if( dp[i] != -1 )   // already minimum value is given
            continue;

        for(int j = 1; j*j <= val; ++j)
        {
            int diff = val - j*j;
            if( dp[diff] + 1  < minFound)
                minFound = dp[diff] + 1;
        }

        // set the min value
        dp[i] = minFound;
    }
    int t, n;
    scanf("%d", &t);
    while(t-->0)
    {
        scanf("%d", &n);
        printf("%d\n", dp[n]);
    }
    return 0;
}
