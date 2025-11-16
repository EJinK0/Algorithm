import java.io.*;
import java.util.*;
public class Main {
    static int K, W, H;
    static int[][] map;
    static boolean[][][] visited;

    static int[] dx4 = {1,-1,0,0};
    static int[] dy4 = {0,0,-1,1};

    static int[] dx8 = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] dy8 = {-1, 1, -2, 2, -2, 2, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K=Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][W];
        for(int x=0;x<H;x++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<W;j++) {
                map[x][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = bfs();
        System.out.print(result);
    }

    static int bfs() {
        visited = new boolean[H][W][K+1];
        Queue<int[]> q = new ArrayDeque<>();

        q.offer(new int[]{0,0,0,0});
        visited[0][0][0] = true;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int usedHorse = cur[2];
            int dist = cur[3];

            if(x==H-1 && y==W-1) {
                return dist;
            }

            for(int i=0;i<4;i++) {
                int nx = x+dx4[i];
                int ny = y+dy4[i];

                if(nx<0||nx>=H||ny<0||ny>=W) continue;
                if(map[nx][ny] == 1) continue;
                if(visited[nx][ny][usedHorse]) continue;

                visited[nx][ny][usedHorse] = true;
                q.offer(new int[]{nx,ny,usedHorse,dist+1});
            }

            if(usedHorse < K) {
                for(int dir=0;dir<8;dir++) {
                    int nx=x+dx8[dir];
                    int ny=y+dy8[dir];

                    if(nx<0||nx>=H||ny<0||ny>=W) continue;
                    if(map[nx][ny] == 1) continue;
                    if(visited[nx][ny][usedHorse+1]) continue;

                    visited[nx][ny][usedHorse+1] = true;
                    q.offer(new int[]{nx,ny,usedHorse+1,dist+1});
                }
            }
        }
        return -1;
    }
}