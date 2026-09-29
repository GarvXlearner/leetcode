
class Solution {
    public long maximumProfit(int[] prices,int k) {
        long[][][] dp= new long[prices.length][3][k+1];
        for (int i = 0; i < prices.length; i++) {
            for (int j = 0; j < 3; j++) {
                Arrays.fill(dp[i][j], Long.MIN_VALUE);
            }
        }
        return solve(0,0,k,prices,dp);
    }
    public long solve (int ind, int par,int cap,int[] prices,long [][][] dp){
         if (cap == 0) return par == 0 ? 0 : Long.MIN_VALUE / 4;
        if (ind == prices.length) return par == 0 ? 0 : Long.MIN_VALUE / 4;
        if (dp[ind][par][cap] != Long.MIN_VALUE) return dp[ind][par][cap];
        if(par==0){
            long buy=solve(ind+1,1,cap,prices,dp)-prices[ind];
            long shortsell=solve(ind+1,2,cap,prices,dp)+prices[ind];
            long Fivestar= solve(ind+1,0,cap,prices,dp);
            return dp[ind][par][cap]=Math.max(Fivestar,Math.max(buy,shortsell));

        }
        else if(par==1){
            long sell=solve(ind+1,0,cap-1,prices,dp)+prices[ind];
            long notsell=solve(ind+1,1,cap,prices,dp);
           
            return dp[ind][par][cap]=Math.max(sell,notsell);
        }
        else {

            
            long buyBack =solve(ind+1,0,cap-1,prices,dp) - prices[ind];

          
            long holdShort = solve(ind+1,2,cap,prices,dp);

            return dp[ind][par][cap] = Math.max(buyBack,holdShort);

        }

    }
}