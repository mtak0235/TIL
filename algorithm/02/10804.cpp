#include <iostream>
#include <vector>
using namespace std;

int main() {
    int arr[21];
    for (int i = 0; i < 21; i++) arr[i] = i;
    for (int i = 0; i < 10; i++) {
        int from, to;
        cin >> from >> to;
        for (int start = from ; start <= (from + to) / 2; start++) {
            swap(arr[start], arr[to - (start - from)]);
        }
    }
    for (int i = 1; i < 21; i++) cout << arr[i] << " ";
}