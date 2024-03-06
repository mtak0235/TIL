#include <bits/stdc++.h>
using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	int testCase;
	
	cin >> testCase;

	while (testCase--) {
		list<char> l;
		string given;
		cin >> given;
		list<char>::iterator iter = l.begin();
		for (char c: given) {
			if (c == '-') 
				iter = l.erase(iter);
			else if (c=='<') {
				if (iter != l.begin())
					iter--;
			} else if (c=='>') {
				if (iter != l.end())
					iter++;
			} else {
				l.insert(iter,c);
			}
			for (list<char>::iterator i = l.begin(); i != l.end(); i++)
				cout << *i;
			cout << "\n";
		}
		for (list<char>::iterator i = l.begin(); i != l.end(); i++)
			cout << *i;
		cout << "\n";
	}
}