#include<iostream>
#include<stdio.h>
using namespace std;
int main()
{
    int n;
    int hash[200] = {0};
    char inputString[50];
    scanf("%d", &n);
    while(n-->0)
    {
        scanf("%s", inputString);
        hash[ inputString[0] ] ++;

    }
    int found = 0;
    for(int i = 1;i < 200; ++i)
    {
        if( hash[i] >= 5 )
        {
            found = 1;
            printf("%c", i);
        }
    }
    if(!found )
        printf("PREDAJA\n");
    else
        printf("\n");
    return 0;

}
