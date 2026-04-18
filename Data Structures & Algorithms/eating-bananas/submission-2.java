class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int lo = 0, hi = Integer.MIN_VALUE;
        for(int p : piles) hi = Math.max(hi, p);
        int res = hi;

        while(lo <= hi){
            int k = lo + (hi-lo)/2;
            long totalTime = 0;

            for(int p : piles)
                totalTime += (int) Math.ceil((double) p/k);

            if(totalTime <= h){
                res = k;
                hi = k-1;
            }
            else lo = k+1;
        }

        return res;
    }
}
