#include <iostream>
#include <string>

using namespace std;

string A;

int main() {
    cin >> A;

    int answer = 0;

    for(int i=0;i<A.size();i++) {
        if(A[i] != '(') continue;

        for(int j=i+1;j<A.size();j++) {
            if(A[j] == ')') {
                answer++;
            }
        }
    }

    cout << answer;

    // Please write your code here.

    return 0;
}