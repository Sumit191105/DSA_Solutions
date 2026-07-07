class Solution{
    public int shipWithinDays(int[] weights, int days){
        int left = Integer.MIN_VALUE, right=0, ans =0;
        for(int i:weights){
            left=Math.max(i,left);
            right+=i;
        }
        while(left<=right){
            int mid = left+(right-left)/2;
            int daysUsed =1;
            int curr = 0;
            for(int i: weights){
                if(curr+i<=mid){
                    curr+=i;
                }else{
                    daysUsed++;
                    curr=i;
                }
            }
            if(daysUsed<=days){
                ans=mid;
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return ans;
    }
}