class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        if(obstacleGrid[m-1][n-1]==1) return 0;
        int[][] dp=new int[m][n];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        
        return solve(dp, obstacleGrid,0,0);
    }
    public int solve(int[][] dp, int [][] grid, int row, int col){
        if(row==grid.length-1&&col==grid[0].length-1) return 1;
        if(row>=grid.length||col>=grid[0].length) return 0;
        if(grid[row][col]==1) return 0;
        if(dp[row][col]!=-1) return dp[row][col];
        

        int right=solve(dp,grid,row,col+1);
         int bottom=solve(dp,grid,row+1,col);
         return dp[row][col]=right+bottom;
    }
}