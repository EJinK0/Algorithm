#include <iostream>
#include <vector>

using namespace std;

int N, M;

int main() {
    cin >> N >> M;
    vector<vector<int>> board(N, vector<int>(N, 0));

    // 상 우 하 좌
    int dr[4] = {-1,0,1,0};
    int dc[4] = {0,1,0,-1};

    for (int i = 0; i < M; i++) {
        int r,c;
        cin >> r >> c;

        r--;
        c--;

        board[r][c] = 1;
        int count = 0;

        for(int d=0;d<4;d++) {
            int nr = r+dr[d];
            int nc = c+dc[d];

            if(nr>=0&&nr<N&&nc>=0&&nc<N) {
                if(board[nr][nc] == 1) {
                    count++;
                }
            }
        }

        if(count == 3) {
            cout << 1 << "\n";
        } else {
            cout << 0 << "\n";
        }
    }

    // Please write your code here.

    return 0;
}