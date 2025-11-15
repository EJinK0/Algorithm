import java.io.*;
import java.util.*;
public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int pictureCount = 0;
        int maxArea = 0;

        for(int x=0;x<N;x++) {
            for(int y=0;y<M;y++) {
                if(map[x][y] == 1 && !visited[x][y]) {
                    pictureCount++;
                    int area = dfs(x,y);
                    if(area > maxArea) maxArea = area;
                }
            }
        }

        System.out.print(pictureCount + "\n" + maxArea);
    }

    static int dfs(int x, int y) {
        visited[x][y] = true;
        int area = 1;

        for(int i=0;i<4;i++) {
            int nx = x+dx[i];
            int ny = y+dy[i];

            if(nx<0||nx>=N||ny<0||ny>=M) continue;
            if(visited[nx][ny]) continue;
            if(map[nx][ny] == 0) continue;

            area += dfs(nx, ny);
        }

        return area;
    }
}