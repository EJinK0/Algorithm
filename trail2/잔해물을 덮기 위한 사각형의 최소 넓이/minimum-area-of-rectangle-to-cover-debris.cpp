#include <iostream>
#include <algorithm>

using namespace std;

int main() {
    int ax1, ay1, ax2, ay2;
    int bx1, by1, bx2, by2;

    cin >> ax1 >> ay1 >> ax2 >> ay2;
    cin >> bx1 >> by1 >> bx2 >> by2;
    
    int width = ax2-ax1;
    int height =ay2-ay1;

    if(bx1<=ax1 && ax2 <= bx2) {
        if(by1 <= ay1 && by2 < ay2) {
            height = ay2 - max(ay1, by2);
        } else if(ay1 < by1 && ay2 <= by2) {
            height = min(ay2, by1)-ay1;
        } else if(by1<=ay1 && ay2<=by2) {
            height = 0;
        }
    }

    if(by1<=ay1 && ay2<=by2) {
        if(bx1 <= ax1 && bx2 < ax2) {
            width = ax2-max(ax1,bx2);
        } else if(ax1<bx1&&ax2<=bx2) {
            width=min(ax2,bx1)-ax1;
        } else if(bx1<=ax1&&ax2<=bx2) {
            width=0;
        }
    }

    cout << width*height;

    // Please write your code here.

    return 0;
}