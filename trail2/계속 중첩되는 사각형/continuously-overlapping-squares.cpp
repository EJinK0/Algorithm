#include <iostream>
#include <vector>

using namespace std;

int n;

int main() {
    cin >> n;
    const int OFFSET = 100;

    vector<vector<int>> board(201, vector<int>(201,0));
    for (int i = 0; i < n; i++) {
        int x1,y1,x2,y2;
        cin >> x1 >> y1 >> x2 >> y2;

        int color;

        if(i%2==0) {
            color = 1;
        } else {
            color = 2;
        }

        for(int x=x1;x<x2;x++) {
            for(int y=y1;y<y2;y++) {
                board[x+OFFSET][y+OFFSET] = color;
            }
        }
    }

    int answer=0;

    for(int x=0;x<200;x++) {
        for(int y=0;y<200;y++) {
            if(board[x][y] == 2) {
                answer++;
            }
        }
    }

    cout << answer;

    // Please write your code here.

    return 0;
}