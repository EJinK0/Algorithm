import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());

        int start = 1, end = 1, sum = 1;
        int count = 0;

        // 연속된 양의 정수 구간 [start, end]의 합이 N이 되는 경우의 수 세기
        while (start <= N) {
            if (sum == N) {
                count++;                 // 한 가지 경우 발견
                sum -= start;            // 왼쪽 포인터 이동
                start++;
            } else if (sum < N) {
                end++;                   // 오른쪽 포인터 확장
                if (end > N) break;      // 더 확장 불가
                sum += end;
            } else { // sum > N
                sum -= start;            // 왼쪽 포인터 축소
                start++;
            }
        }

        System.out.println(count);
    }
}