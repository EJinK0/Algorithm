#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int N, K;
int A[100], B[100];

int main() {
    cin >> N >> K;

    vector<int> blocks(N+1, 0);

    for (int i = 0; i < K; i++) {
        int a, b;
        cin >> a >> b;
        for (int j = a; j <= b; j++) {
            blocks[j]++;
        }
    }

    int answer = 0;
    for(int i=1 ; i <= N ; i++) {
        answer = max(answer, blocks[i]);
    }

    cout << answer;

    return 0;
}