import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String L = st.nextToken();
        String R = st.nextToken();

        // 자릿수가 다르면 답은 0
        if (L.length() != R.length()) {
            System.out.println(0);
            return;
        }

        int cnt = 0;
        for (int i = 0; i < L.length(); i++) {
            char a = L.charAt(i), b = R.charAt(i);
            if (a != b) break;        // 처음 다르면 거기서 중단
            if (a == '8') cnt++;      // 동일하고 그 숫자가 8이면 카운트
        }
        System.out.println(cnt);
    }
}