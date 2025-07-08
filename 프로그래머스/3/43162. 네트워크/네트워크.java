class Solution {
    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];
        int networkCount = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, visited, computers);
                networkCount++;
            }
        }

        return networkCount;
    }
    
    private void dfs(int current, boolean[] visited, int[][] computers) {
        visited[current] = true;

        for (int i = 0; i < computers.length; i++) {
            if (computers[current][i] == 1 && !visited[i]) {
                dfs(i, visited, computers);
            }
        }
    }
}