#include<iostream>
#include<stdio.h>
#include<queue>
#define max 100001
using namespace std;
int wealthVal[ max + 5 ];  // + 5 - to be on a safer side
void generateNodesWealth()
{
    // we will only store the denominator value in array
    wealthVal[1] = 1;
    queue<int> q;
    q.push(1);
    int nodesCount = 1;
    while(!q.empty())
    {
        int current = q.front();
        int left = nodesCount + 1;
        int right = nodesCount + 2;


        if( current % 2 == 0 ) // male
        {
            wealthVal[left] = 2*wealthVal[current];
            wealthVal[right] = 2*wealthVal[current];
        }
        else // female
        {
            wealthVal[left] = 2*wealthVal[current];
            wealthVal[right] = 4*wealthVal[current];
        }
        if( left >= max || right >= max )
            break;

        q.push(left);
        q.push(right);
        nodesCount += 2;
        q.pop();
    }
}
int main()
{
    // generate the wealth of all the nodes
    generateNodesWealth();

    int t, x, y;
    double w;
    scanf("%d", &t);
    while(t-->0)
    {

        scanf("%d%d%lf", &x, &y, &w);
        double givenIniVal = wealthVal[x]*w;


        double requiredVal = givenIniVal/wealthVal[y];


        printf("%.6lf\n", requiredVal);

    }
    return 0;

}
