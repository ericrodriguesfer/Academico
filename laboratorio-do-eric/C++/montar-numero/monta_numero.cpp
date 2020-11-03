#include <iostream>

using namespace std;

int main () {
    int n = 0;
    int d = 0;
    int t = 0;

    cin >> t;

    while (t-- > 0) {
        cin >> d;
        n = (n * 10) + d;
    }

    cout << n << endl;

}
