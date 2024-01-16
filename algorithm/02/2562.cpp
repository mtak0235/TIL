#include <iostream>
#include <string>
using namespace std;
int main() {
    int max;
    int maxIdx = 0;
    cin >> max;
    for (int i = 1; i < 9; i++) {
        int got;
        cin >> got;
        if (max < got) {
            max = got;
            maxIdx = i;
        }
    }
    cout << max << "\n"<<maxIdx + 1;
}