#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int n;

int main() {
    cin >> n;
    vector<pair<int, int>> line(n);
    for (int i = 0; i < n; i++) {
        cin >> line[i].first >> line[i].second;
    }

    int answer = 0;
    for(int x = -100 ; x<100; x++) {
        int count=0;
        for(int i=0;i<n;i++) {
            int left = line[i].first;
            int right = line[i].second;

            if(left<=x && x<right) {
                count++;
            }
        }

        answer = max(answer, count);
    }

    cout << answer;

    return 0;
}