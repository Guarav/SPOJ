#include<iostream>
#include<stdio.h>
#include<string.h>
#define max 50
#define maxMarks 20
using namespace std;
int main()
{
    char inputString[max];
    scanf("%s", inputString);
    int dp[max]={0};
    for(int i=0;i<max;++i)
        dp[i]=0;
    int size=strlen(inputString);

    dp[size-1] = 1;
    for( int j=size-2;j>=0;--j)
    {
        int a=inputString[j]-'0',b=inputString[j+1]-'0';
        if( j == size-2 && 10*a + b <= maxMarks && a != 0 )
            dp[j] = dp[j+1] + 1;
        else if(j == size-2)
            dp[j] = dp[j+1];
        else if( 10*a+b <= maxMarks && a != 0 )
            dp[j] = dp[j+1] + dp[j+2];
        else
            dp[j] = dp[j+1];
    }
    

        printf("%d\n",dp[0]);
        return 0;
}
