#include <iostream>
#include <vector>

using namespace std;

int N, M;

int main() {
    cin >> N >> M;

    vector<int> A;
    vector<int> B;

    int pos=0;

    for (int i = 0; i < N; i++) {
        int v,t;
        cin >> v >> t;
        for(int j=0;j<t;j++) {
            pos += v;
            A.push_back(pos);
        }
    }

    pos = 0;

    for (int i = 0; i < M; i++) {
        int v,t;
        cin >> v >> t;
        for(int j=0;j<t;j++) {
            pos += v;
            B.push_back(pos);
        }
    }

    int answer=0;
    int prevLeader=0;
    for(int i=0;i<A.size();i++) {
        int currentLeader;
        if(A[i] > B[i]) {
            currentLeader=1;
        } else if(A[i] < B[i]) {
            currentLeader=2;
        } else {
            currentLeader=3;
        }

        if(currentLeader != prevLeader) {
            answer++;
            prevLeader = currentLeader;
        }
    }

    cout << answer;

    // Please write your code here.

    return 0;
}