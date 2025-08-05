import java.io.*;
import java.util.*;
public class Main {
    static int row, col;
    static int [][] A;
    static int [][] B;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        A = new int[row][col];
        B = new int[row][col];


        for(int i=0;i<row;i++) {
            String line = br.readLine();
            for(int j=0;j<col;j++) {
                A[i][j] = line.charAt(j) - '0';
            }
        }

        for(int i=0;i<row;i++) {
            String line = br.readLine();
            for(int j=0;j<col;j++) {
                B[i][j] = line.charAt(j) - '0';
            }
        }

        if (row < 3 || col < 3) {
            boolean same = true;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (A[i][j] != B[i][j]) {
                        same = false;
                        break;
                    }
                }
                if (!same) break;
            }
            System.out.println(same ? 0 : -1);
            return;
        }

        for(int i=0;i<=row-3;i++) {
            for(int j=0;j<=col-3;j++) {
                if(A[i][j] != B[i][j]) {
                    filp3x3(A, i, j);
                    count++;
                }
            }
        }

        boolean possible = true;
        for(int i=0;i<row;i++) {
            for(int j=0;j<col;j++) {
                if(A[i][j] != B[i][j]) {
                    possible = false;
                    break;
                }
            }
        }

        System.out.println(possible ? count : -1);
    }

    public static void filp3x3(int[][] A, int r, int c) {
        for(int i=0 ; i<3 ; i++) {
            for(int j=0;j<3;j++) {
                A[r+i][c+j] = 1-A[r+i][c+j];
            }
        }
    }
}