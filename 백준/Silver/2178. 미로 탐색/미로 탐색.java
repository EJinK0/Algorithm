import java.io.*;
import java.util.*;

public class Main {
    static final int[] dx = { -1, 1, 0, 0 };
    static final int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] grid = new char[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine().trim();
            grid[i] = line.toCharArray();
        }

        int[][] dist = new int[N][M];           // 0: 미방문, >0: 시작부터의 칸 수
        ArrayDeque<int[]> q = new ArrayDeque<>();

        // 시작점 (0,0)에서 BFS 시작 (문제는 1-based지만 코드에선 0-based)
        dist[0][0] = 1;
        q.add(new int[]{0, 0});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];

            // 도착 지점에 도달하면 바로 종료 (최단 거리 확보)
            if (x == N - 1 && y == M - 1) {
                System.out.println(dist[x][y]);
                return;
            }

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue; // 범위 체크
                if (grid[nx][ny] == '0') continue;                     // 벽
                if (dist[nx][ny] != 0) continue;                       // 이미 방문

                dist[nx][ny] = dist[x][y] + 1;
                q.add(new int[]{nx, ny});
            }
        }

        // (문제 조건상 항상 도달 가능이라 보통 여기 오지 않지만, 안전 차단)
        System.out.println(-1);
    }
}