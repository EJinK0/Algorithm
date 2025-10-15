#include <iostream>
#include <string>
#include <array>
using namespace std;

static bool isGroupWorld(const string& s) {
    array<bool, 26> seen{};
    char prev = 0;
    
    for(char c: s) {
        if(c != prev) {
            int idx = c - 'a';
            if(seen[idx]) return false;
            seen[idx] = true;
            prev = c;
        }
    }

    return true;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int N;
    if(!(cin >> N)) return 0;

    int count = 0;
    for(int i=0 ; i<N ; i++) {
        string s;
        cin >> s;
        if(isGroupWorld(s)) ++count;
    }
    
    cout << count << '\n';
    return 0;
}