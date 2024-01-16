#include <bits/stdc++.h>
using namespace std;
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    string src, target;
    cin >> src >> target;
    int sets[26] = {};
    for (char c : src) sets[c - 'a'] += 1;
    for (char c: target) sets[c - 'a'] -= 1;
    int cnt = 0;
    for (int i: sets) {
        if (i != 0) cnt += abs(i);
    }
    cout << cnt;

}