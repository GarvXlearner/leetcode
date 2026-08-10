class Solution {
    public int reverseBits(int n) {
        int ans=0;
        for(int i=1;i<33;i++){
            int bit=n&1;
            n=n>>1;
            ans=ans<<1;
            ans=ans|bit;

        }
        return ans;
    }
}