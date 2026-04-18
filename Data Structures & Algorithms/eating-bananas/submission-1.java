class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxPile = Integer.MIN_VALUE;
        for(int e : piles) maxPile = Math.max(maxPile, e);
        int lo = 1, hi = maxPile;
        int res = hi;

        while(lo <= hi){
            long totalTime = 0;
            int k = lo + (hi-lo)/2;
            for(int pile : piles) 
                totalTime += (int) Math.ceil((double) pile/k);

            if(totalTime <= h) {
                res = k;
                hi = k-1;
            }

            else lo = k+1;
        }

        return res;
    }
}
