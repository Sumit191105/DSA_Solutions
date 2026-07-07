class Solution {
    public long sumAndMultiply(int n){
        String str = String.valueOf(n);
        String ans ="";
        int sum = 0;
        for(char ch: str.toCharArray()){
            if(ch != '0'){
                ans+=ch;
                sum+=ch-'0';
            }
        }
        if(ans.length()==0) return 0;
        int ans1 = Integer.parseInt(ans);
        return (long)ans1*sum;
    }
    
}
