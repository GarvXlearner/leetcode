class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int[][] dp= new int[matrix.length][matrix[0].length];
        for(int[] row:dp){
            Arrays.fill(row,Integer.MAX_VALUE);
        }
        int min=Integer.MAX_VALUE;
        for(int i=0;i<matrix[0].length;i++){
            min=Math.min(min,solve(matrix,dp,0,i));
        }
        return min;
    }
    public int solve(int [][] grid,int [][] dp,int row, int col){

        if (col<0||col >=grid[0].length) {
            return Integer.MAX_VALUE;
        }
        if(row==grid.length-1) return   grid[row][col];
        if (dp[row][col] != Integer.MAX_VALUE) {
            return dp[row][col];
        }

        int l=solve(grid,dp,row+1,col-1);
        int d=solve(grid,dp,row+1,col);
        int r=solve(grid,dp,row+1,col+1);
        return dp[row][col]=grid[row][col]+Math.min(Math.min(l,r),d);
    }
}