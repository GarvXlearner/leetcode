class Solution {
    public int longestSubsequence(int[] nums) {
        int xored=0;
        boolean allzero=true;
        for(int i=0;i<nums.length;i++)  {
            if(nums[i]!=0) allzero=false;
            xored^=nums[i];}

        if(xored!=0) return nums.length;

        if(allzero) return 0;
        
           

        
    return nums.length-1;
    }
}