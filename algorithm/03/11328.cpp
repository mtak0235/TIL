#include <bits/stdc++.h>
using namespace std;
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    int n;
    cin >> n;
    int sets[26] = {};

    while (n--) {
        string result = "Possible";
        fill(sets, sets + 26, 0);
        string src, target;
        cin >> src >> target;
        for (char c : src) sets[c - 'a'] += 1;
        for (char c: target) sets[c-'a'] -= 1;
        for (int i : sets) {
            if (i != 0) {
                result = "Impossible";
                break;
            }
        }
        cout << result << "\n";
    }
}