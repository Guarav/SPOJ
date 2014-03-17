    #include<iostream>
    #include<stdio.h>
    using namespace std;
    int main()
    {
        int n;
        scanf("%d", &n);
        if( n == 2 )
        {
            long long int a, b;
            scanf("%lld%lld", &a, &b);
            printf("%lld\n", a^b);
        }
        else
        {
            long long int result = 0;
            for(int i = 0; i < n; ++i )
            {
                long long int temp ;
                scanf("%lld", &temp);
                result = result | temp;
            }
            printf("%lld\n", result);
        }
        return 0;

    }

