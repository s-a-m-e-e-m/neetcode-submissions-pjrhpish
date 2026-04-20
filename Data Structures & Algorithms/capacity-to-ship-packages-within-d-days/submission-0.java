class Solution {
    public int shipWithinDays(int[] weights, int days) {
    int lo = 0, hi = 0;
    for (int w : weights) {
        lo = Math.max(lo, w);
        hi += w;
    }
    int res = hi;

    while (lo <= hi) {
        int mid = lo + (hi - lo) / 2;
        if (canShip(weights, days, mid)) {
            res = mid;
            hi = mid - 1;
        } else {
            lo = mid + 1;
        }
    }
    return res;
}

private boolean canShip(int[] weights, int days, int cap) {
    int usedDays = 1, curr = 0;
    for (int w : weights) {
        if (curr + w > cap) {
            usedDays++;
            curr = 0;
        }
        curr += w;
    }
    return usedDays <= days;
}

}