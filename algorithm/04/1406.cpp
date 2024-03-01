#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    list<char> l;
    string given;
    int cmdCnt;
    cin >> given >> cmdCnt;
    for (char c: given) l.push_back(c);
    list<char>::iterator iter = l.end();
    while (cmdCnt--) {
        string f;
        cin>>f;
        if (f == "P") {
            char a;
            cin >> a;
            l.insert(iter, a);
        } else if (f == "L") {
            if (l.begin() != iter) iter--;
        } else if (f == "D") {
            if (l.end() != iter) iter++;
        } else if (f == "B") {
            if (iter != l.begin()) {
                iter--;
                iter = l.erase(iter);
            }
        }
    }
    for (list<char>::iterator i = l.begin(); i != l.end(); i++) cout << *i;
}