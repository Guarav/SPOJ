#include<iostream>
#include<stdio.h>
#include<string.h>
#include<ctype.h>
#include<stdlib.h>
using namespace std;
int divideBigNumber( char inputString[50], int quotient[50], int res[2] )
{
    int length = strlen(inputString);
    int dividend ;
    char dividendStr[3] ;
    dividendStr[0] =  inputString[0];
    dividendStr[1] = '\0';
    int quotientCount = 0;
    for(int i = 1; i< length; ++i)
    {
        dividend = atoi(dividendStr);
        if(dividend >= 9)
        {
            quotient[quotientCount++] = dividend/9;
            if( dividend % 9 != 0)
            {
                dividendStr[0] = dividend % 9 + '0';
                dividendStr[1] = inputString[i];
                dividendStr[2] = '\0';
            }
            else
                {
                    dividendStr[0] = inputString[i];
                    dividendStr[1] = '\0';
                }
        }
        else
        {
            if( strlen(dividendStr) == 0)
            {
                quotient[quotientCount++] = 0;
                dividendStr[0] = inputString[i];
                dividendStr[1] = '\0';
            }
            else
            {
                quotient[quotientCount++] = 0;
                dividendStr[1] = inputString[i];
                dividendStr[2] = '\0';
            }


        }

    }
        dividend = atoi(dividendStr);
        int remainder;
        if(dividend >= 9)
        {
            quotient[quotientCount++] = dividend/9;
            remainder = dividend%9;
        }
        else
        {
            quotient[quotientCount++] = 0;
            remainder = dividend;
        }

        res[0] = remainder;
        res[1] = quotientCount;
}
int main()
{
    int t;
    char inputString[50];
    //scanf("%d", &t);
    while(1)
    {
        scanf("%s", inputString);
        if(!strcmp(inputString, "-1"))
            break;

        if(strlen(inputString) == 1 && inputString[0] == '0')
        {
            printf("0\n");
            continue;
        }
        if(strlen(inputString) == 1)
        {
            printf("1\n");
            continue;
        }

        int quotient[50] = {0};
        int res[2] = {0};
        divideBigNumber( inputString, quotient, res ) ;




        int remainder = res[0] ;
        int quotientCount = res[1];

        int result[100] = {0};
        int k = 99;
        int carry = 0 ;
        if( remainder )
            carry  = 1;

        for(int i = quotientCount - 1;i >= 0; --i)
        {
            int temp = quotient[i] + carry;
            result[k--] = temp%10;
            carry = temp/10;

        }
        int index = 0;
        for(int i = 0;i < 100;++i)
            if(result[i] != 0)
            {
                index = i;
                break;
            }

        for(int i = index; i < 100;++i)
            printf("%d", result[i]);

        printf("\n");


    }
    return 0;
}
