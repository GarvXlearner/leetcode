class Solution {
    public int maxDepth(String s) {
        int ans=0;
       int  nesdep=0;
        for(int i=0;i<s.length();i++){
            
            if(s.charAt(i)=='(') nesdep++;
            else if(s.charAt(i)==')'){
                ans=Math.max(ans,nesdep);
                 nesdep--;
            }

            
        }
        return ans;
        
    }
}