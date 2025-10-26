#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int M, N; // M: 조카 수, N: 과자 개수
    cin >> M >> N;

    vector<long long> A(N);
    long long hi = 0;

    for (int i = 0; i < N; i++) {
        cin >> A[i];
        hi = max(hi, A[i]);
    }

    long long lo = 1;
    long long ans = 0;

    while (lo <= hi) {
        long long mid = lo + (hi - lo) / 2; // 후보 과자 길이
        long long pieces = 0;

        for (int i = 0; i < N; i++) {
            pieces += A[i] / mid;
            if (pieces >= M) break; // 충분히 나눌 수 있으면 조기 종료
        }

        if (pieces >= M) { // 배분 가능 → 길이 늘려보기
            ans = mid;
            lo = mid + 1;
        } else {           // 불가능 → 길이 줄이기
            hi = mid - 1;
        }
    }

    cout << ans << '\n';
    return 0;
}