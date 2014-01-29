#include<iostream>
#include<stdio.h>
#include<algorithm>
#define max 1001
using namespace std;
int isSumPossible(long long int input[max], int start, int end, long long int sum)
{
    while(start < end)
    {
        if( input[start] + input[end] > sum )
            end --;
        else if( input[start] + input[end] < sum )
            start++;
        else if( input[start ] + input[end] == sum )
            return 1;
    }
    return 0;
}
int main()
{
    int t, n;
    long long input[max], k;
    scanf("%d", &t);
    while(t-->0)
    {
        scanf("%d", &n);
        for(int i=0;i < n; ++i)
        {
            scanf("%lld", &input[i]);
        }
        scanf("%lld", &k);

        // sort the array
        sort( input, &input[n] );

        int start = 0, end = n - 1;
        int valueFound = 0;
        for(int i = 0;i < n; ++i)
        {
            long long int currentValue = input[i];
            long long int valueRequired = k - currentValue;
            if( isSumPossible(input, i + 1, n-1, valueRequired  ) )
            {
                valueFound = 1;
                break;
            }
        }
        if( valueFound )
            printf("YES\n");
        else
            printf("NO\n");

    }
    return 0;

}

