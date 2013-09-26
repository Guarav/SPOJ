#include<iostream>
#include<stdio.h>
#include<algorithm>
#define max 10001
using namespace std;
int main()
{
    int t, n, k;
    int arrayA[max], arrayB[max];
    scanf("%d", &t);
    while(t-->0)
    {
        scanf("%d%d", &n, &k);
        for(int i = 0;i < n;++i)
            scanf("%d", &arrayA[i]);

        for(int i = 0;i < n;++i)
            scanf("%d", &arrayB[i]);

        sort(arrayA, &arrayA[n]);
        sort(arrayB, &arrayB[n]);

        int flag = 1;
        for(int i = 0, j = n-1;i < n;++i, --j)
        {
            if(arrayA[i] + arrayB[j] < k )
            {
                flag = 0;
                break;
            }
        }

        if(flag == 0)
            printf("NO\n");
        else
            printf("YES\n");


    }
    return 0;
}
