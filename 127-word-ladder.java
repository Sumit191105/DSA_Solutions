class Pair{
    String first;
    int second;
    Pair(String _first, int _second){
        this.first = _first;
        this.second = _second;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<String>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord,1));
        for(String str: wordList){
            set.add(str);
        }
        set.remove(beginWord);
        while(!q.isEmpty()){
            String word = q.peek().first;
            int level = q.peek().second;
            q.remove();
            if(word.equals(endWord)==true ) return level;
            for(int i =0;i<word.length();i++){
                for(char ch = 'a';ch<='z';ch++){
                    char replacedWord[] = word.toCharArray();
                    replacedWord[i]=ch;
                    String newWord = new String(replacedWord);
                    if(set.contains(newWord)==true){
                        set.remove(newWord);
                        q.add(new Pair(newWord,level+1));
                    }
                }
            }
        } 
        return 0;
    }
}
// Time Complexity : O(NXL^2) N = Number of words L = length of each word creating string takes O(L) and change every one of the character 26xL
// also acces each element once n times 
