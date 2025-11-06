#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>
#include <climits>
#include <unordered_set>
using namespace std;

int R, C;
vector<string> g;

bool ok(int cut) {
    unordered_set<string> seen;
    seen.reserve(C*2);
    string col;
    col.reserve(R-cut);

    for(int c=0;c<C;++c) {
        col.clear();
        for(int r=cut;r<R;++r) {
            col.push_back(g[r][c]);
        }

        auto res = seen.insert(col);
        if(!res.second) return false;
    }

    return true;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    
    cin >> R >> C;
    g.resize(R);

    for(int i=0;i<R;i++) {
        cin >> g[i];
    }

    int lo = 0;
    int hi = R-1;
    int ans = 0;
    while(lo <= hi) {
        int mid = (lo+hi) >> 1;
        if(ok(mid)) {
            ans=mid;
            lo = mid+1;
        } else {
            hi = mid-1;
        }
    }

    cout << ans;
    return 0;
}