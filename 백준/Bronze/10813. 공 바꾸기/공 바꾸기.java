import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[N + 1]; // 1번부터 N번까지 사용
        
        // 초기 상태: i번 바구니에 i번 공
        for (int i = 1; i <= N; i++) {
            arr[i] = i;
        }
        
        for (int t = 0; t < M; t++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            
            // swap
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(arr[i]).append(' ');
        }
        
        System.out.println(sb.toString());
    }
}