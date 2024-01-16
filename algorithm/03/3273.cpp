#include <iostream>
#include <vector>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    int n, x;
    cin >> n;
    vector<int> arr(1000001);
    for (int i = 0; i < n; i++) {
        int got;
        cin >> got;
        arr[got] = got;
    }
    cin >> x;
    int cnt = 0;
    for (int i = 1; i < arr.size(); i++) {
        if (i != x - i && x - i <  arr.size() && arr[i]&& arr[x - i] && arr[i] < arr[x - i]) {
            arr[i] = 0;
            arr[x - i] = 0;
            cnt++;
        }
    }
    cout << cnt; 
}