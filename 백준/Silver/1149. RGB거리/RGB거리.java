import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        for (int i = 2; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int cr = Integer.parseInt(st.nextToken());
            int cg = Integer.parseInt(st.nextToken());
            int cb = Integer.parseInt(st.nextToken());

            int nr = Math.min(g, b) + cr;
            int ng = Math.min(r, b) + cg;
            int nb = Math.min(r, g) + cb;

            r = nr;
            g = ng;
            b = nb;
        }

        System.out.println(Math.min(r, Math.min(g, b)));
    }
}