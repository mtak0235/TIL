#include <iostream>
#include <cstring>
using namespace std;
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    int alphabet[26];
    fill(alphabet, alphabet + 26, 0);
    string s;
    cin >> s;
    for (char c : s) {
        alphabet[c - 'a'] += 1;
    }
    for (auto p: alphabet)
        cout << p << " ";
    
}