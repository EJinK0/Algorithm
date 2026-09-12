#include <iostream>
#include <vector>

using namespace std;

int N;

int main() {
    cin >> N;

    const int OFFSET = 100;

    vector<vector<bool>> board(201, vector<bool>(201, false));

    for (int i = 0; i < N; i++) {
        int x1, y1, x2, y2;
        
        cin >> x1 >> y1 >> x2 >> y2;

        for(int x=x1;x<x2;x++) {
            for(int y=y1;y<y2;y++) {
                board[x+OFFSET][y+OFFSET] = true;
            }
        }
    }

    int answer = 0;

    for(int i=0;i<200;i++) {
        for(int y=0;y<200;y++) {
            if(board[i][y]) {
                answer++;
            }
        }
    }

    cout << answer;

    // Please write your code here.

    return 0;
}