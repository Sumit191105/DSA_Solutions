class Solution{
    public int longestSubsequence(int[] nums){
        int n = nums.length;
        int resultXor = 0;
        boolean isAllZero = true;
        for(int i: nums){
            resultXor = resultXor^i;
            if(i!=0) isAllZero = false;
        }
        if(isAllZero) return 0;
        return resultXor==0?n-1:n;
    }
}