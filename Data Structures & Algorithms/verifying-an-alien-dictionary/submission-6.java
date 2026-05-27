class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0;i<order.length();i++){
            char ch = order.charAt(i);
            map.put(ch, i);
        }

        for(int i=1;i<words.length;i++){
            String prev = words[i-1], curr = words[i];
            int minLen = Math.min(prev.length(), curr.length());
            boolean foundMismatch = false;

            for(int j=0;j<minLen;j++){
                char prevChar = prev.charAt(j), currChar = curr.charAt(j);

                if(prevChar != currChar){
                    if(map.get(prevChar) > map.get(currChar)) return false;

                    foundMismatch = true;
                    break;
                }
            }

            if(!foundMismatch && curr.length()<prev.length()){
                return false;
            }
        }

        return true;
    }
}