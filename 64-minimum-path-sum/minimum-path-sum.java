class Solution {
    public int minPathSum(int[][] grid) {
        int[][] dp=new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(grid,dp,0,0);
    }
    public int solve(int[][] grid, int [][] dp, int row, int col){
    if(row==dp.length-1&&col==dp[0].length-1) return grid[row][col];
     if(row>=grid.length||col>=grid[0].length) return Integer.MAX_VALUE;
     if(dp[row][col]!=-1) return dp[row][col];

     int right=solve(grid,dp,row,col+1);      
     int bottom=solve(grid,dp,row+1,col);   
     return dp[row][col]=grid[row][col]+Math.min(right,bottom);
    }
}