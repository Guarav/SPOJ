#include<iostream>
#include<stdio.h>
#define max 100001
using namespace std;
int main()
{
    int t, n;
    int inputArray[max];
    scanf("%d", &t);
    while(t-->0)
    {
        scanf("%d", &n);
        for(int i = 0;i < n; ++i)
            scanf("%d", &inputArray[i]);

        int count = 0, prev = inputArray[0];
        for(int i = 1; i < n; ++i)
        {
            prev = inputArray[i] - prev;
        }
        if(prev == 0)
            printf("YES\n");
        else
            printf("NO\n");
    }
    return 0;
}
