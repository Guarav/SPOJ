#include<iostream>
#include<stdio.h>
#define maxNodes 501
using namespace std;
int main()
{
    int t, n, m, caseNumb = 1;
    scanf("%d", &t);
    while(t-->0)
    {
        int edges[maxNodes][maxNodes] = {0};
        scanf("%d%d", &n, &m);
        for(int i = 0; i < m ;++i)
        {
            int a, b;
            scanf("%d%d", &a, &b);
            edges[a][b] = 1;
            edges[b][a] = 1;
        }
        int singlePoint = 0,
            doublePoint = 0,
            threePoint = 0,
            fourPoint = 0;
        // separate the nodes depedning upon the number of edges (incoming/ outgoing )
        bool condMet = true;
        for(int i = 1; i <= n && condMet ;++i)
        {

            int count = 0;
            for(int j = 1 ; j <= n; ++j)
            {
                if( i == j)
                    continue;

                if( edges[i][j] == 1 )
                    count++;
            }
            if( count == 1 )
                singlePoint++;
            else if(count == 2)
                doublePoint ++;
            else if(count == 3)
                threePoint++;
            else if( count == 4)
                fourPoint++;
            else{
                    condMet = false;
                    break;
                }
        }


        if( !condMet )
            printf("Case %d: NotValid\n", caseNumb);
        else
        {
          // there can be only one four point or one three point edge 
            if( fourPoint == 1 && singlePoint && !threePoint )
                printf("Case %d: X\n", caseNumb);
            else if( threePoint == 1 && singlePoint && !fourPoint )
                printf("Case %d: Y\n", caseNumb);
            else if(  singlePoint && !fourPoint && !threePoint)
                printf("Case %d: I\n", caseNumb);
            else
                printf("Case %d: NotValid\n", caseNumb);

        }

        caseNumb++;

    }
    return 0;

}
