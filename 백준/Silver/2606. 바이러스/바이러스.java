import java.io.*;
import java.util.*;

public class Main {
    static int Node, Line;
    static int virustNode = 1;
    static List<Integer>[] grapth;
    static boolean[] visited;
    static Integer count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Node = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Line = Integer.parseInt(st.nextToken());

        // 1번부터 쓰는이유는 (1 ≤ N ≤ 100)라서
        // 노드의 갯수만큼 초기화
        grapth = new ArrayList[Node + 1];
        for(int i = 1; i <= Node; i++) {
            grapth[i] = new ArrayList<>();
        }

        // 간선 입력
        for(int i = 1; i <= Line; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            grapth[u].add(v);
            grapth[v].add(u);
        }
        
        // 인접 리스트 정렬
        for(int i = 1; i <= Node; i++) {
            Collections.sort(grapth[i]);
        }
        visited = new boolean[Node + 1];
        dfs(virustNode);

        System.out.println(count - 1);
    }

    static void dfs(int startNode) {
        visited[startNode] = true;
        count++;

        for(int w: grapth[startNode]) {
            if(!visited[w]) {
                dfs(w);
            } else {}
        }
    }
}