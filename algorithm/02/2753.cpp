#include <iostream>
int main() {
    int n;
    std::cin >> n;
    if ((n % 4 == 0 && n % 100 != 0) || n % 400 == 0) std::cout << 1;
    else std::cout << 0;
}