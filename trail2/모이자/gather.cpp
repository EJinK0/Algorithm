#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int n;

int main() {
    cin >> n;
    vector<int> people(n);

    for (int i = 0; i < n; i++) {
        cin >> people[i];
    }

    int answer = 1e9;

    for (int meeting = 0; meeting < n; meeting++) {
        int sum = 0;
        for (int house = 0; house < n; house++) {
            int dist = abs(meeting - house);
            sum += people[house]*dist;
        }

        answer = min(answer, sum);
    }

    cout << answer;

    // Please write your code here.

    return 0;
}