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
    
    long long x;
    int n;

    while((cin >> x)) {
        long long target = x * 10000000LL; // cm->nm
        if(!(cin>>n)) break;
        vector<int> a(n);
        for(int i=0;i<n;i++) {
            cin >> a[i];
        }
        sort(a.begin(), a.end());

        int l=0;
        int r=n-1;
        bool found = false;

        while(l<r) {
            long long sum = (long long)a[l] + a[r];
            if(sum == target) {
                cout << "yes " << a[l] << " " << a[r] << '\n';
                found = true;
                break;
            } else if(sum < target) {
                ++l;
            } else {
                --r;
            }
        }

        if(!found) cout << "danger\n";
    }
    
    return 0;
}