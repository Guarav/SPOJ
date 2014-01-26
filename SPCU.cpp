#include<iostream>
#include<stdio.h>
#define max 100001
using namespace std;
int main()
{
    int t, n;
    scanf("%d", &t);
    while(t-->0)
    {
        int a;
        int hash[max] = {0};
        scanf("%d", &n);
        int errorFound = 0;
        for(int i = 1 ; i <= n; ++i)
        {
            scanf("%d", &a);
            if( a > i - 1 )
                errorFound = 1;
        }


        if(errorFound)
            printf("NO\n");
        else
            printf("YES\n");


    }
    return 0;
}


