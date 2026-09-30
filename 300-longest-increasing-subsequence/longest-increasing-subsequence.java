class Solution {
    public int lengthOfLIS(int[] nums) {
        int [][] dp= new int[nums.length][nums.length+1];
        for(int i=0;i<nums.length;i++) Arrays.fill(dp[i],-1);
        return solve(0, -1, nums,dp);
    }

    public int solve(int ind, int prevIndex, int[] nums,int[][] dp) {
        if (ind == nums.length) return 0;
        if (dp[ind][prevIndex+1]!=-1) return dp[ind][prevIndex+1];
        int nottake = solve(ind +1,prevIndex, nums,dp);  
        int take = 0;
        if (prevIndex == -1 || nums[ind] > nums[prevIndex]) {
            take = 1 + solve(ind + 1, ind, nums,dp);
        }

        return dp[ind][prevIndex+1] =Math.max(nottake, take);
    }
}