#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int n;

int main() {
    cin >> n;
    vector<int> point(101,0);

    for (int i = 0; i < n; i++) {
        int a,b;
        cin >> a >> b;

        for(int i=a;i<=b;i++) {
            point[i]++;
        }
    }

    int answer = 0;
    for(int i=0;i<=100;i++) {
        answer = max(answer, point[i]);
    }

    cout << answer;

    return 0;
}