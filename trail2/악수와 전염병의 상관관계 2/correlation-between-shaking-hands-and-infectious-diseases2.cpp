#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int N, K, P, T;


// 악수한 시간 t
// 악수한 사람1 x
// 악수한 사람2 y
struct Handshake {
    int t;
    int x;
    int y;
};

// 사람 N명
// 감염되면 앞으로 딱 K번의 악수 동안만 전염 가능
// 처음 감염자는 P번 사람
// 악수 기록 T개

int main() {
    int N,K,P,T;
    cin >> N >> K >> P >> T;
    vector<Handshake> logs(T);

    for (int i = 0; i < T; i++) {
        cin >> logs[i].t >> logs[i].x >> logs[i].y;
    }

    sort(logs.begin(), logs.end(), [](const Handshake& a, const Handshake& b){
        return a.t < b.t;
    });

    vector<bool> infected(N+1, false);
    vector<int> remain(N+1, 0);

    infected[P] = true;
    remain[P] = K;

    for(int i=0;i<T;i++) {
        int x = logs[i].x;
        int y = logs[i].y;

        bool xCanSpread = infected[x] && remain[x] > 0;
        bool yCanSpread = infected[y] && remain[y] > 0;

        if(xCanSpread && !infected[y]) {
            infected[y] = true;
            remain[y] = K;
        }

        if(yCanSpread && !infected[x]) {
            infected[x] = true;
            remain[x] = K;
        }

        if(xCanSpread) {
            remain[x]--;
        }

        if(yCanSpread) {
            remain[y]--;
        }
    }

    for(int i=1;i<=N;i++) {
        cout << infected[i];
    }

    return 0;
}