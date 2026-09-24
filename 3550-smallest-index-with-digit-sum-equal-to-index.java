class Solution{
    private int digitSum(int num){
        int sum=0;
        while(num>0){
            sum+=num%10;
            num/=10;
        }
        return sum;
        
    }
    public int smallestIndex(int[] nums){
        int idx=0;
        for(int i : nums){
            if(idx==digitSum(i)) return idx;
            idx++;
        }
        return -1;
    }
}