class Solution{


    private int firstposition(int[] nums, int target){
        int left=0, right=nums.length-1, ans=-1;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(target==nums[mid]){
                ans= mid;
                right=mid-1;
            }
            else if(target<nums[mid]) right=mid-1;
            else{
                left=mid+1;
            }
        }
        return ans;
    }

    private int secondposition(int[] nums, int target){
        int left=0, right = nums.length-1 , ans =-1;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(target==nums[mid]){
                ans = mid;
                left=mid+1;
            }
            else if(target<nums[mid]) right = mid-1;
            else{
                left= mid+1;
            }
        }
        return ans;
    }
    public int[] searchRange(int[] nums, int target){
        return new int[]{firstposition(nums,target),secondposition(nums,target)};
    }
}