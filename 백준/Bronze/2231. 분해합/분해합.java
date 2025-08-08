import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int result = 0;
        int start = Math.max(1, N - (9*String.valueOf(N).length()));
        for(int i=start ; i<N ; i++) {
            int sum = i + sumOfDigits(i);
            if(sum == N) {
                result = i;
                break;
            }
        }

        System.out.println(result);
    }

    private static int sumOfDigits(int n) {
        int sum = 0;
        while(n > 0) {
            sum += n%10;
            n /= 10;
        }
        return sum;
    }
}