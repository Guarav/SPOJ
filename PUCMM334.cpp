#include<iostream>
#include<stdio.h>
#define max 10001
using namespace std;
int main()
{
    int t, n, input[max];
    scanf("%d", &t);
    while(t-->0)
    {
        scanf("%d", &n);
        int hash[max] = {0}, positionsAlloted[max]={0};
        int a;
        // taking the first input
        scanf("%d", &a);
        input[0] = a;
        int maxFound = a;
        int minFound = a;
        int errorFound = 0;
        for(int i = 1;i < n; ++i)
        {
            scanf("%d", &input[i]);
            if( input[i] > n )
            {
                errorFound = 1;
            }
            else
            {
                if( input[i] > maxFound )
                    maxFound = input[i];

                if( input[i] < minFound )
                    minFound = input[i];
            }
        }


        if(errorFound)
            printf("-1\n");
        else
        {
            // check the values of every input
            for(int i = 0;i < n; ++i)
            {

                if( input[i] == maxFound )
                    positionsAlloted[i] = 0;

                if( input[i] == minFound )
                    positionsAlloted[i] = 1;

                if( input[i] != minFound && input[i] != maxFound )
                {
                    errorFound = 1;
                    break;
                }
            }

            if( errorFound || maxFound - minFound > 1 )
                printf("-1\n");
            else
            {
                int totalCount = 0;
                for(int i = 0;i < n; ++i)
                {
                    if(positionsAlloted[i] == 1)
                        totalCount++;
                }

                // check the validity of the position
                for(int i = 0;i < n; ++i)
                {
                    if( positionsAlloted[i] == 1 && input[i] != totalCount - 1 )
                    {
                        errorFound = 1;
                        break;
                    }

                    if( positionsAlloted[i] == 0 && input[i] != totalCount )
                    {
                        errorFound = 1;
                        break;
                    }
                }

                if(errorFound)
                    printf("-1\n");
                else
                    printf("%d\n", totalCount);
            }
        }
    }
    return 0;
}

