class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        int prod = 1;
        for(int i=0;i<n;i++){
            prefix[i] = prod;
            prod *= nums[i];
        }

        int[] suffix = new int[n];
        prod = 1;
        for(int i=n-1;i>=0;i--){
            suffix[i] = prod;
            prod *= nums[i];
        }

        // for(int i=0;i<n;i++) System.out.print(prefix[i] + " ");
        // System.out.println();
        // for(int i=0;i<n;i++) System.out.print(suffix[i] + " ");

        for(int i=0;i<n;i++) prefix[i] *= suffix[i];

        return prefix;
    }
}  
