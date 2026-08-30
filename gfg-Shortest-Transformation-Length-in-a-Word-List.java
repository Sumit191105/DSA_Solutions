class Node{
    String first;
    int second;
    Node(String _first,int _second){
        this.first = _first;
        this.second = _second;
    }
}

class Solution {
    public int wordLadder(String[] words, String s, String e) {
        int n = words.length;
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(s,1));
        Set<String> set = new HashSet<>();
        for(String str : words){
            set.add(str);
        }
        set.remove(s);
        
        while(!q.isEmpty()){
            String word = q.peek().first;
            int level = q.peek().second;
            q.remove();
            if(word.equals(e)==true) return level;
            for(int i =0 ;i<word.length();i++){
                for(char ch ='a';ch<='z';ch++){
                    char replacedString[] = word.toCharArray();
                    replacedString[i] = ch;
                    String newWord = new String(replacedString);
                    if(set.contains(newWord)==true){
                        set.remove(newWord);
                        q.add(new Node(newWord,level+1));
                    }
                }
            }
        }
        return 0;
    }
}