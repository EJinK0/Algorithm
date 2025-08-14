import java.io.*;
import java.util.*;
public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        int[][] a = new int[N][2];
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            a[i][0] = Integer.parseInt(st.nextToken());
            a[i][1] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(a, (x, y) -> {
            if (x[1] != y[1]) return Integer.compare(x[1], y[1]); // 종료 시간 오름차순
            return Integer.compare(x[0], y[0]);
        });

        int cnt=0;
        int lastEnd = -1;
        
        for (int i = 0; i < N; i++) {
            if (a[i][0] >= lastEnd) { // 겹치지 않으면 채택
                cnt++;
                lastEnd = a[i][1];
            }
        }

        System.out.println(cnt);
    }
}