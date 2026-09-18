#include <iostream>
#include <vector>

using namespace std;

int n;

int main() {
    cin >> n;
    vector<vector<int>> board(n, vector<int>(n,0));

    // 우 상 좌 하
    int dr[4] = {0,-1,0,1};
    int dc[4] = {1,0,-1,0};

    int r=0;
    int c=0;
    int dir=0;
    int num = 1;

    r = (n/2);
    c = (n/2);

    board[r][c] = num;

    int len = 1;
    while(num < n*n) {
        for(int repeat = 0;repeat<2;repeat++) {
            for(int step=0;step<len;step++) {
                r+=dr[dir];
                c+=dc[dir];

                num++;

                if(r>=0||r<n||c>=0||c<n) {
                    board[r][c] = num;
                }

                if(num == n*n) break;
            }

            dir = (dir+1)%4;

            if(num == n*n) {
                break;
            }
        }

        len++;
    }

    for(int i=0;i<n;i++) {
        for(int j=0;j<n;j++) {
            cout << board[i][j] << " ";
        }

        cout << "\n";
    }

    // Please write your code here.

    return 0;
}
