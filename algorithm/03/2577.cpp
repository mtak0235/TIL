#include <iostream>
#include <string>
using namespace std;
int main() {
    int x,y,z;
    cin >> x >> y >>z;
    int sets[10] = {};
    for (char c : to_string(x * y * z)) sets[c - '0'] += 1;
    for (int i : sets) cout << i << "\n";
}