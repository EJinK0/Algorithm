import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sbStr = new StringBuilder();
        while(sbStr.length() < N) {
            String line = br.readLine();
            if(line==null) break;
            sbStr.append(line.trim());
        }
        String s = sbStr.toString();

        long[][][][] dp = new long[3][3][3][3];
        int tcnt = 0, gcnt=0, fcnt=0, pcnt=0;
        long ans=0;

        dp[0][0][0][0] = 1;
        for(int i=0;i<N;i++) {
            char x = s.charAt(i);
            if(x == 'T') {
                tcnt = (tcnt+1)%3;
            } else if(x == 'G') {
                gcnt = (gcnt+1)%3;
            } else if(x == 'F') {
                fcnt = (fcnt+1)%3;
            }else if(x == 'P') {
                pcnt = (pcnt+1)%3;
            }
            
            ans += dp[tcnt][gcnt][fcnt][pcnt];
            dp[tcnt][gcnt][fcnt][pcnt] += 1;
        }

        System.out.println(ans);
    }
}