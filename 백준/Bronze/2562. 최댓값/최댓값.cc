#include <iostream>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int maxValue = 0;
    int maxIndex = 0;

    for(int i=0;i<9;i++) {
        int number;
        cin >> number;
        if(number > maxValue) {
            maxValue = number;
            maxIndex = i+1;
        }
    }

    cout << maxValue << "\n";
    cout << maxIndex << "\n";

    return 0;
}