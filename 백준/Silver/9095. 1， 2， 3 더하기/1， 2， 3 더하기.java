import java.io.*;
import java.util.*;
public class Main {
    static int[] memo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        memo = new int[11];
        memo[1] = 1;
        memo[2] = 2;
        memo[3] = 4;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<T;i++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(countWays(n)).append("\n");
        }
        
        System.out.println(sb);
    }
    
    public static int countWays(int n) {
        if(n<=3) return memo[n];
        if(memo[n] != 0) return memo[n];
        return memo[n] = countWays(n-1)+countWays(n-2)+countWays(n-3);
    }
}