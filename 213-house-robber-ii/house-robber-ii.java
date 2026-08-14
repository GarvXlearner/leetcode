class Solution {
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        int[] arr1= new int[nums.length-1];
        int[] arr2= new int[nums.length-1];
        for(int i=0;i<arr1.length;i++){
            arr1[i]=nums[i];
        }
        for(int i=0;i<arr2.length;i++){
            arr2[i]=nums[i+1];
        }
        int[] dp=new int[nums.length-1];
        Arrays.fill(dp,-1);
        int m=solve(dp,arr1,nums.length-2);
        Arrays.fill(dp,-1);
       int n= solve(dp,arr2,nums.length-2);
       return Math.max(m,n);
        
    }
    public int solve(int[] dp, int[] nums,int n){
        if(n<0) return 0;
        if(n==0) return nums[0];
        if(dp[n]!=-1) return dp[n];

        int ThisOne=nums[n]+solve(dp,nums,n-2);
        int NotThisOne=solve(dp,nums,n-1);
        return dp[n]=Math.max(ThisOne,NotThisOne);
    }
}