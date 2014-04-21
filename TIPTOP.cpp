#include<iostream>
#include<stdio.h>
#include<math.h>
using namespace std;
int main()
{
    int t ;
    scanf("%d", &t);
    int test = 1;
    while(t-->0)
    {
        long long int num;
        scanf("%lld", &num);
        long long int srt = sqrt(num) ;

        if( srt*srt == num )
            printf("Case %d: Yes\n", test);
        else
            printf("Case %d: No\n", test);

        test++;

    }
}

