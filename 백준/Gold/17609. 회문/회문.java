import java.io.*;
import java.util.*;

public class Main {
    // s[l..r]가 회문인지 확인
    static boolean isPalindrome(char[] s, int l, int r) {
        while (l < r) {
            if (s[l] != s[r]) return false;
            l++; r--;
        }
        return true;
    }

    // s가 회문(0) / 유사 회문(1) / 그 외(2)
    static int classify(char[] s) {
        int l = 0, r = s.length - 1;

        while (l < r) {
            if (s[l] == s[r]) { l++; r--; continue; }

            // 첫 불일치: 왼쪽 하나 제거 or 오른쪽 하나 제거 시도
            boolean skipLeft  = isPalindrome(s, l + 1, r);
            boolean skipRight = isPalindrome(s, l, r - 1);
            if (skipLeft || skipRight) return 1;
            return 2;
        }
        return 0; // 끝까지 불일치 없으면 회문
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());
        for (int tc = 0; tc < T; tc++) {
            char[] s = br.readLine().trim().toCharArray();
            out.append(classify(s)).append('\n');
        }
        System.out.print(out.toString());
    }
}