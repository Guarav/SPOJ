#include<iostream>
#include<stdio.h>
#define max 1000000000000000001
int isHarshadNumber(long long int n )
{
    long long int sum = 0, temp = n;
    while(n > 0)
    {
        sum += n%10;
        n = n / 10;
    }
    if(temp % sum == 0)
    {
        return 1;

    }

    return false;
}
using namespace std;
int main()
{
    int t;
    long long int n;
    scanf("%d", &t);
    while(t-->0)
    {
        scanf("%lld", &n);
        for(long long int i = n ; ;++i)
        {
            if( isHarshadNumber(i) )
            {
                printf("%lld\n", i);
                break;
            }
        }
    }

}
