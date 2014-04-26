#include<iostream>
#include<algorithm>
using namespace std;
int main()
{
    int t, n,ar[100001],p=1;
    scanf("%d",&t);
    while(t-->0)
    {
                int k,hash[100001]={0};
                long long int count = 0;
                scanf("%d",&k);
                scanf("%d",&n);
                int i=0;
                while(n-->0)
                {
                            scanf("%d",&ar[i]);
                            hash[ar[i]]++;
                            ++i;
                }
                n=i;
                for(int i=0;i<n;++i)
                {
                        int temp = k - ar[i];
                        if(temp >= 0){
                        if(hash[temp] > 0 && hash[ar[i]] > 0)
                        {

                                      if(ar[i] == temp)
                                      {
                                               long long int tot = hash[temp];
                                               count += tot*(tot-1)/2;
                                               hash[temp]=0;
                                      }
                                      else
                                      {
                                          count+=(long long int)hash[temp]*hash[ar[i]];
                                          hash[temp]=0;
                                          hash[ar[i]]=0;
                                      }
                        }
                    }
                }

                printf("%d. %lld\n",p,count);
                p++;
    }

    return 0;
}






