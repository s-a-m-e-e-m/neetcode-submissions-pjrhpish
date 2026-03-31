class Solution {
    public String minWindow(String s, String t) {
        if(t.length()==0) return "";

        Map<Character, Integer> tmap = new HashMap<>();
        Map<Character, Integer> wmap = new HashMap<>();

        for(int i=0;i<t.length();i++){
            char ch = t.charAt(i);
            tmap.put(ch, tmap.getOrDefault(ch, 0)+1);
        }

        int have = 0, need = tmap.size();
        int[] res = {-1, -1};
        int resLen = Integer.MAX_VALUE;
        int l = 0;

        for(int r=0;r<s.length();r++){
            char ch = s.charAt(r);
            wmap.put(ch, wmap.getOrDefault(ch, 0)+1);
            if(tmap.containsKey(ch) && wmap.get(ch).equals(tmap.get(ch)))
                have++;

            while(have==need){
                if(r-l+1 < resLen){
                    resLen = r-l+1;
                    res[0] = l;
                    res[1] = r;
                } 

                char left = s.charAt(l);
                wmap.put(left, wmap.get(left)-1);

                if(tmap.containsKey(left) && wmap.get(left) < tmap.get(left))
                    have--;

                l++;
            }    
        }

        return resLen == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1]+1);
    }
}
