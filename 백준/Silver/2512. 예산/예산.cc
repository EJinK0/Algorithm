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

    int n;
    cin >> n;

    int hi = 0;
    int total = 0;
    vector<int> a(n);
    for (int i = 0; i < n; i++)
    {
        cin >> a[i];
        total += a[i];
        if (a[i] >= hi)
        {
            hi = a[i];
        }
    }

    int m;
    cin >> m;

    if (total <= m)
    {
        cout << hi;
        return 0;
    }

    int lo = 0;
    int ans = 0;
    while (lo <= hi)
    {
        int mid = lo + (hi - lo) / 2;
        long need = 0;
        for (int v : a)
        {
            need += (v >= mid ? mid : v);
            if (need > m)
                break;
        }

        if (need <= m)
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