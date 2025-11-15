import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static int[][] S;
    static boolean[] selected;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        S = new int[N][N];
        selected = new boolean[N];

        for(int i=0;i<N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0,0);
        System.out.println(answer);
    }

    static void dfs(int depth, int start) {
        if(depth == N/2) {
            calcDiff();
            return;
        }
        for(int i=start;i<N;i++) {
            selected[i] = true;
            dfs(depth+1, i+1);
            selected[i] = false;
        }
    }

    static void calcDiff() {
        int startSum = 0;
        int linkSum = 0;
        
        for(int i=0;i<N;i++) {
            for(int j=i+1;j<N;j++) {
                if(selected[i] && selected[j]) {
                    startSum += S[i][j] + S[j][i];
                } else if(!selected[i] && !selected[j]){
                    linkSum += S[i][j] + S[j][i];
                }
            }
        }

        int diff = Math.abs(startSum-linkSum);
        if(diff<answer) {
            answer = diff;
        }
    }
}