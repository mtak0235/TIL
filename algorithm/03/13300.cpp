#include <iostream>
#include <vector>
using namespace std;
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    int n, k; 
    int arr[7][2] = {};
    cin >> n >> k;
    for (int i = 0; i < n; i++) {
        int g, y;
        cin >> g >> y;
        arr[y][g] += 1;
    }
    int cnt = 0;
    for (int r = 1; r < 7; r++) {
        for (int c = 0; c < 2; c++) {
            if (arr[r][c] >0) {
                cnt += arr[r][c] / k + (arr[r][c] % k > 0);
            }
        }
    }
    cout << cnt;
}