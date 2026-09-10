class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] arr_r= new int [arr.length];
        arr_r[0]=arr[0];
        for(int i=1;i<arr.length;i++){
            arr_r[i]=arr_r[i-1]^arr[i];
        }
        int[] ans=new int[queries.length]; 
        for(int i=0;i<queries.length;i++){
            int j=queries[i][0];
            int k=queries[i][1];
            if(j==0) ans[i]=arr_r[k];
            else ans[i]= arr_r[k]^arr_r[j-1];

           
        }
        return ans;
        
    }
}