import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer>[] graph = new ArrayList[N+1];
        for(int i=1;i<=N;i++) {
            graph[i] = new ArrayList<>();
        }

        int[] indegree = new int[N+1];
        int[] semester = new int[N+1];

        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            indegree[b]++;
        }

        Queue<Integer> q = new ArrayDeque<>();
        for(int i=1;i<=N;i++) {
            if(indegree[i] == 0) {
                q.offer(i);
                semester[i] = 1;
            }
        }

        while(!q.isEmpty()) {
            int cur = q.poll();
            for(int next: graph[cur]) {
                indegree[next]--;
                semester[next] = Math.max(semester[next], semester[cur]+1);

                if(indegree[next] == 0) {
                    q.offer(next);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=N;i++) {
            sb.append(semester[i]).append(' ');
        }

        System.out.println(sb);
    }
}
