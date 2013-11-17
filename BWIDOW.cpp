#include<iostream>
#include<stdio.h>
#include<algorithm>
#define max 1001
//todo : can be done in very easy way also but the problem didnt demand it
using namespace std;
struct radii
{
    int inner;
    int outer;
    int index;
};
int sortFunc(struct radii a, struct radii b)
{
    if( a.inner > b.inner )
        return 1;
    return 0;
}
int sortFunc1(struct radii a, struct radii b)
{
    if( a.outer > b.outer )
        return 1;
    return 0;
}
int main()
{
    int t, n, r, R;
    scanf("%d", &t);
    while(t-->0)
    {
        scanf("%d", &n);
        int maxInnerRad = 0;
        struct radii radiiOb[max];
        for(int i = 1; i <= n;++i)
        {
            scanf("%d%d", &radiiOb[i-1].inner, &radiiOb[i-1].outer);
            radiiOb[i-1].index = i;
        }
        // first sort the strcuture on the basis of inner radii
        sort(radiiOb, &radiiOb[n], sortFunc);
        int result = true;
        if( radiiOb[0].inner == radiiOb[1].inner ) // should not be equal
            result = false;
        else
        {
            int maxInner = radiiOb[0].inner;
            int maxOuter = radiiOb[0].outer;
            // now sort on the basis of outer radii
            sort(radiiOb, &radiiOb[n], sortFunc1);
            if( radiiOb[0].outer == radiiOb[1].outer ) // again max should not be same
                result = false;

            if(maxInner <= radiiOb[1].outer  || maxOuter != radiiOb[0].outer) // 
                result = false;
        }
        if( result )
            printf("%d\n", radiiOb[0].index);
        else
            printf("-1\n");

    }
    return 0;
}
