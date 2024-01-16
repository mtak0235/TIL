#include <iostream>
#include <vector>
using namespace std;
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    vector<int> odds;
    for (int i = 0; i < 7; i++) {
        int get;
        cin >> get;
        if (get%2 != 0) odds.push_back(get);
    }
    if (odds.size() == 0)
        cout << -1;
    else {
        int sum = 0;
        for (vector<int>::iterator iter = odds.begin(); iter != odds.end(); iter++) sum += *iter;
        cout << sum << "\n";
        int min = odds.at(0);
        for (vector<int>::iterator iter = odds.begin(); iter != odds.end(); iter++) {
            if (*iter < min)
                min = *iter;
        }
        cout << min;
    }
}