#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int N;
    long long M;
    cin >> N >> M;

    vector<long long> A(N);
    long long hi = 0;
    for (int i = 0; i < N; i++)
    {
        cin >> A[i];
        if (A[i] > hi)
            hi = A[i];
    }

    long long lo = 0, ans = 0;
    while (lo <= hi)
    {
        long long mid = (lo + hi) >> 1; // (lo+hi) / 2
        long long got = 0;
        for (int i = 0; i < N; i++)
        {
            if (A[i] > mid)
                got += (A[i] - mid);
        }

        if (got >= M)
        {
            ans = mid;
            lo = mid + 1;
        }
        else
        {
            hi = mid - 1;
        }
    }

    cout << ans;
}