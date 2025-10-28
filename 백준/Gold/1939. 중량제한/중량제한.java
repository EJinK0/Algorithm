import java.io.*;
import java.util.*;

public class Main {
    // 빠른 입력
    static class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;
        FastScanner(InputStream is) { in = is; }
        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len < 0) return -1;
            }
            return buffer[ptr++];
        }
        int nextInt() throws IOException {
            int c, s = 1, v = 0;
            do { c = read(); } while (c <= ' ');
            if (c == '-') { s = -1; c = read(); }
            while (c > ' ') { v = v * 10 + (c - '0'); c = read(); }
            return v * s;
        }
    }

    static class Edge {
        int to, w;
        Edge(int to, int w) { this.to = to; this.w = w; }
    }

    static int N, M;
    static List<Edge>[] g;
    static int start, end;
    static int maxW = 0;

    static boolean canCarry(int weight) {
        // weight 이상인 간선만 사용해서 start->end 도달 가능한가?
        boolean[] vis = new boolean[N + 1];
        ArrayDeque<Integer> q = new ArrayDeque<>();
        vis[start] = true;
        q.add(start);

        while (!q.isEmpty()) {
            int u = q.poll();
            if (u == end) return true;
            for (Edge e : g[u]) {
                if (!vis[e.to] && e.w >= weight) {
                    vis[e.to] = true;
                    q.add(e.to);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        N = fs.nextInt();      // 섬 개수
        M = fs.nextInt();      // 다리 개수

        g = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) g[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            int a = fs.nextInt();
            int b = fs.nextInt();
            int w = fs.nextInt();
            g[a].add(new Edge(b, w));
            g[b].add(new Edge(a, w));
            if (w > maxW) maxW = w;
        }

        start = fs.nextInt();
        end   = fs.nextInt();

        int lo = 1, hi = maxW, ans = 0;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2; // 후보 중량
            if (canCarry(mid)) {          // mid 무게 가능 → 더 무겁게
                ans = mid;
                lo = mid + 1;
            } else {                      // 불가능 → 더 가볍게
                hi = mid - 1;
            }
        }
        System.out.println(ans);
    }
}