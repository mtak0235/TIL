#include <iostream>
int main() {
    int x[3];
    std::cin >> x[0] >> x[1] >> x[2];
    for (int i = 2; i > 0;i--) {
        for (int j = 0; j < i; j++) {
            if (x[j] > x[j + 1]) {
                int tmp = x[j];
                x[j] = x[j + 1];
                x[j + 1] = tmp;
            }
        }
    }
    for (int i = 0; i < 3; i++) std::cout << x[i] << " ";

}