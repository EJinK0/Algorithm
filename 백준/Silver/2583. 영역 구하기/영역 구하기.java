import java.io.*;
import java.util.*;
public class Main {
    static int M, N, K;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0}; // column
    static int[] dy = {0, 0, 1, -1}; // row

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        visited = new boolean[M][N];

        for(int i=0;i<K;i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for(int y=y1;y<y2;y++) {
                for(int x=x1;x<x2;x++) {
                    map[y][x] = 1;
                }
            }
        }

        List<Integer> areas = new ArrayList<>();

        for(int y=0;y<M;y++) {
            for(int x=0;x<N;x++) {
                if(map[y][x] == 0 && !visited[y][x]) {
                    int area = bfs(y,x);
                    areas.add(area);
                }
            }
        }

        Collections.sort(areas);
        StringBuilder sb = new StringBuilder();
        sb.append(areas.size()).append('\n');
        for(int area: areas) {
            sb.append(area).append(' ');
        }

        System.out.println(sb.toString().trim());
    }

    static int bfs(int sy, int sx) {
       Queue<int[]> q = new ArrayDeque<>();
       q.offer(new int[]{sy, sx});
       visited[sy][sx] = true;
       int area = 1;

       while(!q.isEmpty()) {
           int[] cur = q.poll();
           int y = cur[0];
           int x = cur[1];

           for(int dir=0;dir<4;dir++) {
               int ny = y+dy[dir];
               int nx = x+dx[dir];
               if(ny<0||ny>=M||nx<0||nx>=N) continue;
               if(visited[ny][nx]) continue;
               if(map[ny][nx] == 1) continue;

               visited[ny][nx] = true;
               area++;
               q.offer(new int[]{ny, nx});
           }
       }

       return area;
    }
}