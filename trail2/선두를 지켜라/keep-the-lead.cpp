#include <iostream>
#include <vector>

using namespace std;

int N, M;

int main() {
    cin >> N >> M;
    vector<int> A;
    vector<int> B;

    int pos=0;

    for (int i = 0; i < N; i++){
        int v,t;
        cin >> v >> t;

        for(int i=0;i<t;i++) {
            pos += v;
            A.push_back(pos);
        }
    }

    pos = 0;

    for (int i = 0; i < M; i++){
        int v,t;
        cin >> v >> t;
        
        for(int i=0;i<t;i++) {
            pos += v;
            B.push_back(pos);
        }
    }

    int answer = 0;
    int leader=0;

    for(int i=0;i<A.size();i++) {
        int currentReader=1;

        if(A[i] > B[i]) {
            currentReader=1;
        } else if(A[i] < B[i]) {
            currentReader=2;
        } else {
            currentReader=0;
        }

        if(currentReader != 0) {
            if(leader !=0 && leader != currentReader) {
                answer++;
            }

            leader = currentReader;
        }
    }

    cout<<answer;

    return 0;
}