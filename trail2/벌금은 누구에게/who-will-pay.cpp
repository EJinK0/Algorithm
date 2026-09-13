#include <iostream>
#include <vector>

using namespace std;

int N, M, K;

int main() {
    cin >> N >> M >> K;
    vector<int> count(N+1,0);

    for (int i = 0; i < M; i++) {
        int student;
        cin >> student;

        count[student]++;

        if(count[student] == K) {
            cout << student;
            return 0;
        }
    }

    cout << -1;

    // Please write your code here.

    return 0;
}