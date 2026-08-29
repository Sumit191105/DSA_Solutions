class Solution{
    char midChar ='$';
    int halfLen = 0;
    String result="";

    private boolean solve(StringBuilder curr, String target, int[] freq, int idx, boolean greater){
        if(curr.length()==halfLen){
            String leftHalf = curr.toString();
            String rightHalf = new StringBuilder(curr).reverse().toString();
            if(midChar!='$') leftHalf+=midChar;
            leftHalf+=rightHalf;
            if(leftHalf.compareTo(target)>0){
                result = leftHalf;
                return true;
            }
            return false;
        }
        for(char ch = 'a'; ch<='z';ch++){
            if(freq[ch-'a']==0) continue;
            if(!greater && ch < target.charAt(idx)) continue;
            curr.append(ch);
            freq[ch-'a']--;
            boolean isGreater = greater || ch>target.charAt(idx);
            if(solve(curr,target,freq,idx+1,isGreater)){
                return true;
            }
            curr.deleteCharAt(curr.length()-1);
            freq[ch-'a']++;
        }
        return false;
    }
    public String lexPalindromicPermutation(String s, String target){
        int n = s.length();
        int[] freq = new int[26];
        for(char ch : s.toCharArray()){
            freq[ch-'a']++;
        }
        int oddCount = 0;
        for(int i =0;i<26;i++){
            if(freq[i]%2==1){
                oddCount++;
                midChar=(char)('a'+i);
            }
        }
        if(oddCount>1) return "";
        halfLen = n/2;
        for(int i =0;i<26;i++){
            freq[i]/=2;
        }
        StringBuilder curr = new StringBuilder();
        solve(curr,target,freq,0,false);
        return result;
    }
    
}