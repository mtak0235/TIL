#include <iostream>
#include <bits/stdc++.h>
using namespace std;

void sol1() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    int n, x, a[10005];
    cin >> n >> x;
    for (int i = 0; i < n; i++) cin >> a[i];
    for (int i = 0; i < n; i++) if (a[i] < x) cout << a[i] << " ";
}

void sol2() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    int n, x, t;
    cin >> n >> x;
    while (n--) {
        cin >> t;
        if (t < x) cout << t << " ";
    }
}
int main() {
    sol1();
    sol2();
}

