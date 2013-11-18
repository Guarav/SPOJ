#include<iostream>
#include<stdio.h>
using namespace std;
int main()
{
    int t,a,b,c,n;
    scanf("%d",&t);
    while(t-->0)
    {
                int sum=0,pre=10,j=0,ar[20][3];
                for(int i=0;i<20;++i)
                {
                        for(int j=0;j<3;++j)
                        ar[i][j]=0;
                }
                scanf("%d",&n);
                while(n-->0)
                {
                               scanf("%d%d%d",&a,&b,&c);
                               ar[j][0]=a;ar[j][1]=b;ar[j][2]=c;
                               ++j;


                }
                for(int i=j-1;i>=1;--i)
                {
                        int a1,a2,a3;
                        if(ar[i][1] > ar[i][2])
                        {
                                      a1=ar[i-1][0]+ar[i][2];
                        }
                        else a1=ar[i][1]+ar[i-1][0];

                        if(ar[i][0] > ar[i][2])
                        {
                                      a2=ar[i-1][1]+ar[i][2];
                        }
                        else a2=ar[i][0]+ar[i-1][1];

                        if(ar[i][1] > ar[i][0])
                        {
                                      a3=ar[i-1][2]+ar[i][0];
                        }
                        else a3=ar[i][1]+ar[i-1][2];
                        ar[i-1][0]=a1;
                        ar[i-1][1]=a2;
                        ar[i-1][2]=a3;

                }
                int min=10000000;
                for(int i=0;i<3;++i)
                {
                        if(ar[0][i]<min)
                        min=ar[0][i];
                }
                printf("%d\n",min);

    }
   // system("pause");
    return 0;
}



