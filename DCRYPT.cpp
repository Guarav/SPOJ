#include<iostream>
#include<stdio.h>
#define max 100001
using namespace std;
void decryptMessageLowerKey( char ch, int key )
{
    if( ch == '.')
        printf(" ");
    else
    {
        if(islower(ch))
        {
            int temp = ch - 96;
            temp += key;
            temp = temp % 26;
            temp = temp == 0 ? 26 : temp;
            printf("%c", temp + 96);
        }
        else
        {
            int temp = ch - 64;
            temp += key;
            temp = temp % 26;
            temp = temp == 0 ? 26 : temp;
            printf("%c", temp + 64);
        }
    }
}

void decryptMessageUpperKey( char ch, int key )
{
    if( ch == '.' )
        printf(" ");
    else
    {
        if(islower(ch))
        {
            int temp = ch - 96;
            temp += key;
            temp = temp % 26;
            temp = temp == 0 ? 26 : temp;
            printf("%c", temp + 64);
        }
        else
        {
            int temp = ch - 64;
            temp += key;
            temp = temp % 26;
            temp = temp == 0 ? 26 : temp;
            printf("%c", temp + 96);
        }
    }


}
int main()
{
    int t, key;
    char message[max];
    scanf("%d", &t);
    while(t-->0)
    {
        scanf("%d", &key);
        scanf("%s", message);
        for( int i = 0; message[i] != '\0'; ++i )
        {
            if( key < 26 )
            {
                decryptMessageLowerKey( message[i], key );
            }
            else
            {
                decryptMessageUpperKey( message[i], key );
            }


        }
        printf("\n");
    }
}
