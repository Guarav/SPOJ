#include<iostream>
#include<stdio.h>
#include<string.h>
#define maxLength 1000
using namespace std;
int convertNumToDigitsAndReturnLength(int key, int keyDigits[10])
{
    int index = 0;
    while(key > 0)
    {
        keyDigits[index++] = key % 10;
        key = key / 10;
    }
    return index;
}

int main()
{
    int t, key;
    char inputMessage[maxLength], keyString[10];
    scanf("%d", &t);
    while(t-->0)
    {
        scanf("%s", keyString);
        int keyLength = strlen(keyString);
        int keyDigits[10];
        //conver the key to digits
        //int keyLength = convertNumToDigitsAndReturnLength(key, keyDigits);
        scanf("%s", inputMessage);



        //encode message now
        for(int i = 0; inputMessage[i] != '\0'; ++i)
        {
            int keyDigitRemainder = i % keyLength;
            int keyDigitQuotient = i / keyLength;

            if( keyDigitQuotient % 2 == 0 )
            {
                // at even positions we use direct key digits
                int posn = inputMessage[i] - ( keyString[keyDigitRemainder] - '0' );
                //cout<<posn<<"   "<<inputMessage[i]<<"   "<<keyDigits[keyDigitRemainder]<<endl;
                if(posn < 97)
                {
                    posn =  26 + 97 + posn - 97;
                }
                printf("%c", posn);
            }
            else
            {
                // at even positions we use reversed key digits
                int posn = inputMessage[i] - ( keyString[ keyLength - 1 -keyDigitRemainder] - '0' );
                if(posn < 97)
                {
                    posn =  26 + 97 + posn - 97;
                }
                printf("%c", posn);
            }
        }
        printf("\n");
    }
    return 0;

}

