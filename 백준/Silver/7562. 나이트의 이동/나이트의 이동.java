import java.io.*;
        import java.util.*;
public class Main {
    static int T;
    static int[][] map;
    static boolean[][] visited;

    static int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            int l = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sx = Integer.parseInt(st.nextToken());
            int sy = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int tx = Integer.parseInt(st.nextToken());
            int ty = Integer.parseInt(st.nextToken());

            if(sx == tx && sy == ty) {
                sb.append(0).append('\n');
                continue;
            }

            int[][] dist = new int[l][l];
            for(int i=0;i<l;i++) {
                Arrays.fill(dist[i], -1);
            }

            Queue<int[]> q = new ArrayDeque<>();
            q.offer(new int[]{sx,sy});
            dist[sx][sy] = 0;

            while(!q.isEmpty()) {
                int[] cur = q.poll();
                int x = cur[0];
                int y = cur[1];

                for(int dir = 0; dir<8;dir++) {
                    int nx = x + dx[dir];
                    int ny = y + dy[dir];

                    if(nx<0 || nx>=l || ny < 0 || ny >= l) continue;
                    if(dist[nx][ny] != -1) continue;

                    dist[nx][ny] = dist[x][y] + 1;
                    q.offer(new int[]{nx,ny});

                    if(nx == tx && ny == ty) {
                        q.clear();
                        break;
                    }
                }
            }

            sb.append(dist[tx][ty]).append('\n');
        }

        System.out.println(sb);
    }
}