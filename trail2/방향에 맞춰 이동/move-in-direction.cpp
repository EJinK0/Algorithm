#include <iostream>

using namespace std;

int n;

int main() {
    cin >> n;
    int x =0,y=0;
    char dirs[4] = {'N', 'E', 'S', 'W'};
    int dx[4] = {0,1,0,-1};
    int dy[4] = {1,0,-1,0};

    for (int i = 0; i < n; i++) {
        char dir;
        int dist;
        cin >> dir >> dist;

        int idx=0;

        for(int j=0;j<4;j++) {
            if(dirs[j] == dir) {
                idx = j;
                break;
            }
        }

        x += dx[idx] * dist;
        y += dy[idx] * dist;
    }

    cout << x << " " << y; 

    return 0;
}