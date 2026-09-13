#include <iostream>
#include <vector>

using namespace std;

int N;

int main() {
    cin >> N;
    vector<int> br(N);
    for (int i = 0; i < N; i++) {
        cin >> br[i];
    }

    int count = 1;
    int answer= 1;
    for(int i=1;i<N;i++) {
        if(br[i] == br[i-1]) {
            count++;
        } else {
            count=1;
        }

        answer = max(answer, count);
    }

    cout << answer;
    

    // Please write your code here.

    return 0;
}