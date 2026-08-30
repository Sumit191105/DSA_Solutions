class Solution {
    public ArrayList<ArrayList<String>> findSequences(String[] words, String s,
                                                      String e) {
        int n = words.length;
        Set<String> set = new HashSet<>();
        for(String str: words){
            set.add(str);
        }
        Queue<ArrayList<String>> q = new LinkedList<>();
        ArrayList<String> temp = new ArrayList<>();
        temp.add(s);
        q.add(temp);
        ArrayList<String> onLevel = new ArrayList<>();
        onLevel.add(s);
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        int level =0;
        while(!q.isEmpty()){
            ArrayList<String> top = q.peek();
            q.remove();
            if(top.size()>level){
                level++;
                for(String str: onLevel){
                    set.remove(str);
                }
            }
            String word = top.get(top.size()-1);
            if(word.equals(e)==true){
                if(res.isEmpty() || res.get(0).size()==top.size()) res.add(top);
            }
            for(int i =0;i<word.length();i++){
                for(char ch = 'a' ; ch<='z';ch++){
                    char newCharArray[] = word.toCharArray();
                    newCharArray[i] = ch;
                    String newWord = new String(newCharArray);
                    if(set.contains(newWord)==true){
                        top.add(newWord);
                        ArrayList<String> tem = new ArrayList<>(top);
                        q.add(tem);
                        onLevel.add(newWord);
                        top.remove(top.size()-1);
                    }
                }
            }
        }
        return res;
    }
}