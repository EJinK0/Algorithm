#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, x;
    cin >> n;

    vector<int> arr(n);

    for (int i = 0; i < n; i++)
    {
        cin >> arr[i];
    }

    cin >> x;

    sort(arr.begin(), arr.end());

    int left = 0;
    int right = n - 1;
    int count = 0;

    while (left < right)
    {
        int sum = arr[left] + arr[right];
        if (sum == x)
        {
            left++;
            right--;
            count++;
        }
        else if (sum < x)
        {
            left++;
        }
        else
        {
            right--;
        }
    }

    cout << count;
    return 0;
}