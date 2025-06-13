import java.io.*;
import java.util.*;

public class Main {
	static int Node, Line, StartNode;
	static List<Integer>[] grapth;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Node = Integer.parseInt(st.nextToken());
		Line = Integer.parseInt(st.nextToken());
		StartNode = Integer.parseInt(st.nextToken());

		// 1번부터 쓰는이유는 (1 ≤ N ≤ 1,000)라서
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
        
		// dfs
		visited = new boolean[Node + 1];
		dfs(StartNode);
		sb.append('\n');

		// bfs
		visited = new boolean[Node + 1];
		bfs(StartNode);
        
        System.out.print(sb);
	}

	static void dfs(int startNode) {
		visited[startNode] = true;
		sb.append(startNode).append(' ');
		for(int w: grapth[startNode]) {
			if(!visited[w]) {
				dfs(w);
			} else {}
		}
	}

	static void bfs(int startNode) {
		Queue<Integer> queue = new ArrayDeque<>();
		visited[startNode] = true;
		queue.offer(startNode);

		while(!queue.isEmpty()) {
			int u = queue.poll();
			sb.append(u).append(' ');
			for(int v: grapth[u]) {
				if(!visited[v]) {
					visited[v] = true;
					queue.offer(v);
				}
			}
		}

	}
}