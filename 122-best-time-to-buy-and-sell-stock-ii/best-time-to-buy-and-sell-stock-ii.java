class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp= new int[prices.length][2];
        for(int i=0;i<dp.length;i++) Arrays.fill(dp[i],-1);
        return solve(0,1,prices,dp);
    }
    public int solve (int ind, int par,int[] prices,int [][] dp){
        if(ind==prices.length) return 0;
        if(dp[ind][par]!=-1) return dp[ind][par];
        if(par==1){
            int buy=solve(ind+1,0,prices,dp)-prices[ind];
            int notbuy=solve(ind+1,1,prices,dp);
            return dp[ind][par]=Math.max(buy,notbuy);
        }
        else{
            int sell=solve(ind+1,1,prices,dp)+prices[ind];
            int notsell=solve(ind+1,0,prices,dp);
            return dp[ind][par]=Math.max(sell,notsell);
        }

    }
}