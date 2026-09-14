#include <iostream>
#include <vector>

using namespace std;

int n;

int main() {
    cin >> n;

    vector<vector<int>> board(n, vector<int>(n));

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            cin >> board[i][j];
        }
    }

    // 상우하좌 - 좌표기준
    //int dx[4] = {0,1,0,-1};
    //int dy[4] = {1,0,-1,0};

    // 상우하좌 - 배열(행/열)기준
    int dx[4] = {-1,0,1,0};
    int dy[4] = {0,1,0,-1};

    int answer=0;

    for(int i=0;i<n;i++) {
        for(int j=0;j<n;j++) {
            int count=0;

            for(int d=0;d<4;d++) {
                int nx = i+dx[d];
                int ny = j+dy[d];

                if(nx>=0 && nx< n && ny>=0&&ny<n) {
                    if(board[nx][ny] == 1) {
                        count++;
                    }
                }
            }

            if(count >=3) {
                answer++;
            }
        }
    }

    cout << answer;

    return 0;
}