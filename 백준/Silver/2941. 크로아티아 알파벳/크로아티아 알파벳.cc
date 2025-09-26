#include <iostream>
#include <string>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    string alpabet;
    cin >> alpabet;

    string croatia[8] = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
    for(string c : croatia) {
        size_t pos = 0;

        while((pos = alpabet.find(c, pos)) != string::npos) {
            alpabet.replace(pos, c.length(), "*");
        }
    }

    cout << alpabet.length() << "\n";
    return 0;
}