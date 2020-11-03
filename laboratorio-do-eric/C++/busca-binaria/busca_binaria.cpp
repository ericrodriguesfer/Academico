#include <iostream>
#include <clocale>

using namespace std;

bool busca_binaria (int *v, unsigned int t, int b) {
    int i = 0;
    int f = (t - 1);
    int m;

    while (i <= f) {
        m = (i + f) / 2;

        if (v[m] == b)
            return true;

        if (b < v[m])
            f = (m - 1);
        else
            i = (m + 1);
    }

    return false;
}

int main () {
    setlocale(LC_ALL, "Portuguese");

    unsigned int t = 10;
    int *v = new int[t];

    for (unsigned int i = 0; i < t; i++)
        v[i] = (i + 1);

    for (unsigned int i = 0; i < t; i++)
        cout << v[i] << " ";
    cout << endl;

    cout << (busca_binaria(v, t, 11) == true ? "Achou" : "Não achou") << endl;

}

