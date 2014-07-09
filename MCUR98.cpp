#include<iostream>
#include<stdio.h>
#define max 1000000
using namespace std;
int selfSum(int i)
{
    int sum = i;
    while(i > 0)
    {
        sum += i % 10;
        i = i / 10;
    }

    return sum;
}
bool isNotSelf[max] = {0};
int main()
{
    for(int i = 1;i < max; ++i)
    {
        int sum = selfSum(i);
        if(sum < max)
            isNotSelf[sum] = 1;

    }



    for(int i = 1; i < max; ++i)
        if(isNotSelf[i] == 0)
            printf("%d\n", i);



    return 0;

}
