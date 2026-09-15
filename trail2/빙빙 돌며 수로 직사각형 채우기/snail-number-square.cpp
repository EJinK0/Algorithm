#include <iostream>
#include <vector>

using namespace std;

int n, m;

int main() {
    cin >> n >> m;

    vector<vector<int>> board(n, vector<int>(m,0));

    // 우 하 좌 상
    int dr[4] = {0,1,0,-1};
    int dc[4] = {1,0,-1,0};

    int r=0;
    int c=0;
    int dir=0;

    board[r][c] = 1;

    for(int num=2 ; num<=n*m ; num++) {
        int nr = r+dr[dir];
        int nc = c+dc[dir];

        if(nr < 0 || nr >= n || nc < 0 || nc >= m || board[nr][nc] != 0) {
            dir=(dir+1)%4;
            nr=r+dr[dir];
            nc=c+dc[dir];
        }

        r=nr;
        c=nc;

        board[r][c] = num;
    }

    for(int i=0;i<n;i++) {
        for(int j=0;j<m;j++) {
            cout << board[i][j] << " ";
        }

        cout << "\n";
    }

    // Please write your code here.

    return 0;
}