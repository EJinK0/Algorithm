import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int left = 0;
        int right = s.length() - 1;
        int result = 1; // 일단 팰린드롬이라고 가정

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                result = 0;
                break;
            }
            left++;
            right--;
        }

        System.out.println(result);
    }
}