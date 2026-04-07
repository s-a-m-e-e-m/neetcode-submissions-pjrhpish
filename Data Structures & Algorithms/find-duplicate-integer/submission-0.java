class Solution {
    public int findDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int e : nums){
            if(set.contains(e)) return e;
            set.add(e);
        }

        return -1;
    }
}
