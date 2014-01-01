#include<iostream>
#include<stdio.h>
using namespace std;
#define maxLimit 100001
void compressString (char input[maxLimit])
{
        char prevC = input[0];

        int charCount = 1;
        for ( int i = 1; input[i] != '\0'; ++i )
        {
            if( input[i] == prevC )
            {
                charCount++;
            }
            else
            {
                if( charCount > 3)
                {
                    printf("%d!%c", charCount, prevC);

                }
                else
                {
                    for(int j = 0;j < charCount; ++j)
                        printf("%c", prevC);

                }
                prevC = input[i];
                charCount = 1;

            }

        }
        if( charCount > 3)
        {
            printf("%d!%c", charCount, prevC);
        }
        else
        {
            for(int j = 0;j < charCount; ++j)
                printf("%c", prevC);
        }
        printf("\n");


}
int main()
{
    int t;
    char input[maxLimit];

    while(scanf("%s", input) != EOF)
    {

        compressString(input);
    }
    return 0;
}
