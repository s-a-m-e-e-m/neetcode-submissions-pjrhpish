class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        int n = nums.length;

        for(int i=0;i<nums.length-k;i++){
            int maxEle = Integer.MIN_VALUE;
            for(int j=i;j<i+k;j++){
                maxEle = Math.max(maxEle, nums[j]);
            }
            list.add(maxEle);
        }

        int maxEle = Integer.MIN_VALUE;
        for(int i=n-1;i>=n-k;i--){
            maxEle = Math.max(maxEle, nums[i]);
        }
        list.add(maxEle); 

        int[] res = new int[list.size()];
        for(int i=0;i<res.length;i++){
            res[i] = list.get(i);
        }

        return res;
    }
}
