#include <iostream>
#include <algorithm>

using namespace std;

int main() {
    int ax1, ay1, ax2, ay2;
    int bx1, by1, bx2, by2;
    int mx1, my1, mx2, my2;

    cin >> ax1 >> ay1 >> ax2 >> ay2;
    cin >> bx1 >> by1 >> bx2 >> by2;
    cin >> mx1 >> my1 >> mx2 >> my2;

    int areaA = (ax2-ax1)*(ay2-ay1);
    int areab = (bx2-bx1)*(by2-by1);

    int overlapAX = max(0, min(ax2, mx2) - max(ax1, mx1));
    int overlapAY = max(0, min(ay2, my2) - max(ay1, my1));

    int overlapBX = max(0, min(bx2, mx2) - max(bx1, mx1));
    int overlapBY = max(0, min(by2, my2) - max(by1, my1));

    int overlapA = overlapAX * overlapAY;
    int overlapB = overlapBX * overlapBY;

    cout << areaA + areab - overlapA - overlapB;

    return 0;
}