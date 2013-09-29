#include<iostream>
#include<stdio.h>
#include<string.h>
#define max 100
using namespace std;
void calculateOverSummary(char inputString[max], char overSummary[max])
{
    int count = 0;
    for(int i = 0;inputString[i] != '\0'; ++i)
    {
        if( inputString[i] != ' ' )
        {
            overSummary[count++] = inputString[i];
        }
    }
}
using namespace std;
int main()
{
    char inputString[max] ;
    gets(inputString);
    char overSummary[max];
    calculateOverSummary(inputString, overSummary);
    int batsmen[3] = {0};
    int bat = 0;    // 0 signifies batsman 1(bat : batting), 1 signifies batsman 2(run : running)
    int run = 1;
    int totalWicketsOut = 0;
    int totalBalls = strlen(overSummary);
    for(int i = 0; i < totalBalls ; ++i)
    {
        if( overSummary[i] >= '0' && overSummary[i] <= '9' )    // means is digit
        {
            int runScored = overSummary[i] - '0';

            batsmen[ bat ] += runScored;
            if( runScored % 2 != 0 )    // switches sides
            {
                int temp = bat;
                bat = run;
                run = temp;
            }
        }
        else if(overSummary[i] == 'O' )
        {
            totalWicketsOut++;
            bat = 2;
        }
    }

    printf("%d\n", batsmen[0]);
    printf("%d\n", batsmen[1]);
    printf("%d", batsmen[2]);

    return 0;
}
