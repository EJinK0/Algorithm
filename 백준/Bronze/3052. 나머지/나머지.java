import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        boolean[] rest = new boolean[42]; // 나머지 등장 여부 체크
        for (int i = 0; i < 10; i++) {
            int n = Integer.parseInt(br.readLine());
            int r = n % 42;
            rest[r] = true;
        }
        
        int count = 0;
        for (int i = 0; i < 42; i++) {
            if (rest[i]) count++;
        }
        
        System.out.println(count);
    }
}