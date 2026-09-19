#include <iostream>
#include <string>
#include <vector>

using namespace std;

int N, T;
string commands;

int main() {
    cin >> N >> T;
    cin >> commands;

    vector<vector<int>> board(N,vector<int>(N));

    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            cin >> board[i][j];
        }
    }


    // 상우하좌
    int dr[4] = {-1,0,1,0};
    int dc[4] = {0,1,0,-1};

    int r=N/2;
    int c=N/2;

    int dir=0;
    int sum=board[r][c];
    // Please write your code here.

     for (char cmd : commands) {

        if (cmd == 'L') {
            dir = (dir + 3) % 4;
        }
        else if (cmd == 'R') {
            dir = (dir + 1) % 4;
        }
        else if (cmd == 'F') {
            int nr = r + dr[dir];
            int nc = c + dc[dir];

            // 격자 안이라면 이동
            if (nr >= 0 && nr < N &&
                nc >= 0 && nc < N) {

                r = nr;
                c = nc;

                sum += board[r][c];
            }
        }
    }

    cout<< sum;

    return 0;
}