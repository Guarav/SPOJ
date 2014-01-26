#include<iostream>
#include<stdio.h>
#include<math.h>
using namespace std;
int main()
{
    int t, x, y;
    scanf("%d", &t);
    while(t-->0)
    {
        int max, min;
        scanf("%d%d", &x, &y);
        max = x > y ? x : y;
        min = x > y ? y : x;

        double result = sqrt( max*max - min*min );
        result = result * 2;
        printf("%.3lf\n", result);
    }
    return 0;
}

