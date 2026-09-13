#include <iostream>
#include <vector>

using namespace std;

int n, m;

int main() {
    cin >> n >> m;

    vector<int> A;
    vector<int> B;

    int pos=0;

    for (int i = 0; i < n; i++) {
        char dir;
        int t;
        cin >> dir >> t;

        for(int j=0;j<t;j++) {
            if(dir == 'R') {
                pos++;
            } else {
                pos--;
            }

            A.push_back(pos);
        }
    }

    pos=0;

    for(int i=0;i<m;i++){
        char dir;
        int t;
        cin >> dir >> t;

        for(int j=0;j<t;j++) {
            if(dir=='R') {
                pos++;
            } else {
                pos--;
            }

            B.push_back(pos);
        }
    }
    
    int answer = -1;
    for(int i=0;i<A.size();i++) {
        if(A[i] == B[i]) {
            answer = i+1;
            break;
        }
    }

    cout << answer;

    return 0;
}