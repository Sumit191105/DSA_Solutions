class Solution {
    public int maximumLengthSubstring(String s){
        Deque<Character> q = new ArrayDeque<>();
        HashMap<Character,Integer> map = new HashMap<>();
        int max=0;
        for(char ch: s.toCharArray()){
            while(map.getOrDefault(ch,0)>=2){
                char removed = q.pollFirst();
                map.put(removed,map.get(removed)-1);
            }
            map.put(ch,map.getOrDefault(ch,0)+1);
            q.offer(ch);
            max = Math.max(max,q.size());
        }
        return max;
    }    
}
