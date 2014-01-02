#include<iostream>
#include<stdio.h>
#include<math.h>
#define maxLimit 10001
using namespace std;
double geDistanceBetweenTwoPoints( int x1, int y1, int x2, int y2 )
{
    return sqrt( ((double)x1-x2)*(x1-x2) + (y1-y2)*((double)y1-y2) );
}
double min(double a, double b)
{
    if( a > b)
        return b;
    return a;

}

double max(double a, double b)
{
    if( a > b)
        return a;
    return b;

}
int main()
{
    int t, n;
    int coordX[ maxLimit ], coordY[maxLimit];
    scanf("%d", &t);
    while(t-->0)
    {
        scanf("%d", &n);
        for(int i= 0; i < n; ++i)
        {
            scanf("%d%d", &coordX[i], &coordY[i]);
        }
        // store the max found and
        double maxRad = 0;
        double minRad = 1;
        int condMet = true;
        double pointRad = 1000000;
        for(int i = 0;i < n && condMet == true;++i)
        {
            pointRad = 1000000;
            for(int j = 0; j < n; ++j)
            {
                if( i == j)
                    continue;
                // get distance between two points
                double dist = geDistanceBetweenTwoPoints( coordX[i], coordY[i], coordX[j], coordY[j] );
                if( dist < 2*minRad )
                {
                    // brak the loop
                    condMet = false;
                    break;
                }

                double presentRad  =  dist - minRad;
                pointRad = min(pointRad, presentRad);

            }
            maxRad = max( maxRad, pointRad );
        }
        if( condMet  )
            printf("%.6lf\n", maxRad);
        else
            printf("-1.000000\n");
    }
}
