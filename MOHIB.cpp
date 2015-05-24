#include <iostream>
using namespace std;

int main() {
	
	int t;
	scanf("%d", &t);
	
	while(t-->0){
		int x, a;
		scanf("%d", &x);
		scanf("%d", &a);
		
		int ans = a*a - x*x - 3*x + 3*a;
		ans = ans / 2;
		
		printf("%d\n", ans);
	}

	return 0;
}
