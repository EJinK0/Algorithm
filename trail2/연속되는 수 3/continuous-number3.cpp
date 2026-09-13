#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int N;

int main() {
    cin >> N;

    vector<int> A(N);

    for (int i = 0; i < N; i++) {
        cin >> A[i];
    }
    int count = 1;
    int answer = 1;
    for(int i=1;i<N;i++) {
        bool sameSign=(A[i]>0 && A[i-1] > 0)||(A[i]<0 && A[i-1]<0);
        if(sameSign) {
            count++;
        } else {
            count = 1;
        }

        answer=max(answer, count);
    }

    cout << answer;

    // Please write your code here.

    return 0;
}