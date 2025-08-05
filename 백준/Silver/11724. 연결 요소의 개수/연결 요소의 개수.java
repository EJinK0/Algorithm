import java.io.*;
import java.util.*;
public class Main {
    static int N, M;
    static List<Integer>[] adj;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N+1];
        visited = new boolean[N+1];

        for(int i=1;i<=N;i++) {
            adj[i] = new ArrayList<>();
        }

        for(int i=0 ; i<M ; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj[n].add(v);
            adj[v].add(n);
        }

        int cc = 0;
        for(int i=1;i<=N;i++) {
            if(!visited[i]) {
                dfs(i);
                cc++;
            }
        }

        System.out.println(cc);
    }

    public static void dfs(int node) {
        visited[node] = true;
        for(int nxt: adj[node]) {
            if(!visited[nxt]) {
                dfs(nxt);
            }
        }
    }
}
