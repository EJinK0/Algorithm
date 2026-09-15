#include <iostream>

using namespace std;

int N;
char dir[100];
int dist[100];

int main() {
    cin >> N;

    // 서 남 북 동
    // W S N E
    // 좌 하 상 우

    // 상우하좌
    int dx[4] = {0,1,0,-1};
    int dy[4] = {1,0,-1,0};

    int x = 0, y = 0;
    int time=0;

    for (int i = 0; i < N; i++) {
        char d;
        int dist;
        int dir;
        cin >> d >> dist;

        if(d == 'N') dir=0;
        else if(d == 'E') dir=1;
        else if(d=='S') dir=2;
        else dir=3;

        for(int j=0;j<dist;j++) {
            x+=dx[dir];
            y+=dy[dir];
            time++;

            if(x==0&&y==0) {
                cout<<time;
                return 0;
            }
        }
    }

    cout << -1;

    // Please write your code here.

    return 0;
}