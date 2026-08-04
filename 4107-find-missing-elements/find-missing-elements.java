class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        ArrayList<Integer> res= new ArrayList<>();
         HashSet<Integer> set= new HashSet<>();
        int min=nums[0];
        int max=nums[0];
        set.add(nums[0]);
       
        for(int i=1;i<nums.length;i++){
            set.add(nums[i]);
            if(nums[i]>max) max=nums[i];
            if(nums[i]<min) min=nums[i];
        }
        for(int i=min;i<max;i++){
            if(!set.contains(i)) res.add(i);
        }
        
        return res;
        
    }
}