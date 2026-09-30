class Solution {
    public int numDecodings(String s) {
        int[] dp= new int[s.length()];
        Arrays.fill(dp, -1);
        return solve(0,s,dp);
    }
    public int solve(int ind, String s,int[] dp){
        if(ind>=s.length()) return 1;

        if(s.charAt(ind)=='0') return 0;
        if(dp[ind]!=-1) return dp[ind];

        int ways=solve(ind+1,s,dp);
        if(ind+1<s.length())
        {
            int num = Integer.parseInt(s.substring(ind, ind + 2));
            if(num>=10&&num<=26)  ways=ways+solve(ind+2,s,dp);
        }
        return dp[ind]= ways;
    }
}

