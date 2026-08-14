class Solution {
    public int uniquePaths(int m, int n) {
        int [][] grid= new int[m][n];
         int [][] dp= new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                grid[i][j]=0;
            }
        }
         for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=-1;
            }
        }
        return solve(0,0,grid,dp);
        
    }
    public int solve(int row, int col, int[][] grid, int[][] dp){
         if(row==grid.length-1&&col==grid[0].length-1) return 1;
         if(row>=grid.length||col>=grid[0].length) return 0;
         if(dp[row][col]!=-1) return dp[row][col];

         int goright=solve(row,col+1,grid,dp);
         int goleft=solve(row+1,col,grid,dp);
         return dp[row][col]=goleft+goright;
    }
}