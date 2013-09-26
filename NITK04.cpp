#include<iostream>
#include<stdio.h>
using namespace std;
int main()
{
    int t, X;
    double Y;
    scanf("%d", &t);
    while(t-->0)
    {
        scanf("%d%lf", &X, &Y);
        if(X % 10 != 0 || X + 0.5 > Y)
        {
            printf("%.2lf\n", Y);
            continue;
        }
        printf("%.2lf\n", Y - X - 0.5);
    }
    return 0;
}
