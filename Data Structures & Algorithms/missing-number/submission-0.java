class Solution {
    public int missingNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int e : nums) {
            set.add(e); 
        }
        int n = nums.length;
        for(int i=0;i<=n;i++) {
            if(!set.contains(i)) return i;
        }
        return -1;
    }
}
