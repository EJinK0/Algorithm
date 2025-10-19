#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;

    int start = 1, end = 1, sum = 1;
    int count = 0;

    while (start <= n)
    {
        if (sum == n)
        {
            count++;
            sum -= start;
            start++;
        }
        else if (sum < n)
        {
            end++;
            if (end > n)
                break;
            sum += end;
        }
        else
        {
            sum -= start;
            start++;
        }
    }

    cout << count;
}