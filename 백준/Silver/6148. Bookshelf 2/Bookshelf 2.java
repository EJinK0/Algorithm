import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, B;
    static int[] height;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        height = new int[N];
        for (int i = 0; i < N; i++) {
            height[i] = Integer.parseInt(br.readLine());
        }

        dfs(0, 0);

        System.out.println(answer - B);
    }

    static void dfs(int idx, int sum) {
        // 이미 목표를 넘겼으면 답 후보 갱신
        if (sum >= B) {
            answer = Math.min(answer, sum);
            return;
        }

        // 끝까지 다 본 경우
        if (idx == N) {
            return;
        }

        // 이미 현재 합이 answer 이상이면 더 볼 필요 없음
        if (sum >= answer) {
            return;
        }

        // 현재 소를 선택하는 경우
        dfs(idx + 1, sum + height[idx]);

        // 현재 소를 선택하지 않는 경우
        dfs(idx + 1, sum);
    }
}