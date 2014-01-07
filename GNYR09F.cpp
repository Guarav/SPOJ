#include<iostream>
#include<stdio.h>
#include<string.h>
using namespace std;
int memoiz[99][100][2];
int solve(int n, int k, int last)
{
    if(k < 0) return 0;
    if( n < 0 )return (k == 0);

    int &temp = memoiz[n][k][last];
    if( temp == -1 )
        temp = solve(n-1, k, 0) + solve(n-1, (last == 1 ) ? k - 1 : k, 1);
    return temp;

}
int main()
{
    int t;
    scanf("%d", &t);
    memset(memoiz, -1, sizeof(memoiz));
    while(t-->0)
    {
        int numb, n, k;
        scanf("%d%d%d", &numb, &n, &k);
        // cases for first bit 1 or 0
        int result = solve(n-2, k, 0) + solve(n-2, k, 1);
        printf("%d %d\n", numb, result);
    }
    return 0;
}
