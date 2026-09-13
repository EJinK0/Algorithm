#include <iostream>
#include <vector>

using namespace std;

int N;

int main() {
    cin >> N;

    const int OFFSET = 100;

    vector<vector<bool>> board(200, vector<bool>(200, false));

    for(int k=0;k<N;k++) {
        int x,y;
        cin >> x >> y;

        for (int i = x; i < x+8; i++) {
            for(int j=y; j< y+8;j++) {
                board[i+OFFSET][j+OFFSET] = true;
            }
        }
    }

    int answer = 0;

    for(int i=0;i<200;i++) {
       for(int j=0;j<200;j++) {
        if(board[i][j] == true) {
            answer++;
        }
       } 
    }

    cout << answer;

    return 0;
}