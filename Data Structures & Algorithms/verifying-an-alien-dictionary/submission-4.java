class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0;i<order.length();i++){
            char ch = order.charAt(i);
            map.put(ch, i);
        }

        for(int i=1;i<words.length;i++){
            String curr = words[i], prev = words[i-1];
            int minLen = Math.min(curr.length(), prev.length());
            boolean foundMismatch = false;
            for(int j=0;j<minLen;j++){
                char prevChar = prev.charAt(j), currChar = curr.charAt(j);

                if(prevChar != currChar){
                    if(map.get(prevChar) > map.get(currChar)) return false;

                    foundMismatch = true;
                    break;
                }
            }

            if(!foundMismatch && prev.length()>curr.length()){
                return false;          // e.g apple before app
            }
        }

        return true;
    }
}