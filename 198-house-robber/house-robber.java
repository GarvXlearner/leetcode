class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,-1);
        return solve(dp,nums,nums.length-1);
    }
    public int solve(int[] dp, int[] nums, int n){
        if(n==0) return nums[n];
        if(n<0) return 0;
        if(dp[n]!=-1) return dp[n];
        
        int ThisOne=nums[n]+solve(dp,nums,n-2);
        int NotThisOne=solve(dp,nums,n-1);
        return dp[n]=Math.max(ThisOne,NotThisOne);
    }
}