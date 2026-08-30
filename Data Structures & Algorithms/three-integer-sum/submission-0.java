class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(i> 0 && nums[i] == nums[i-1] ){
                continue;
            }
            int l = i+1;
            int r = nums.length-1;
            int sum = nums[i];

            while(l < r){
                if(sum + (nums[l] + nums[r]) == 0){
                    result.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    l= l+1;
                    while(nums[l] == nums[l-1] && l < r){
                        l++;
                    }
                }else if (sum + nums[l] + nums[r] > 0){
                    r--;
                }else{
                    l++;
                }
            }
        }
        return result;
    }
}
