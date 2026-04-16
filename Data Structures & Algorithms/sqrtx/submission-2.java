class Solution {
    public int mySqrt(int x) {
        int lo = 1, hi = x;
        int res = 0;

        while(lo <= hi){
            int mid = lo + (hi-lo)/2;
            if((long) mid*mid > x) hi = mid-1;

            else if(mid*mid < x){
                lo = mid+1;
                res = mid;
            }
            else return mid;
        }

        return res;
    }
}