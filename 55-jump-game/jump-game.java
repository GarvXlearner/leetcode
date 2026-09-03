class Solution {
    public boolean canJump(int[] nums) {
        Boolean[] dp = new Boolean[nums.length];
        return solve(nums, 0, dp);
    }

    private boolean solve(int[] nums, int ind, Boolean[] dp) {
        if (ind == nums.length - 1) {
            return true;
        }

        if (dp[ind] != null) {
            return dp[ind];
        }

        for (int i = ind + 1; i <= ind + nums[ind] && i < nums.length; i++) {
            if (solve(nums, i, dp)) {
                return dp[ind] = true;
            }
        }

        return dp[ind] = false;
    }
}