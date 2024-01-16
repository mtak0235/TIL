#include <iostream>
#include <string>
using namespace std;
int main() {
    int n;
    cin >> n;
    for (int i = 0; i < n - 1; i++) {
        string ret = "";
        for (int k = 0; k < n - i - 1;k++) ret += " ";
        for (int k = 2 * i + 1; k > 0;k--) ret += "*";
        cout << ret << "\n";
    }
    for (int i = 0; i < n; i++) {
        string ret = "";
        for (int k = 0; k < i;k++) ret += " ";
        for (int k = 2 * (n - i) - 1; k > 0;k--) ret += "*";
        cout << ret << "\n";
    }
}