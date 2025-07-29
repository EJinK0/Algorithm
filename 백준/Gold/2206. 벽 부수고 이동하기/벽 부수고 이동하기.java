import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int[][] map;
    static boolean[][][] visited;
    static int[] dRow = {-1, 1, 0, 0}; //상하좌우
    static int[] dCol = {0, 0, -1, 1};

    static class Node {
        int x, y, dist, wall;
        Node(int x, int y, int dist, int wall) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.wall = wall;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M][2];

        for(int i=0 ; i<N ; i++) {
            String line = br.readLine();
            for(int j=0 ; j<M ; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        System.out.println(bfs());
    }

    static int bfs () {
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(0,0,1,0));
        visited[0][0][0] = true;

        while(!q.isEmpty()) {
            Node cur = q.poll();
            if(cur.x == N-1 && cur.y == M-1) {
                return cur.dist;
            }

            for(int d=0 ; d<4 ; d++) {
                int nx = cur.x + dRow[d];
                int ny = cur.y + dCol[d];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M) {
                    continue;
                }

                // 이동 가능 & 벽 안 부순 상태
                if(map[nx][ny] == 0 && !visited[nx][ny][cur.wall]) {
                    visited[nx][ny][cur.wall] = true;
                    q.add(new Node(nx, ny, cur.dist+1, cur.wall));
                }

                // 벽을 만났고, 아직 벽 안 부쉈다면
                if (map[nx][ny] == 1 && cur.wall == 0 && !visited[nx][ny][1]) {
                    visited[nx][ny][1] = true;
                    q.add(new Node(nx, ny, cur.dist + 1, 1));
                }
            }
        }
        return -1;
    }
}