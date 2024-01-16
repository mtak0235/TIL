#include <iostream>
using namespace std;
int main() {
    long long a,b;
    cin >> a >> b;
    if (a>b) swap(a,b);
    if (a == b || b - a == 1) {
        cout << 0;
        return 0;
    }
    cout << b - a - 1<< "\n";
    for (long long i = a + 1; i < b; i++) cout << i << " ";
} // 30