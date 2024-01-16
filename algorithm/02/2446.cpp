#include <iostream>
#include <string>
using namespace std;
int main() {
    int n;
    cin >> n;
    for (int i = 0; i < n; i++) {
        string ret = "";
        for (int k = i; k > 0;k--) ret += " ";
        for (int k = 0; k < 2 * n - 2 * i - 1;k++) ret += "*";
        cout << ret << "\n";
    }
    for (int i = 0; i < n - 1; i++) {
        string ret = "";
        for (int k = n - (i + 2); k > 0;k--) ret += " ";
        for (int k = 0; k < 2 *i + 3;k++) ret += "*";
        cout << ret << "\n";
    }
}