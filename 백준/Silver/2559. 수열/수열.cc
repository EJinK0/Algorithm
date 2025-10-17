#include <iostream>
#include <vector>
#include <sstream>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int N, K;
    cin >> N >> K;

    vector<int> a(N);

    for(int i=0;i<N;i++) {
        cin >> a[i];
    }

    int sum = 0;
    for(int i=0;i<K;i++) {
        sum += a[i];
    }
    int maxSum = sum;

    for(int i=K;i<N;i++) {
        sum += a[i] - a[i-K];
        if(sum > maxSum) maxSum = sum;
    }

    cout << maxSum << '\n';
    return 0;
}