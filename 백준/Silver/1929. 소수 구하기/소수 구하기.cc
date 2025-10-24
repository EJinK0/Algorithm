#include <iostream>
#include <vector>
#include <sstream>
#include <cmath>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int M, N;
    cin >> M >> N;
    vector<bool> isComposite(N+1, false);
    
    if(N >= 0) isComposite[0] = true;
    if(N >= 1) isComposite[1] = true;

    int limit = static_cast<int>(sqrt(N));
    for(int p=2;p<=limit;p++) {
        if(!isComposite[p]) {
            long long start = static_cast<long long>(p*p);
            for(long long m = start;m<=N;m+=p) {
                isComposite[m] = true;
            }
        }
    }

    for(int i=max(2,M);i<=N;i++) {
        if(!isComposite[i]) {
            cout << i << "\n";
        }
    }

    return 0;
}