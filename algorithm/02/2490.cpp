#include <iostream>
#include <vector>
using namespace std;

int cnt_0(vector<int> &arr) {
    int cnt = 0;
    for (int i : arr) {
        if (i == 0) cnt++;
    }
    return cnt;
}
int main() {
    ios::sync_with_stdio(0);
    std::cin.tie(0);
    string set[5] = {"E", "A", "B", "C", "D"};
    for (int i = 0; i < 3; i++) {
        vector<int> tmp(4);
        for(int j = 0; j < tmp.size(); j++) cin >> tmp[j];
        cout << set[cnt_0(tmp)] << '\n';
    }
}
