class Solution {
    public int solution(int[][] triangle) {
        int height = triangle.length;

        int[][] dp = new int[height][];
        for (int i = 0; i < height; i++) {
            dp[i] = triangle[i].clone();
        }

        for (int i = height - 2; i >= 0; i--) {
            for (int j = 0; j < triangle[i].length; j++) {
                dp[i][j] += Math.max(dp[i + 1][j], dp[i + 1][j + 1]);
            }
        }

        return dp[0][0];
    }
}