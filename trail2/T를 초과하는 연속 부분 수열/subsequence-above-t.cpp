#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int n, t;

int main() {
    cin >> n >> t;
    vector<int> A(n);
    for (int i = 0; i < n; i++) {
        cin >> A[i];
    }

    int count=0;
    int answer = 0;
    for(int i=0;i<n;i++) {
        if(A[i] > t) {
            count++;
        } else {
            count = 0;
        }

        answer = max(answer, count);
    }
    cout << answer;

    // Please write your code here.

    return 0;
}