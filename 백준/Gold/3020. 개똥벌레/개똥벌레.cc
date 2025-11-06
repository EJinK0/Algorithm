#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>
#include <climits>
using namespace std;

int N, H;
vector<int> bot;
vector<int> top;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    
    cin >> N >> H;
    bot.resize(H+2,0);
    top.resize(H+2,0);
    
    for(int i=0;i<N;i++) {
        int x;
        cin >> x;
        if((i & 1)==0) bot[x]++;
        else top[x]++;
    }
    
    for(int h=H-1;h>=1;h--) {
        bot[h] += bot[h+1];
        top[h] += top[h+1];
    }

    int minCrash = INT_MAX;
    int cntHeights = 0;
    for(int h=1;h<=H;h++) {
        int crashBot=bot[h];
        int crashTop=top[H-h+1];
        int crash = crashBot+crashTop;
        if(crash<minCrash) {
            minCrash = crash;
            cntHeights=1;
        } else if(crash == minCrash){
            cntHeights++;
        }
    }

    cout << minCrash << " " << cntHeights;
    return 0;
}