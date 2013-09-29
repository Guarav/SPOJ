#include<iostream>
#include<stdio.h>
#define Nmax 13
using namespace std;
int max(int a, int b)
{
    if(a > b)
        return a;
    return b;
}
int main()
{
    int t, n, k;
    int mem[Nmax][Nmax*(Nmax-1)/2] = {0};
    // precomputation of all the results
    for(int i = 0; i < Nmax;++i)
    {
        mem[i][0] = 1;
        mem[i][i*(i-1)/2] = 1;
    }
    mem[1][1] = 1;
    mem[2][1] = 1;
    for(int i = 2; i < Nmax; ++i)
    {

        for(int j = 1; j < i*(i-1)/2; ++j)
        {
            int result = 0 ;

            int temp = max(1, i-j);
            for(int l = temp; l <= i; ++l)
            {
                result += mem[i-1][j-i+l];
            }

            mem[i][j] = result;


        }
    }

    scanf("%d", &t);
    while(t-->0)
    {
        scanf("%d%d", &n, &k);
        // first case to eliminate results
        if( k > n*(n-1)/2 )
        {
            printf("0\n");
            continue;
        }
        printf("%d\n", mem[n][k]);

    }
    return 0;
}
