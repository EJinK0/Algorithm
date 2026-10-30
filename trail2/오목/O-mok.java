import java.util.Scanner;

public class Main {
    static final int SIZE = 19;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] board = new int[19][19];
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        // 우,하,대각선우아래, 대각선우위
        int[] dr = {0,1,1,-1};
        int[] dc = {1,0,1,1};

        for(int r=0;r<19;r++) {
            for(int c=0;c<19;c++) {
                if(board[r][c] == 0) {
                    continue;
                }

                for(int d=0;d<4;d++) {
                    int prevR = r-dr[d];
                    int prevC = c-dc[d];

                    if(isRange(prevR, prevC) 
                    && board[prevR][prevC] == board[r][c]) {
                        continue;
                    }

                    boolean win = true;

                    for(int k=0;k<5;k++) {
                        int nr = r+dr[d]*k;
                        int nc = c+dc[d]*k;

                        if(!isRange(nr,nc)) {
                            win = false;
                            break;
                        }

                        if(board[nr][nc] != board[r][c]) {
                            win = false;
                            break;
                        }
                    }

                    if(!win) {
                        continue;
                    }

                    int nextR = r+dr[d]*5;
                    int nextC = c+dc[d]*5;

                    if (isRange(nextR, nextC)
                            && board[nextR][nextC] == board[r][c]) {
                        continue;
                    }

                    if(win) {
                        System.out.println(board[r][c]);

                        int centerR = r+dr[d]*2;
                        int centerC = c+dc[d]*2;

                        System.out.println((centerR+1) + " " + (centerC+1));
                    }

                    sc.close();
                    return;
                }
            }
        }

        System.out.println(0);
        sc.close();
    }

    static boolean isRange(int r, int c) {
        return r>=0 && r<19 && c>=0 && c<19;
    }
}