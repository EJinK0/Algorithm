import java.io.*;
import java.util.*;
public class Main { 
    static int N, M;
    static int[] selected;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =  new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        selected = new int[M];
        dfs(0,1);
    }
    
    public static void dfs(int depth, int start) {
        if(depth == M) {
            for(int num: selected){
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }
         for (int i = start; i <=N; i++) {
             selected[depth] = i;
             dfs(depth+1,i);
         }
    }
}