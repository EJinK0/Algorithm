#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int n, m;

int main() {
    cin >> n >> m;

    vector<int> A;
    vector<int> B;

    int pos=0;

    for (int i = 0; i < n; i++) {
        int t;
        char d;
        cin >> t >> d;

        for(int j=0;j<t;j++) {
            if(d=='R') {
                pos++;
            } else {
                pos--;
            }

            A.push_back(pos);
        }
    }

    pos=0;

    for (int i = 0; i < m; i++) {
        int t;
        char d;
        cin >> t >> d;
        for(int j=0;j<t;j++) {
            if(d=='R') {
                pos++;
            } else {
                pos--;
            }

            B.push_back(pos);
        }
    }

    int totalTime = max(A.size(), B.size());

    while(A.size()<totalTime) {
        A.push_back(A.back());
    }

    while(B.size()<totalTime) {
        B.push_back(B.back());
    }

    int answer = 0;
    int prevA=0;
    int prevB=0;

    for(int i=0;i<totalTime;i++) {
        if(prevA != prevB && A[i] == B[i]) {
            answer++;
        }

        prevA = A[i];
        prevB = B[i];
    }

    cout<<answer;

    // Please write your code here.

    return 0;
}