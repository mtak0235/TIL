#include <iostream>
#include <cmath>
using namespace std;

int f(int n){
    int ret = 0;
    for (int i = 0; i < n; i++){
        if (i % 3 == 0 || i % 5 == 0) ret += i;
    }
    return ret;
}

int ff(int arr[], int n) {
    for (int i = 0; i < n - 1; i++) {
        for (int j = i + 1; j < n; j++) {
            if (arr[i] + arr[j] == 100) return 1;
        }
    }
    return 0;
}

int fff(int n) {
    for (int i = 1; i * i <= n; i++) if (i*i == n) return 1;
    return 0;
} // O(root N)
int ffff(int n) {
    int v = 1;
    while (2 * v <= n) v *= 2;
    return v;
} //O(logN)

int main() {
    int arr[] = {50, 42};
    std::cout << f(34567) << "\n" << ff(arr, 2) << "\n" <<fff(9) << std::endl;
    std::cout << ffff(5)<< std::endl;
}