#include <iostream>
#include <vector>
#include <iomanip>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int N;
    cin >> N;

    vector<int> grade(N);
    int maxValue = 0;
    double sum = 0;

    for(int i=0;i<N;i++) {
        cin >> grade[i];
        if(grade[i] > maxValue) {
            maxValue = grade[i];
        }
        sum += grade[i];
    }

    double avarage = (sum/maxValue)*100/N;
    cout << fixed << setprecision(6) << avarage << "\n";
    return 0;
}