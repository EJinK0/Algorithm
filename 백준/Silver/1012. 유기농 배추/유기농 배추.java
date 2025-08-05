import java.io.*;
import java.util.*;
public class Main {
    static int testCase;
    static int row;
    static int col;
    static int cabbage;
    static int[][] field;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        testCase = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for(int i=0;i<testCase;i++) {
            st = new StringTokenizer(br.readLine());
            col = Integer.parseInt(st.nextToken());
            row = Integer.parseInt(st.nextToken());
            cabbage = Integer.parseInt(st.nextToken());

            field = new int[row][col];
            visited = new boolean[row][col];

            for(int j=0;j<cabbage;j++) {
                st = new StringTokenizer(br.readLine());
                int rCol = Integer.parseInt(st.nextToken());
                int rRow = Integer.parseInt(st.nextToken());
                field[rRow][rCol] = 1;
            }

            int wormCount = 0;
            for(int k=0;k<row;k++) {
                for(int v=0;v<col;v++) {
                    if(field[k][v] == 1 && !visited[k][v]) {
                        wormCount++;
                        dfs(k,v);
                    }
                }
            }

            System.out.println(wormCount);
        }
    }

    static int[] dRow = {-1,1,0,0};
    static int[] dCol = {0,0,-1,1};
    public static void dfs(int sRow, int sCol) {
        visited[sRow][sCol] = true;
        for(int i=0;i<4;i++) {
            int nRow = sRow+dRow[i];
            int nCol = sCol+dCol[i];

            if(nRow >=0 && nCol >= 0 && nRow < row && nCol < col) {
                if(field[nRow][nCol] == 1 && !visited[nRow][nCol]) {
                    dfs(nRow, nCol);
                }
            }
        }
    }
}