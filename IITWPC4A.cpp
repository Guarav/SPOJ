#include<iostream>
#include<stdio.h>
#include<string.h>
#define max 100001
using namespace std;
long long int calculateStringConversionLength ( long long int m, long long int n, char inputString[max] )
{

            char previous = inputString[0];
            long long int tempLength = previous != 'a' ? 1 : 0;
            long long int count = previous != 'a' ? 0 : 1;
            for(int i = 1; inputString[i] != '\0'; ++i)
            {
                if( inputString[i] == previous && previous == 'a' )
                    count++;
                else if( inputString[i] != 'a' )
                {
                    if( count > 0 )
                    {
                        tempLength += (count/m)*n + count % m ;
                    }
                    count = 0;
                    tempLength++;
                }
                else if( inputString[i] == 'a' )
                {
                    count = 1;
                    previous = 'a';

                }
                else
                    tempLength ++;
            }
            if( count > 0 )
                tempLength += (count/m)*n + count % m ;

            return tempLength;
}
int main()
{
    int t;
    long long int m, n;
    char inputString[max];
    scanf("%d", &t);
    while(t-->0)
    {
        long long int smallestLength = 0;
        long long int largestLength = 0;
        int stringLength = 0;
        scanf("%s", inputString);
        stringLength = strlen(inputString);
        scanf("%lld%lld", &m, &n);

        // we need to convert m a's to n'b
        if( m > n )
        {
            largestLength = stringLength;
            // find the length of string which have consecutive m's a and make it n'b
            smallestLength = calculateStringConversionLength(m, n, inputString);

        }
        else if(m < n)
        {
            smallestLength = stringLength;
            largestLength = calculateStringConversionLength(m, n, inputString);
        }
        else{
            smallestLength = largestLength = stringLength;
        }

        printf("%lld %lld\n", smallestLength, largestLength);
    }
    return 0;
}

