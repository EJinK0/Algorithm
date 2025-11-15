import java.io.*;
import java.util.*;
public class Main {
    static int N, M, R;
    static List<Integer>[] graph;
    static boolean[] visited;
    static int[] order;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        visited = new boolean[N+1];
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

        bfs(R);

        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=N;i++) {
            sb.append(order[i]).append('\n');
        }

        System.out.println(sb);
    }

    static void bfs(int start) {
        Queue<Integer> q = new ArrayDeque<>();
        visited[start] = true;
        order[start] = ++cnt;
        q.offer(start);

        while(!q.isEmpty()) {
            int cur = q.poll();
            for(int next: graph[cur]) {
                if(!visited[next]) {
                    visited[next] = true;
                    order[next] = ++cnt;
                    q.offer(next);
                }
            }
        }
    }
}