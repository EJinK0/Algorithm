import java.io.*;
import java.util.*;
public class Main {
    static int N, M;
    static int[][] tomatoBox;
    static boolean[][] visited;
    static Queue<int[]> queue = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        BufferedReader sb = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(sb.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        tomatoBox = new int[N][M];
        visited = new boolean[N][M];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(sb.readLine());
            for (int j = 0; j < M; j++) {
                tomatoBox[i][j] = Integer.parseInt(st.nextToken());
                if(tomatoBox[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        
        int[] dRow = {-1, 1, 0, 0};
        int[] dCol = {0, 0, -1, 1};
        int maxDay = 0;
        
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int row = cur[0], col = cur[1];
            for(int i=0;i<4;i++) {
                int nRow = row + dRow[i];
                int nCol = col + dCol[i];
                if(nRow < 0 || nRow >= N || nCol < 0 || nCol >= M) continue;
                if(tomatoBox[nRow][nCol] == 0) {
                    tomatoBox[nRow][nCol] = tomatoBox[row][col] + 1;
                    maxDay = Math.max(maxDay, tomatoBox[nRow][nCol]);
                    queue.offer(new int[]{nRow, nCol});
                } 
            }
        }
        
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                if(tomatoBox[i][j] == 0) {
                    System.out.print(-1);
                    return;
                }
            }
        }

        System.out.println(maxDay == 0 ? 0 : maxDay - 1); 
    }
}