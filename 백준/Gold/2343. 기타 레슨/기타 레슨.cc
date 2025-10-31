#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>
#include <climits>
using namespace std;

vector<int> a;
int M;

bool canFit(int mid) {
    int disks = 1;
    int cur = 0;
    for(int x: a) {
        if(cur+x <=  mid) {
            cur+=x;
        } else {
            disks++;
            cur = x;
        }
        
    }
    return disks <= M;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    
    int N;
    cin >> N >> M;
    a.resize(N);
    
    long long lo = 0;
    long long hi = 0;      
    for(int i=0;i<N;i++) {
        cin >> a[i];
        if(a[i] > lo) lo = a[i];
        hi += a[i]; 
    }

    long ans = hi;
    
    while(lo <= hi) {
        long long mid = lo + (hi-lo)/2;

        if(canFit(mid)) {
            ans=mid;
            hi=mid-1;
        } else {
            lo = mid+1;
        }

    }

    cout << ans;
    return 0;
}