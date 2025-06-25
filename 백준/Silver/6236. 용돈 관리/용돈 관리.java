import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // N일
        int M = sc.nextInt(); // 돈을 뺀 횟수 m

        int[] money = new int[N]; // n일동안 쓴돈의 배열

        int max = 0;
        int sum = 0;

        for (int i = 0; i < N; i++) {
            money[i] = sc.nextInt();
            max = Math.max(max, money[i]);
            sum += money[i];
        }

        // 탐색 범위 left ~ right
        int left = max;
        int right = sum;
        int answer = sum;

        while (left <= right) {
            int mid = (left + right) / 2;
            if(check(money, M, mid)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(answer);
    }

    // mid 한번에 인출하는 금액
    private static boolean check(int[] money, int M, int mid) {
        int count = 1;
        int current = mid;

        for(int i = 0; i < money.length; i++) {
            int m = money[i];

            if(m > mid) {
                return false;
            }

            if(current < m) {
                count++;
                current = mid;
            }

            current -= m;
        }

        return count <= M;
    }
}