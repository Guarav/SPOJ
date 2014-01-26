#include<iostream>
#include<stdio.h>
#include<string.h>
#define max 100001
using namespace std;
int isPalindrome(char input[max])
{
    int stringSize = strlen( input );
    for(int i = 0, j = stringSize-1; i < stringSize/2; ++i, --j)
    {
        if( input[i] != input[j] )
            return 0;
    }
    return 1;
}
int main()
{
    int t;
    char inputStr[max];
    scanf("%d", &t);
    while(t-->0)
    {
        scanf("%s", inputStr);
        char updatedString[max];
        //ietraye and remove duplicates
        int index = 1;
        char prev = inputStr[0];
        updatedString[0] = prev;
        for(int i = 1;inputStr[i] != '\0'; ++i)
        {
            if( inputStr[i] != prev  )
            {
                updatedString[index++] = inputStr[i];
            }
            prev = inputStr[i];
        }
        updatedString[index] = '\0';
        

        // check palindrome in updatedString
        if( isPalindrome( updatedString ) )
            printf("YES\n");
        else
            printf("NO\n");

    }
    return 0;

}


