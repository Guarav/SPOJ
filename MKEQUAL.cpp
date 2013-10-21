#include<iostream>
#include<stdio.h>
#define max 100001
using namespace std;
int main()
{
    int t, n, ar[max];
    scanf("%d", &t);
    while(t-->0)
    {
        scanf("%d", &n);
        int sum = 0;
        for(int i = 0 ;i < n; ++i)
        {
            int a;
            scanf("%d", &a);
            sum += a;
        }
        if( sum % n == 0 )
            printf("%d\n", n);
        else
            printf("%d\n", n-1);


    }
    return 0;
}
