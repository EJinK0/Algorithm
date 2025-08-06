import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static int[] times;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        times = new int[N];
        for(int i=0;i<N;i++) {
            times[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(times);

        long total = 0;
        long cumulative = 0;

        for(int t: times) {
            cumulative += t;
            total += cumulative;
        }

        System.out.println(total);
    }
}