#include <iostream>
#include <vector>

using namespace std;

int n;

int main() {
    cin >> n;
    vector<int> visited(2001, 0);

    int pos = 0;

    for (int i = 0; i < n; i++) {
        int x;
        char dir;
        cin >> x >> dir;

        if(dir == 'R') {
            for(int j=pos;j<pos+x;j++) {
                visited[j+1000]++;
            }
            pos += x;
        } else {
            for(int k=pos-1;k>=pos-x;k--) {
                visited[k+1000]++;
            }

            pos -= x;
        }
    }

    int answer = 0;

    for(int i=0;i<2000;i++) {
        if(visited[i] >= 2) {
            answer++;
        }
    }

    cout << answer;

    // Please write your code here.

    return 0;
}