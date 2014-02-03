#include<iostream>
#include<stdio.h>
#include<algorithm>
#define max 101
using namespace std;
int main()
{
    int t, n, k;
    scanf("%d", &t);
    while(t-->0)
    {
        int input[max];
        int negative = 0;
        int totalNegative = 0;
        int positive = 0;
        int totalPositive = 0;
        int zero = 0;
        int absolMin = 1000000;
        scanf("%d%d", &n, &k);
        for(int i = 0; i < n; ++i)
        {
            scanf("%d", &input[i]);
            if( input[i] < 0 )
            {
                negative = 1;
                totalNegative++;
            }


            else if( input[i] == 0 )
                zero = 1;
            else if( input[i] > 0 )
            {
                positive = 1;
                totalPositive++;
            }

            if( abs(input[i]) < absolMin )
                absolMin = abs(input[i]);

        }

        if( zero )
        {

            if( negative )
            {
                if( k > totalNegative )// make all positive
                {
                    for(int i = 0; i < totalNegative ;++i)
                        if( input[i] < 0 )
                            input[i] = -1*input[i];

                }
                else
                {
                    for(int i = 0; i < k ; ++i)
                        if( input[i] < 0 )
                            input[i] = -1*input[i];
                }
            }
            else
            {

            }

        }
        else
        {
            if( negative )
            {
                if( k > totalNegative )// make all positive
                {
                    int rem = k - totalNegative;
                    for(int i = 0; i < totalNegative ;++i)
                        if( input[i] < 0 )
                            input[i] = -1*input[i];


                    // now sort
                    int min = 100000, pos = 0;
                    for(int i = 0; i < n; ++i)
                    {
                        if(input[i] < min)
                        {
                            min = input[i];
                            pos = i;
                        }
                    }
                    if( rem % 2 != 0 )
                        input[pos] = -1*input[pos];

                }
                else
                {
                    for(int i = 0; i < k ; ++i)
                    {
                        input[i] = -1*input[i];
                    }

                }
            }
            else
            {
                if( k % 2 != 0)
                    input[0] = -1*input[0];
            }

        }

        // take the sum
        int sum = 0;
        for(int i = 0;i < n ; ++i)
            sum += input[i];

        printf("%d\n", sum);

    }
    return 0;

}

