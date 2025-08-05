import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static char[][] grid;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        grid = new char[N][N];
        visited = new boolean[N][N];

        for(int i=0;i<N;i++) {
            grid[i] = br.readLine().trim().toCharArray();
        }

        int normalCount = 0;
        int blindCount = 0;

        for(int i=0 ; i<N ; i++) {
            for(int j=0 ; j<N ; j++) {
                if(!visited[i][j]) {
                    dfs(i, j, grid[i][j]);
                    normalCount++;
                }
            }
        }

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (grid[r][c] == 'G') {
                    grid[r][c] = 'R';
                }
            }
        }

        visited = new boolean[N][N];
        for(int i=0 ; i<N ; i++) {
            for(int j=0 ; j<N ; j++) {
                if(!visited[i][j]) {
                    dfs(i, j, grid[i][j]);
                    blindCount++;
                }
            }
        }

        System.out.print(normalCount + " " + blindCount);
    }

    static int[] dRow = {-1, 1, 0, 0};
    static int[] dCol = {0, 0, -1, 1};
    public static void dfs(int row, int col, char color) {
        visited[row][col] = true;
        for(int i=0 ; i<4 ; i++) {
            int nRow = row + dRow[i];
            int nCol = col + dCol[i];
            if(nRow >= 0 && nCol >= 0 && nRow < N && nCol < N) {
                if(!visited[nRow][nCol] && grid[nRow][nCol] == color) {
                    dfs(nRow, nCol, color);
                }
            }
        }
    }
}