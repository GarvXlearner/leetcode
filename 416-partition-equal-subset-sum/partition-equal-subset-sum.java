class Solution {
    public boolean canPartition(int[] nums) {
       
        int sum=0;
        for(int i=0;i<nums.length;i++) sum+=nums[i];
        if(sum%2!=0) return false;
        int rem=sum/2;
         Boolean[][] dp = new Boolean[nums.length][rem + 1];
          return solve(nums,dp,nums.length-1,rem);
    }
    public boolean solve(int[] nums,Boolean[][] dp, int idx, int rem){
         if(rem==0) return true;
       
       
        if(idx==0&&rem!=0) return false;
        if(dp[idx][rem] != null) return dp[idx][rem];
         if(nums[idx]>rem) return dp[idx][rem] = solve(nums,dp,idx -1,rem);

        boolean take=solve(nums,dp,idx-1,rem-nums[idx]);
        boolean nottake=solve(nums,dp,idx-1,rem);
        return dp[idx][rem]=take|nottake;

    }
}