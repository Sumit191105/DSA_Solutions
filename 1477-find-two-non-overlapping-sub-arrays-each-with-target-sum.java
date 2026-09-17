class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int left =0, right =0;
        int[] minLenTillIdx = new int[arr.length];
        for(int i =0;i<arr.length;i++)minLenTillIdx[i]=Integer.MAX_VALUE;
        int bestMinLen = Integer.MAX_VALUE;
        int result = Integer.MAX_VALUE;  
        int currSum=0;
        while(right < arr.length){
            currSum+=arr[right];
            while(left<=right && currSum>target){
                currSum -= arr[left++];
            }
            if(currSum==target){
                int len = right-left+1;
                if(left>0 && minLenTillIdx[left-1]!= Integer.MAX_VALUE ){
                    result = Math.min(len+minLenTillIdx[left-1],result);
                }
                bestMinLen = Math.min(bestMinLen,len);
            }
            minLenTillIdx[right]=bestMinLen;
            right++;
        }
        return result==Integer.MAX_VALUE ? -1: result;
    }
}