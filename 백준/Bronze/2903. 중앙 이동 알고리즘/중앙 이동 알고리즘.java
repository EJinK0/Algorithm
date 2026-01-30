import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long side = (1L << N) + 1;   // 2^N + 1  (비트 시프트로 빠르게)
        long result = side * side;

        System.out.println(result);
    }
}