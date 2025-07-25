import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] apartMap;
    static boolean[][] visited;
    static int count;

    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        apartMap = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                apartMap[i][j] = line.charAt(j) - '0';
            }
        }

        List<Integer> complexList = new ArrayList<>();
        int complexNumber = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (apartMap[i][j] == 1 && !visited[i][j]) {
                    count = 0;
                    complexNumber++;       
                    dfs(i, j);
                    complexList.add(count);
                }
            }
        }

        // 정렬 및 출력
        Collections.sort(complexList);
        System.out.println(complexList.size());
        for (int num : complexList) {
            System.out.println(num);
        }
    }

    static int[] dRow = {-1, 1, 0, 0}; // 상하좌우
    static int[] dCol = {0, 0, -1, 1};

    public static void dfs(int row, int col) {
        visited[row][col] = true;
        count++;

        for (int i = 0; i < 4; i++) {
            int nRow = row + dRow[i];
            int nCol = col + dCol[i];

            // 유효 범위 내 && 집이 있고 && 방문 안한 경우
            if (nRow >= 0 && nCol >= 0 && nRow < N && nCol < N) {
                if (apartMap[nRow][nCol] == 1 && !visited[nRow][nCol]) {
                    dfs(nRow, nCol);
                }
            }
        }
    }
}