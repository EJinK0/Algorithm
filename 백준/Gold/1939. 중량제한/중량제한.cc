#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>
#include <queue>
using namespace std;

struct Edge {
    int to;
    int w;
};

int N,M;
vector<vector<Edge>> g;
int startNode, endNode;
int maxW=0;

bool canCarry(int weight) {
    vector<bool> vis(N+1, false);
    queue<int> q;
    vis[startNode] = true;
    q.push(startNode);

    while(!q.empty()) {
        int u = q.front();
        q.pop();
        if(u == endNode) return true;
        for(auto &e: g[u]) {
            if(!vis[e.to] && e.w >= weight) {
                vis[e.to] = true;
                q.push(e.to);
            }
        }
    }

    return false;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> N >> M;
    g.resize(N+1);

    vector<int> S(M);
    for (int i = 0; i < M; i++){
        int a,b,w;
        cin >> a >> b >> w;
        g[a].push_back({b,w});
        g[b].push_back({a,w});
        maxW = max(maxW, w);
    }
    cin >> startNode >> endNode;

    int lo = 1;
    int hi = maxW;
    int ans = 0;
    while(lo <= hi) {
        int mid = lo + (hi-lo)/2;
        if(canCarry(mid)) {
            ans = mid;
            lo = mid+1;
        } else {
            hi = mid-1;
        }
    }

    cout << ans << "\n";
    return 0;
}