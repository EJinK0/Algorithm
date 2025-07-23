import java.util.*;
public class Main {
    static int N, M;
    static int[] selected;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // 1~N까지
        M = sc.nextInt(); // 중복없는M개
        selected = new int[M];

        dfs(0,1);
    }

    public static void dfs(int depth, int start) {
        if(depth == M) {
            for(int num: selected) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        for(int i = start ; i <= N ; i++) {
            selected[depth] = i;
            dfs(depth+1, i+1);
        }
    }
}