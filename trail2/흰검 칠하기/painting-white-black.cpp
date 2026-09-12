#include <iostream>
#include <vector>
using namespace std;

int n;

int main() {
    cin >> n;
    const int OFFSET = 100000;

    vector<int> white(200001, 0);
    vector<int> black(200001, 0);
    vector<char> lastColor(200001, 0);

    int pos=0;

    for (int i = 0; i < n; i++) {
        int x;
        char dir;
        cin >> x >> dir;

        if(dir == 'R') {
            for(int j=pos;j<pos+x;j++) {
                int idx = j+OFFSET;
                black[idx]++;
                lastColor[idx] = 'B';
            }

            pos = pos + x - 1;
        } else {
            for(int j=pos ; j>pos-x;j--) {
                int idx = j+OFFSET;
                white[idx]++;
                lastColor[idx] = 'W';
            }

            pos = pos - x + 1;
        }
    }

    int whiteCount=0;
    int blackCount=0;
    int grayCount=0;
    for(int i=0;i<200001;i++) {
        if(white[i] >= 2 && black[i] >= 2) {
            grayCount++;
        } else if (lastColor[i] == 'W') {
            whiteCount++;
        } else if(lastColor[i] =='B'){
            blackCount++;
        }
    }

       cout << whiteCount << " "
         << blackCount << " "
         << grayCount;
    // Please write your code here.

    return 0;
}