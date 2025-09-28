import java.io.*;
import java.util.*;

public class Main {
    static class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;
        FastScanner(InputStream is) { in = is; }
        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }
        int nextInt() throws IOException {
            int c, s = 1, x = 0;
            do { c = read(); } while (c <= ' ');         // skip spaces
            if (c == '-') { s = -1; c = read(); }
            while (c > ' ') { x = x * 10 + (c - '0'); c = read(); }
            return x * s;
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = fs.nextInt();
        int M = fs.nextInt();

        // ps[i][j] = (1,1) ~ (i,j)까지의 합  (1-indexed)
        long[][] ps = new long[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            long rowSum = 0;
            for (int j = 1; j <= N; j++) {
                int a = fs.nextInt();
                // 전형적 2D prefix: ps[i][j] = ps[i-1][j] + ps[i][j-1] - ps[i-1][j-1] + a
                ps[i][j] = ps[i - 1][j] + ps[i][j - 1] - ps[i - 1][j - 1] + a;
            }
        }

        // 질의 (x1,y1) ~ (x2,y2) 합: inclusion-exclusion
        // S = ps[x2][y2] - ps[x1-1][y2] - ps[x2][y1-1] + ps[x1-1][y1-1]
        for (int q = 0; q < M; q++) {
            int x1 = fs.nextInt();
            int y1 = fs.nextInt();
            int x2 = fs.nextInt();
            int y2 = fs.nextInt();
            long ans = ps[x2][y2] - ps[x1 - 1][y2] - ps[x2][y1 - 1] + ps[x1 - 1][y1 - 1];
            sb.append(ans).append('\n');
        }

        System.out.print(sb.toString());
    }
}