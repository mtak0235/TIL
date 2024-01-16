#include <iostream>
#include <string>
int main() {
    int grade;
    std::cin >> grade;
    if (90 <= grade && grade <= 100) std::cout << 'A';
    else if (80 <= grade && grade <= 89) std::cout << 'B';
    else if (70 <= grade && grade <= 79) std::cout <<'C';
    else if (60 <= grade && grade <= 69) std::cout << 'D';
    else std::cout << 'F';
}