import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int R = sc.nextInt();
        int C = sc.nextInt();

        char[][] map = new char[R][C];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                map[i][j] = sc.next().charAt(0);
            }
        }

        int answer = 0;

        // 첫 번째 중간 위치
        for (int r1 = 1; r1 < R - 1; r1++) {
            for (int c1 = 1; c1 < C - 1; c1++) {

                // 두 번째 중간 위치
                for (int r2 = r1 + 1; r2 < R - 1; r2++) {
                    for (int c2 = c1 + 1; c2 < C - 1; c2++) {

                        // 점프할 때마다 색이 달라야 함
                        if (map[0][0] != map[r1][c1]
                                && map[r1][c1] != map[r2][c2]
                                && map[r2][c2] != map[R - 1][C - 1]) {

                            answer++;
                        }
                    }
                }
            }
        }

        System.out.println(answer);

        sc.close();
    }
}