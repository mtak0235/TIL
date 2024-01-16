#include <iostream>
int main() {
    int x, y, z;
    std::cin >> x >> y >> z; 
    if (x == y && x == z && y == z) std::cout << 10000 + x * 1000;
    else if (x != y && x != z && y != z) {
        int max;
        if (x > y && x > z) max = x;
        else if (y > x && y > z) max = y;
        else max = z;
        std::cout << max *100;
    } else {
        int dup;
        if (y == z) dup = y;
        else if (x == y) dup = x;
        else dup = z;
        std::cout << 1000 + 100 * dup;
    }
}