#include<iostream>
#include<cstdio>
#include<cmath>
#define debug(i) cout<<"debugging "#i" is"<<i<<endl;
#define BUGS 0
using namespace std;
bool func(int n,long long int k,int prev)
{
    if(n==1)return prev;

    if((long long int)pow(2.0,n-2)>=k)
    {
        int temp;
        if(BUGS)
        {
        debug(n);
        debug(k);
        debug(prev);
        }
        if(prev==0)return func(n-1,k,1);
        else return func(n-1,k,0);
    }
    else
    {
        int temp;
        if(BUGS)
        {
        debug(n);
        debug(k);
        debug(prev);
        debug((long long int)pow(2.0,n-2));
        }
        if(prev==1)return func(n-1,k-(long long int)pow(2.0,n-2),1);
        else return func(n-1,k-(long long int)pow(2.0,n-2),0);
        }

}

int main()
{
    int test;
    test=100;
    int n;
    scanf("%d",&n);
    n = n + 1;
    long long int k;
    scanf("%lld", &k);
    k = k + 1;
    // 1 signifies red and 0 signifies blue
    if(func(n,k,1))
        printf("red\n");
    else
        printf("blue\n");
    return 0;
}


