package leetcode_problem_279_perfect_square_DP;

public class bottomup_dp {
    public int numSquare(int n){
        int[] dp = new int[n+1];
        dp[0] = 0;
        for (int i= 1;i<=n;i++){
            dp[i] = i;
            for (int j=1;j*j <= i; j++){
                int curr = 1 + dp[i-j*j];
                dp[i] = Math.min(dp[i], curr);
            }
        }
        return dp[n];
    }
}
