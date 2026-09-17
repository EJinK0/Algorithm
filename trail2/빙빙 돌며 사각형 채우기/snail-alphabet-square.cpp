#include <iostream>
#include <vector>

using namespace std;

int n, m;

int main() {
    cin >> n >> m;

    vector<vector<char>> board(n,vector<char>(m, ' '));

    // 우 하 좌 상
    int dr[4] = {0,1,0,-1};
    int dc[4] = {1,0,-1,0};

    int r=0;
    int c=0;
    int dir=0;

    char ch='A';

    board[r][c] = ch;

    for(int cnt=2;cnt<=n*m;cnt++) {
        int nr = r+dr[dir];
        int nc = c+dc[dir];

        if(nr<0 || nr >= n || nc < 0 || nc>=m || board[nr][nc] != ' ') {
            dir = (dir+1)%4;

            nr = r+dr[dir];
            nc = c+dc[dir];
        }

        r=nr;
        c=nc;

        ch++;
        if(ch > 'Z') {
            ch = 'A';
        }

        board[r][c] = ch;
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
