class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount + 1];

        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        int ans = solve(dp, coins, coins.length - 1, amount);

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public int solve(int[][] dp, int[] coins, int ind, int amt) {

        if (ind == 0) {
            if (amt % coins[0] == 0) {
                return amt / coins[0];
            } else {
                return Integer.MAX_VALUE;
            }
        }

        if (dp[ind][amt] != -1) {
            return dp[ind][amt];
        }

        int notTake = solve(dp, coins, ind - 1, amt);

        int take = Integer.MAX_VALUE;

        if (amt >= coins[ind]) {
            take = solve(dp, coins, ind, amt - coins[ind]);

            if (take != Integer.MAX_VALUE) {
                take = take + 1;
            }
        }

        return dp[ind][amt] = Math.min(take, notTake);
    }
}