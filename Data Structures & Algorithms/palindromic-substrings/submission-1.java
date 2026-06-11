class Solution {
    public int countSubstrings(String s) {
        int res = 0, n = s.length();

        for(int i=0;i<n;i++){
            // odd length
            int l = i, r = i;
            while(l>=0 && r<n && s.charAt(l)==s.charAt(r)){
                res += 1;
                l -= 1;
                r += 1;
            }

            // even length
            l = i; r = i+1;
            while(l>=0 && r<n && s.charAt(l)==s.charAt(r)){
                res += 1;
                l -= 1;
                r += 1;
            }
        }

        return res;
    }
}
