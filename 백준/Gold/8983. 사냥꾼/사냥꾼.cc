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

    int M, N, L;
    cin >> M >> N >> L;

    vector<int> S(M);
    for (int i = 0; i < M; i++)
    {
        cin >> S[i];
    }
    sort(S.begin(), S.end());

    int count = 0;
    for (int i = 0; i < N; i++)
    {
        int x, y;
        cin >> x >> y;

        if (y > L)
            continue;
        int idx = int(lower_bound(S.begin(), S.end(), x) - S.begin());

        bool ok = false;
        if (idx < M)
        {
            long long dist = llabs((long long)S[idx] - x) + y;
            if (dist <= L)
                ok = true;
        }

        if (!ok && idx - 1 >= 0)
        {
            long long dist = llabs((long long)S[idx - 1] - x) + y;
            if (dist <= L)
                ok = true;
        }

        if (ok)
            ++count;
    }

    cout << count << "\n";
    return 0;
}