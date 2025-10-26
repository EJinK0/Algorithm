#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

static int N, C;
static vector<int> house;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int N, M;
    cin >> N >> M;

    vector<long long> T(N);
    long long maxT = 0;
    for (int i = 0; i < N; i++)
    {
        cin >> T[i];
        if (T[i] > maxT)
            maxT = T[i];
    }

    long long lo = 0;
    long long hi = maxT * M;

    while (lo < hi)
    {
        long mid = lo + (hi - lo) / 2;
        long processed = 0;
        for (int i = 0; i < N; i++)
        {
            processed += mid / T[i];
            if (processed >= M)
                break;
        }

        if (processed >= M)
        {
            hi = mid;
        }
        else
        {
            lo = mid + 1;
        }
    }

    cout << lo << '\n';
    return 0;
}