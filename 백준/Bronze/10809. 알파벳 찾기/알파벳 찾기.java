import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int[] pos = new int[26];

        // 처음엔 전부 -1로 설정
        for (int i = 0; i < 26; i++) {
            pos[i] = -1;
        }

        // 문자열 탐색하면서 처음 등장하는 위치만 기록
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int idx = c - 'a';
            if (pos[idx] == -1) {
                pos[idx] = i;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            sb.append(pos[i]).append(" ");
        }

        System.out.println(sb.toString().trim());
    }
}