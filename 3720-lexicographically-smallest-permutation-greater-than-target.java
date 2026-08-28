
class Solution{

    String result = "";
    private boolean solve(String s, String target, int[] count, StringBuilder curr , int idx , boolean greater){
        if(idx==target.length()){
            if(greater){
                result = curr.toString();
                return true;
            }
            return false;
        }
        for(char ch='a' ; ch<='z' ; ch++){
            if(count[ch-'a']==0) continue;
            if(!greater && ch<target.charAt(idx)) continue;
            //Do
            curr.append(ch);
            count[ch-'a']--;
            boolean isGreater = greater || ch>target.charAt(idx);
            //explore
            if(solve(s,target,count,curr,idx+1,isGreater)) return true;
            //undo
            curr.deleteCharAt(curr.length()-1);
            count[ch-'a']++;
        }
        return false;
    }
    public String lexGreaterPermutation(String s, String target) {
        int[] count = new int[26];
        for(char ch : s.toCharArray()){
            count[ch-'a']++;
        }
        StringBuilder curr = new StringBuilder();
        solve(s,target,count,curr,0,false);
        return result;
    }
}