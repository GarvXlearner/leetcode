class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp= new int[coins.length][amount+1];
        for(int t=0;t<=amount;t++){
            if(t%coins[0]==0) dp[0][t]=1;
        }
        for(int ind=1;ind<coins.length;ind++){
            for(int t=0;t<=amount;t++){
                int nottake=dp[ind-1][t];
                int take=0;
                if(coins[ind]<=t){
                    take=dp[ind][t-coins[ind]];
                }
                dp[ind][t]=take+nottake;
            }
        }
        return dp[coins.length-1][amount];
        
    }
}