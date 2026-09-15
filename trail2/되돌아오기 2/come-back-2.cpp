#include <iostream>
#include <string>

using namespace std;

string commands;

int main() {
    cin >> commands;
    
    // 상우하좌
    int dx[4] = {0,1,0,-1};
    int dy[4] = {1,0,-1,0};

    int x=0,y=0;
    int dir=0;
    int dist;

    int time=0;
    
    for(char cmd: commands) {
        if(cmd == 'R') {
            dir = (dir+1)%4;
        } else if (cmd == 'L') {
            dir = (dir+3)%4;
        } else if(cmd=='F') {
            x += dx[dir];
            y += dy[dir];
        }

        time++;

        if(x==0&&y==0) {
            cout << time;
            return 0;
        }
    }

    cout << "-1";
    // Please write your code here.

    return 0;
}