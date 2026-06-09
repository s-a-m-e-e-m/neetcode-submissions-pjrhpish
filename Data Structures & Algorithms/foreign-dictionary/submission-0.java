class Solution {
    public String foreignDictionary(String[] words) {
        Map<Character, Set<Character>> adj = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();

        for (String word : words) {
            for (char c : word.toCharArray()) {
                adj.putIfAbsent(c, new HashSet<>());
                indegree.putIfAbsent(c, 0);
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i], w2 = words[i + 1];
            int minLen = Math.min(w1.length(), w2.length());

            if (w1.length() > w2.length()
                && w1.substring(0, minLen).equals(w2.substring(0, minLen)))
                return "";

            for (int j = 0; j < minLen; j++) {
                if (w1.charAt(j) != w2.charAt(j)) {
                    char ch1 = w1.charAt(j), ch2 = w2.charAt(j);
                    if (!adj.get(ch1).contains(ch2)) {
                        adj.get(ch1).add(ch2);
                        indegree.put(ch2, indegree.get(ch2) + 1);
                    }
                    break;
                }
            }
        }

        Queue<Character> q = new LinkedList<>();
        for(char c : indegree.keySet()){
            if(indegree.get(c)==0) q.offer(c);
        }

        StringBuilder res = new StringBuilder();
        while(!q.isEmpty()){
            char ch = q.poll();
            res.append(ch);
            for(char neigh : adj.get(ch)){
                indegree.put(neigh, indegree.get(neigh)-1);
                if(indegree.get(neigh)==0) q.offer(neigh);
            }
        
        }
        if(res.length() != indegree.size()) return "";

        return res.toString();
    }
}
