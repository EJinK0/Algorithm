import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static int[] nums;
    static int sum = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String numbers = br.readLine();
        nums = new int[numbers.length()];

        for(int i=0;i<N;i++) {
            nums[i] = numbers.charAt(i) - '0';
            sum += nums[i];
        }
        System.out.println(sum);
    }
}