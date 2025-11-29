import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수
        StringBuilder sb = new StringBuilder();
        
        for (int t = 0; t < T; t++) {
            String s = br.readLine();
            char first = s.charAt(0);
            char last = s.charAt(s.length() - 1);
            sb.append(first).append(last).append('\n');
        }
        
        System.out.print(sb.toString());
    }
}