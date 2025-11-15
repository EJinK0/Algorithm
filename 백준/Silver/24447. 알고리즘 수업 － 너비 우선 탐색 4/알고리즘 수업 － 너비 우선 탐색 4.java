import java.io.*;
import java.util.*;
public class Main {
    static int N, M, R;
    static List<Integer>[] graph;
    static int[] depth;

    static int[] order;
    static int cnt=0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        depth = new int[N+1];
        order = new int[N+1];

        for(int i=1;i<=N;i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        for(int i=1;i<=N;i++) {
            Collections.sort(graph[i]);
        }

        Arrays.fill(depth, -1);

        bfs(R);

        long sum = 0;
        for(int i=1;i<=N;i++) {
            if(depth[i] != -1) {
                sum += (long)depth[i] * order[i];
            }
        }

        System.out.println(sum);
    }

    static void bfs(int start) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);
        depth[start] = 0;
        order[start] = ++cnt;

        while(!q.isEmpty()) {
            int cur = q.poll();
            for(int next: graph[cur]) {
                if(depth[next] != -1) continue;

                depth[next] = depth[cur] + 1;
                order[next] = ++cnt;
                q.offer(next);
            }
        }
    }
}