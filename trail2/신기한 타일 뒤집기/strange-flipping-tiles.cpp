#include <iostream>
#include <vector>

using namespace std;

int n;

int main() {
    cin >> n;
    const int OFFSET = 100000;
    const int SIZE = 200001;

    vector<char> color(SIZE, 0);

    int pos = 0;

    for (int i = 0; i < n; i++) {
        int x;
        char dir;

        cin >> x >> dir;

        if(dir == 'R') {
            for(int j=pos;j<pos+x;j++) {
                color[j+OFFSET] = 'B';
            }
            pos = pos+x-1;
        } else {
            for(int j=pos;j>pos-x;j--) {
                color[j+OFFSET] = 'W';
            }
            pos=pos-x+1;
        }
    }

    int whiteCount=0;
    int blackCount=0;

    for(int i=0;i<SIZE;i++) {
        if(color[i] == 'W') {
            whiteCount++;
        } else if(color[i] == 'B') {
            blackCount++;
        }
    }

    cout<< whiteCount << " " << blackCount;
 
    // Please write your code here.

    return 0;
}