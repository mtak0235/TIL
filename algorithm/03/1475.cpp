#include <iostream>
#include <string>
using namespace std;

int main() {
    int n; 
    cin >> n;
    int sets[10] = {};
    for (char c : to_string(n)) sets[c - '0'] += 1;
    int max = 0;
    for (int i  = 0; i < 10; i++) {
        if (i != 6 && i != 9)
            max = (sets[i] > max) ? sets[i] : max;
    }
    int tmp = sets[6] + sets[9];
    cout << ((max > (tmp / 2 + (tmp % 2)))? max : (tmp / 2 + (tmp % 2)));

}