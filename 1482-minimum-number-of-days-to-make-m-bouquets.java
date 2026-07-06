class Solution{
    public int minDays(int[] bloomDays, int m, int k ){
        int n = bloomDays.length;
        if((long)m*k>n) return -1;
        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;
        for(int i:bloomDays){
            left = Math.min(left,i);
            right = Math.max(right,i);
        }
        int ans = -1;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(canMake(bloomDays,m,k,mid)){
                ans = mid;
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return ans;
    }
    private boolean canMake(int[] bloomDays,int m, int k, int days){
        int count = 0;
        int bouquets = 0;
        for(int bloom:bloomDays){
            if(bloom<=days){
                count++;
                if(count==k){
                    bouquets++;
                    count=0;
                }
            }else{
                count=0;
            }
        }
        return bouquets>=m;
    }
}