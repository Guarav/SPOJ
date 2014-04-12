#include<iostream>
#include<math.h>
#include<stdio.h>
using namespace std;
int main()
{
    int t;
    long long int b, a, x;
    scanf("%d", &t);
    while(t>0)
              {
              scanf("%lld%lld", &a, &b);
              int m;
              int aLastDigit = a % 10;
		
              if(b==0)printf("1\n");
              else if(aLastDigit==1||aLastDigit==5||aLastDigit==6||aLastDigit==11||aLastDigit==15||aLastDigit==16||aLastDigit==10||aLastDigit==20)printf("%d\n", a%10);
              else
               {   if(aLastDigit==2||aLastDigit==3||aLastDigit==7||aLastDigit==8||aLastDigit==12||aLastDigit==13||aLastDigit==17||aLastDigit==18)
                  {m=b%4; if(m==0)m=4;x=pow(aLastDigit,m);printf("%d\n", x%10);}
                  else {m=b%2; if(m==0)m=2;x=pow(aLastDigit,m);printf("%d\n", x%10);}
              }
              --t;}

    return 0;
}







