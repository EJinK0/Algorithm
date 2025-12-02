import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().trim(); // 앞뒤 공백 제거

        if (s.isEmpty()) {
            System.out.println(0); // 공백만 있는 경우
            return;
        }

        // 공백 1개 이상 기준으로 split
        String[] words = s.split("\\s+");
        System.out.println(words.length);
    }
}