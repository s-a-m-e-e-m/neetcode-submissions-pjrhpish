class Solution {
    public int findDuplicate(int[] nums) {
        // using O(1) extra space
        int n = nums.length;
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                if(nums[i]==nums[j]) return nums[i];
            }
        }

        return -1;
    }
}
