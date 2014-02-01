#include<iostream>
#include<stdio.h>
#define max 1001
using namespace std;
int main()
{
    int t, n, input[max];
    scanf("%d", &t);
    while(t-->0)
    {
        int hash[max] = {0};
        scanf("%d", &n);
        for(int i = 0; i < n ;++i)
        {
            scanf("%d", &input[i]);
            hash[ input[i] ]++;
        }
        int errorFound  = 0;

        for(int i = 1;i <= n;++i)
        {
            //check for every position now
            if( hash[n-i] != 0 )
                hash[n-i]--;
            else if( hash[i-1] != 0 )
                hash[i-1]--;
            else{
                errorFound = 1;
                break;
            }


        }

        if(errorFound)
            printf("NO\n");
        else
            printf("YES\n");
    }
    return 0;
}

