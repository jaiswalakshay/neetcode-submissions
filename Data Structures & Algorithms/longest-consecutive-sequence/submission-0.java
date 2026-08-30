class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int i : nums){
            set.add(i);
        }
        int maxlength = 0;
        for(int i=0;i<nums.length;i++){           
            int num = nums[i];
                
            int length = 0;

            if(!set.contains(nums[i] - 1)){
                while(set.contains(num)){
                    num++;
                    length++;
                }
                maxlength = Integer.max(length, maxlength);
            }
        }
        return maxlength;
    }
}
