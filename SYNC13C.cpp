#include<iostream>
#include<stdio.h>
using namespace std;
int main()
{
    // by hit and trial -- observing the cases
    int t, n, m;
    scanf("%d", &t);
    while(t-->0)
    {
        scanf("%d%d", &m, &n);
        if(m % 2 != 0 && n % 2 != 0)
            printf("Ramesh\n");
        else
            printf("Suresh\n");
    }
    return 0;
}
