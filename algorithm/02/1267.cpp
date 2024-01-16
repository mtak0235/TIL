#include <iostream>
#include <string>
using namespace std;
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    int n;
    cin >> n;
    int y = 0;
    int m = 0;
    for (int i = 0; i < n; i++) {
        int got;
        cin >> got;
        y += (got / 30 + (got % 30 >= 0)) * 10;
        m += (got / 60 + (got % 60 >= 0)) * 15;
    }
    cout << ((y == m)? "Y M " + to_string(y):(y < m)? "Y " + to_string(y): "M " + to_string(m));
    
}