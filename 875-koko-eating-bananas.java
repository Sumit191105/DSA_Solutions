class Solution{
    public int minEatingSpeed(int[] piles, int h){
        int left = 1, right = 0;
        for(int i:piles){
            right =Math.max(i,right);
        }
        while(left<=right){
            int mid = left+(right-left)/2;
            long hrs = 0;
            for(int i:piles){
                hrs+=(i+mid-1)/mid;
            }
            if(hrs<=h){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return left;
    }
}