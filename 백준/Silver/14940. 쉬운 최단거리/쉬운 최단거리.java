import java.io.*;
import java.util.*;
public class Main {
    static int N, M;
    static int[][] map;
    static int[][] dist;
    static boolean[][] visited;
    static int[] dRow = {-1, 1, 0, 0};
    static int[] dCol = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        dist = new int[N][M];
        visited = new boolean[N][M];

        Queue<int[]> queue = new ArrayDeque<>();

        for(int i=0 ; i<N ; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0 ; j<M ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dist[i][j] = -1;
                if(map[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                    dist[i][j] = 0;
                }
                if(map[i][j] == 0) {
                    visited[i][j] = true;
                    dist[i][j] = 0;
                }
            }
        }

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int row = cur[0], col = cur[1];
            for(int i=0 ; i<4 ; i++) {
                int nRow = row + dRow[i];
                int nCol = col + dCol[i];
                if(nRow < 0 || nCol < 0 || nRow >= N || nCol >= M) continue;
                if(visited[nRow][nCol] || map[nRow][nCol] == 0) continue;
                visited[nRow][nCol] = true;
                dist[nRow][nCol] = dist[row][col] + 1;
                queue.offer(new int[]{nRow, nCol});
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                sb.append(dist[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}