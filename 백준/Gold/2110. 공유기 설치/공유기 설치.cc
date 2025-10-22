#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

static int N, C;
static vector<int> house;

static bool canInstall(long long dist)
{
    int count = 1;
    int last = house[0];

    for (int i = 0; i < N; i++)
    {
        long long diff = static_cast<long long>(house[i]) - last;
        if (diff >= dist)
        {
            count++;
            last = house[i];
        }
    }

    return count >= C;
}

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> N >> C;
    house.resize(N);
    for (int i = 0; i < N; i++)
    {
        cin >> house[i];
    }
    sort(house.begin(), house.end());

    long long lo = 1;
    long long hi = static_cast<long long>(house[N - 1] - house[0]);
    int ans = 0;
    while (lo <= hi)
    {
        long long midLL = (lo + hi) / 2; // (lo+hi) / 2
        int mid = static_cast<int>(midLL);

        if (canInstall(mid))
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