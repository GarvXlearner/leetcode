class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp= new int[coins.length][amount+1];
        for(int amt=0;amt<=amount;amt++){
            if (amt % coins[0] == 0) {
                 dp[0][amt]= amt / coins[0]; } 
                 else { dp[0][amt]= Integer.MAX_VALUE; }
        }

        for(int ind=1;ind<coins.length;ind++){
            for(int amt=0;amt<=amount;amt++){
                int  nottake=dp[ind-1][amt];
                int take=Integer.MAX_VALUE;
                if(amt>=coins[ind]){
                    take=dp[ind][amt-coins[ind]];
                    if (take != Integer.MAX_VALUE) {
                        take++;
                    }
                }
                dp[ind][amt] = Math.min(take, nottake);
            }
        }
        int ans = dp[coins.length - 1][amount];

        return ans == Integer.MAX_VALUE ? -1 : ans;

     }
}