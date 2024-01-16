#include <iostream>
#include <string>
using namespace std;
int main() {
    int n;
    cin >> n;
    for (int i = 0; i < n; i++) {
        string ret = "";
        for (int k = n - (i + 1); k > 0;k--) ret += " ";
        for (int j = 0; j <= i; j++) ret += "*";
        cout << ret << "\n";
    }
}