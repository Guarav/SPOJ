#include <iostream>
#include<stdio.h>
using namespace std;

int main() {
	
	int t ;
	scanf("%d", &t);
	while(t-->0) {
		int n;
		scanf("%d", &n);
		double ans = 0;
		for(int i = 0; i < n; ++i) {
			int a;
			scanf("%d", &a);
			ans += a;
			
		}
		
		ans = ans / n;
		printf("%.15f\n", ans);
	}
	return 0;
}
