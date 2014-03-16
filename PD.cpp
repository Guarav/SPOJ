#include<iostream>
#include<stdio.h>
using namespace std;
void display(int n)
{
    int limit = n * n;
        int leftIndex = 0;
        int rightIndex = n - 1;
        int topIndex = 0;
        int bottomIndex = n - 1;

        int matrix[n][n];

        int num = 1;
        while(num <= limit )
        {
            for( int i = leftIndex; i <= rightIndex; ++i )
            {
                matrix[topIndex][i] = num++;
            }

            for(int i = topIndex + 1; i <= bottomIndex; ++i)
            {
                matrix[i][rightIndex] = num++;
            }

            for(int i = rightIndex - 1; i >= leftIndex; --i)
            {
                matrix[bottomIndex][i] = num++;
            }

            for(int i = bottomIndex - 1; i > topIndex; --i)
            {
                matrix[i][leftIndex] = num++;
            }

            leftIndex++;
            rightIndex--;
            topIndex++;
            bottomIndex--;

        }


        for(int i = 0; i < n; ++i)
        {
            for(int j = 0; j < n ; ++j)
            {
                if( j != n-1 )
                    printf("%d\t", matrix[i][j]);
                else
                    printf("%d",matrix[i][j]);
            }
            //if( i != n-1 )
                printf("\n");
        }
}
int main()
{
    int n;
    scanf("%d", &n);
    /*
    if( n == 1 )
        printf("1\n");
    else
    */
        display(n);
    return 0;
}

