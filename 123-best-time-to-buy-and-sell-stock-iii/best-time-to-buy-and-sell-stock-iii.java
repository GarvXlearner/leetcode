class Solution {
    public int maxProfit(int[] prices) {
        int[][][] dp= new int[prices.length][2][3];
        for (int i = 0; i < prices.length; i++) {
            for (int j = 0; j < 2; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return solve(0,1,2,prices,dp);
    }
    public int solve (int ind, int par,int cap,int[] prices,int [][][] dp){
        if (cap==0) return 0;
        if(ind==prices.length) return 0;
        if(dp[ind][par][cap]!=-1) return dp[ind][par][cap];
        if(par==1){
            int buy=solve(ind+1,0,cap,prices,dp)-prices[ind];
            int notbuy=solve(ind+1,1,cap,prices,dp);
            return dp[ind][par][cap]=Math.max(buy,notbuy);
        }
        else{
            int sell=solve(ind+1,1,cap-1,prices,dp)+prices[ind];
            int notsell=solve(ind+1,0,cap,prices,dp);
            return dp[ind][par][cap]=Math.max(sell,notsell);
        }

    }
}