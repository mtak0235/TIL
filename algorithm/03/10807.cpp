#include <vector>
#include <iostream>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    int n; 
    cin >> n;
    vector<int> arr(n);
    for (vector<int>::iterator iter = arr.begin(); iter != arr.end(); iter++) cin>> *iter;
    int x, cnt = 0; 
    cin >> x;
    for (vector<int>::iterator iter = arr.begin(); iter != arr.end(); iter++) {
        if (*iter == x)
            cnt++;
    }
    cout << cnt;
}