class Solution {
    public int search(int[] nums, int target) {
        int idx=0;
        for(int i:nums){

            if(i==target) return idx;
            idx++;
        }
        return -1;
    }
} // this is not the binary search.

class Solution{
    public int search(int[] nums, int target){
        int left = 0 , right = nums.length-1;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(target> nums[mid]) left = mid+1;
            else if(target<nums[mid]) right = mid-1;
            else{
                return mid;
            }
        }
        return -1;
    }
}/*  Time complexity : O(log n )
    As we used only a few variables:
    right , left , mid 
    The space complexity : O(1) */