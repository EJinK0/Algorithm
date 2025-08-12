import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static int count;
    static long[] numbers;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        count = Integer.parseInt(st.nextToken());
        numbers = new long[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++){
            numbers[i] = numbers[i-1] + Integer.parseInt(st.nextToken());
        }
        
        int sum = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<count;i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            
            sb.append(numbers[end]-numbers[start-1]).append("\n");
        }
        
        System.out.println(sb);
    }
}