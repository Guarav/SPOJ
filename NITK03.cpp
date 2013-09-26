#include<iostream>
#include<algorithm>
#include<stdio.h>
#define max 1000
using namespace std;
void convertStringToArray(char NumbStr[max], int Number[max])
{
    for(int i = 0 ; NumbStr[i] != '\0'; ++i)
    {
        Number[i] = NumbStr[i] - '0';
    }
}

void reverseArrayFromBehind(int Number[max])
{
    reverse(Number, Number + max);
}

void addArrays(int first[max], int second[max], int result[max])
{
    int carry = 0;
    int i;
    for( i = max - 1; i >=0;--i )
    {
        int temp = first[i] + second[i] + carry;
        result[i] = temp%10;
        carry = temp/10;
    }
    if(carry)
        result[i] = carry;
}

int removingFrontZeroes(int result[max])
{
    for(int i = 0 ; i < max; ++i)
    {
        if(result[i] != 0)
        {
            return i;
        }
    }
    return 0;
}

int removingTrailingZeroes(int result[max])
{
    for(int i = max-1;i >= 0; --i)
    {
        if(result[i] != 0)
            return i;
    }
    return 0;
}
int main()
{
    int t;


    scanf("%d", &t);
    while(t-->0)
    {
        char firstNumbStr[max] , secondNumbStr[max] ;
        int firstNumber[max] = {0}, secondNumber[max] = {0}, result[max];
        scanf("%s%s", firstNumbStr, secondNumbStr);

        convertStringToArray(firstNumbStr, firstNumber);

        convertStringToArray(secondNumbStr, secondNumber);

        reverseArrayFromBehind(firstNumber);

        reverseArrayFromBehind(secondNumber);

        addArrays(firstNumber, secondNumber, result);

        reverseArrayFromBehind(result);

        int startingindex = removingFrontZeroes(result);
        int endIndex = removingTrailingZeroes(result);


        for(int i = startingindex; i <= endIndex ; ++i)
            printf("%d", result[i]);

        printf("\n");

    }
    return 0;


}

