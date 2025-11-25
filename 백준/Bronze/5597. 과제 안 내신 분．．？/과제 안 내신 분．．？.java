import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[] submitted = new boolean[31]; // 1 ~ 30 사용

        // 28명 번호 입력
        for (int i = 0; i < 28; i++) {
            int num = Integer.parseInt(br.readLine());
            submitted[num] = true;
        }

        // 과제 안 낸 두 명 찾기
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 30; i++) {
            if (!submitted[i]) {
                sb.append(i).append('\n');
            }
        }

        System.out.print(sb);
    }
}