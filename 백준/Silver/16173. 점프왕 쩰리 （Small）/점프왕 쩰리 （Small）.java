import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static boolean found = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];

        for(int i=0;i<N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0,0);
        if(found) {
            System.out.println("HaruHaru");
        } else {
            System.out.println("Hing");
        }
    }

    static void dfs(int x, int y) {
        if(found) return;
        if(x<0||x>=N||y<0||y>=N) return;
        if(visited[x][y]) return;

        visited[x][y] = true;
        if(map[x][y] == -1) {
            found=true;
            return;
        }

        int move = map[x][y];
        if(move == 0) return;
        dfs(x+move, y);
        dfs(x, y+move);
    }
}