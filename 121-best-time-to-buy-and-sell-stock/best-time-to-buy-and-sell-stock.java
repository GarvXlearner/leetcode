class Solution {
    public int maxProfit(int[] price) {
        int mini=price[0];
        int ans=0;
        for(int i=0;i<price.length;i++){
            int profit=price[i]-mini;
            ans=Math.max(ans,profit);
            mini=Math.min(mini,price[i]);
        }
        return ans;
        
    }
}