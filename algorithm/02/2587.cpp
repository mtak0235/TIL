#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
int main() {
    vector<int> targets(5);
    for (int i = 0; i < 5; i++) cin >> targets[i];
    sort(targets.begin(), targets.end());
    int sum = 0;
    for (vector<int>::iterator iter = targets.begin(); iter != targets.end(); iter++) sum += *iter;
    cout << sum / targets.size() <<"\n" << targets[targets.size() / 2];

}