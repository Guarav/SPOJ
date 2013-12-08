#include<iostream>
#include<stdio.h>
#include<math.h>
using namespace std;
#define max 1000001

int main()
{


    int t, a, b;
    scanf("%d", &t);
    while(t-->0)
    {
        scanf("%d%d", &a, &b);
        int sqrA = sqrt(a);
        int sqrB = sqrt(b);

        if(sqrA == sqrB)
        {
            // 0 and 0 which is 0
            printf("0\n");
            continue;
        }

        int leftRes, rightRes;
        leftRes = rightRes = (sqrA+1)*(sqrA+1) - sqrA*sqrA;
        for(int i = sqrA + 1; i < sqrB ; ++i )
        {
            int temp = (i + 1)*(i + 1) - i*i;
            leftRes = leftRes & temp;
            rightRes = rightRes ^ temp;
        }

        printf("%d\n", leftRes & rightRes);
    }
    return 0;
}
