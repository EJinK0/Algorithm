#include <iostream>
#include <vector>
#include <string>

using namespace std;

int n;

int main() {
    cin >> n;
    vector<string> board(n);
    for(int i=0;i<n;i++) {
        cin >> board[i];
    }

    // k는 들어오는 입구 특정숫자
    int k;
    cin >> k;

    // 상 우 하 좌
    int dr[4] = {-1,0,1,0};
    int dc[4] = {0,1,0,-1};

    int r,c,dir;

    // 위에서 들어올때
    if(k <= n) {
        r=0;
        c=k-1;
        dir=2;
    } else if(k <= 2*n) { // 오른쪽에서 좌로 들어올때
        r=k-n-1;
        c=n-1;
        dir=3;
    } else if(k <= 3*n) { // 아래에서 위로 들어올때
        r=n-1;
        c=3*n-k;
        dir=0;
    } else { // 왼쪽에서 우로 들어올때
        r=4*n-k;
        c=0;
        dir=1;
    }

    int count=0;

    while(r>=0&&r<n&&c>=0&&c<n) {
        count++;

        if(board[r][c] == '/') {
            if(dir==0) dir=1;
            else if(dir == 1) dir=0;
            else if(dir == 2) dir=3;
            else dir=2;
        } else {// '\'
            if(dir==0) dir=3;
            else if(dir==1) dir=2;
            else if(dir==2) dir=1;
            else dir=0; 
        }

        r += dr[dir];
        c += dc[dir];
    }

    cout << count;

    // Please write your code here.

    return 0;
}