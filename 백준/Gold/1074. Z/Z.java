import java.io.*;
import java.util.*;
public class Main {
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int size = 1 << N;
        dfs(size, r, c);
        System.out.println(count);
    }

    public static void dfs(int size, int r, int c) {
        if(size == 1) {
            return;
        }

        int half = size / 2;
        int quadrant = 0;
        int add = 0;
        if(r < half && c < half) {
            quadrant = 0;
            add = 0;
        } else if (r<half && c>=half) {
            quadrant = 1;
            c -= half;
            add = 1;
        } else if (r >= half && c < half) {
            quadrant = 2;
            r -= half;
            add = 2;
        } else {
            quadrant = 3;
            r -= half;
            c -= half;
            add = 3;
        }

        int increment = add * (half * half);
        count += increment;

        dfs(half, r, c);
    }
}