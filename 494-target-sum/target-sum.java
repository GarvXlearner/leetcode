class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum=0;
       for(int i=0;i<nums.length;i++){
        sum+=nums[i];
       }
       int[][] dp= new int [nums.length][2*sum+1];
       for(int i=0;i<dp.length;i++){
        Arrays.fill(dp[i],-1);
       }

       return solve(nums,dp,0,target,nums.length-1,sum);
    }
    public int solve(int[] nums,int [][]dp,int now, int target,int ind,int sum){
      if(ind<0){
        return now==target?1:0;
      }
        if(dp[ind][now+sum]!=-1) return dp[ind][now+sum];
        int add=solve(nums,dp,now+nums[ind],target,ind-1,sum);
        int sub=solve(nums,dp,now-nums[ind],target,ind-1,sum);
        return dp[ind][now+sum]=add+sub;
    }
}