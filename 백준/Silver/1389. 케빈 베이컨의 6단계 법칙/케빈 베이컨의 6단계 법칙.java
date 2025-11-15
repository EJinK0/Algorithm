import java.io.*;
import java.util.*;
public class Main {
    static int N, M;
    static List<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
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

        int answerPerson = 1;
        int minSum = Integer.MAX_VALUE;

        for(int i=1;i<=N;i++) {
            int sum = bfs(i);

            if(sum < minSum) {
                minSum = sum;
                answerPerson = i;
            } else if(sum == minSum && i < answerPerson) {
                answerPerson = i;
            }
        }

        System.out.println(answerPerson);
    }

    static int bfs(int start) {
        Queue<Integer> q = new ArrayDeque<>();
        int[] dist = new int[N+1];
        Arrays.fill(dist, -1);

        dist[start] = 0;
        q.offer(start);

        while(!q.isEmpty()) {
            int cur = q.poll();
            for(int next: graph[cur]) {
                if(dist[next] != -1) continue;

                dist[next] = dist[cur] + 1;
                q.offer(next);
            }
        }

        int sum = 0;
        for(int i=1;i<=N;i++) {
            sum += dist[i];
        }

        return sum;
    }
}