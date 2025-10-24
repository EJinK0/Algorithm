#include <iostream>
#include <sstream>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    string L, R;
    cin >> L >> R;
    if(L.size() != R.size()) {
        cout << 0;
        return 0;
    }

    int cnt = 0;
    for(int i=0;i<L.size();i++) {
        char a = L[i];
        char b = R[i];
        if(a != b) break;
        if(a == '8') cnt++;
    }

    cout << cnt;
    return 0;
}