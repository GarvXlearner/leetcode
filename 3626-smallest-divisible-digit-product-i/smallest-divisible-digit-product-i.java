class Solution {
    public int smallestNumber(int n, int t) {
        while(true){
            if(pod(n)%t==0) return n;
            else n++;
        }
        
    }
    public int pod(int n){
        int pro=1;
        while(n>0){
            pro=pro*(n%10);
            n/=10;
        }

        return pro;
    }
}