#include <iostream>
#include <string>

using namespace std;

string dirs;

int main() {
    cin >> dirs;

    int x=0;
    int y=0;
    int dir=0;

    // 상우하좌~?
    int dx[4] = {0,1,0,-1};
    int dy[4] = {1,0,-1,0};
    
    for(char cmd: dirs) {
        if(cmd=='L') {
            dir = (dir+3)%4;
        } else if(cmd=='R') {
            dir = (dir+1)%4;
        } else if(cmd=='F'){
            x+=dx[dir];
            y+=dy[dir];
        }
    }

    cout << x << " " << y;

    return 0;
}