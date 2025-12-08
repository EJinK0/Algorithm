import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().toUpperCase(); // 대소문자 구분 없애기

        int[] cnt = new int[26];

        // 알파벳 빈도수 카운트
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            cnt[c - 'A']++;
        }

        int max = -1;
        char answer = '?';

        // 최대 빈도 문자 찾기
        for (int i = 0; i < 26; i++) {
            if (cnt[i] > max) {
                max = cnt[i];
                answer = (char) (i + 'A');
            } else if (cnt[i] == max) {
                // 최댓값이 같은 알파벳이 또 나오면 ?
                answer = '?';
            }
        }

        System.out.println(answer);
    }
}