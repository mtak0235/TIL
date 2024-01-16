#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
int main() {
    vector<int> heights(9);
    for (int i = 0; i < 9; i++) cin >> heights[i];
    sort(heights.begin(), heights.end());
    int currentSum = -100;
    for (vector<int>::iterator iter = heights.begin(); iter != heights.end(); iter++) currentSum += *iter;
    for (int i = 0; i < heights.size(); i++) {
        for (int j = heights.size() - 1; i < j; j--)
            if (heights[i] + heights[j] == currentSum) {
                for (int k = 0; k < heights.size(); k++) {
                    if (k != i && k != j)
                    cout << heights[k] << "\n";
                }
                return 0;
            }
    }
}