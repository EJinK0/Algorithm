import java.io.*;
import java.util.*;
public class Main {
    static int[][] field;
    static boolean[][] visited;
    static int row;
    static int col;
    static int[] dRow = {-1,1,0,0};
    static int[] dCol = {0,0,-1,1};
    static boolean canReach = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        col = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());

        field = new int[row][col];
        visited = new boolean[row][col];

        for(int i=0;i<row;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<col;j++) {
                field[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        if(field[0][0] == 1) {
            visited[0][0] = true;
            dfs(0,0);
        }

        System.out.println(canReach ? "Yes" : "No");
    }

    public static void dfs(int sRow, int sCol) {
        if(sRow == row-1 && sCol == col-1) {
            canReach = true;
            return;
        }

        for(int i=0;i<4;i++) {
            int nRow = sRow+dRow[i];
            int nCol = sCol+dCol[i];

            if(i != 1 && i !=3) continue;
            if(nRow < 0 || nRow >= row || nCol < 0 || nCol >= col) continue;
            if(field[nRow][nCol] == 0) continue;
            if(visited[nRow][nCol]) continue;

            visited[nRow][nCol] = true;
            dfs(nRow, nCol);
        }
    } 
}