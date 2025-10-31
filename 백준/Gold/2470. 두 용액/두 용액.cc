#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>
#include <climits>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    
    int N;
    cin >> N;

    vector<int> a(N);      
    for(int i=0;i<N;i++) {
        cin >> a[i];
    }

    sort(a.begin(), a.end());

    int l = 0;
    int r = N-1;
    long long bestAbs = LLONG_MAX;
    int ansL = a[l];
    int ansR = a[r];
    
    while(l < r) {
        long long sum = (long long)a[l] + a[r];
        long long abs = llabs(sum);

        if(abs < bestAbs) {
            bestAbs = abs;
            ansL = a[l];
            ansR = a[r];
            if(bestAbs == 0) break;
        }

        if(sum < 0) l++;
        else r--;
    }

    cout << ansL << " " << ansR;
    return 0;
}