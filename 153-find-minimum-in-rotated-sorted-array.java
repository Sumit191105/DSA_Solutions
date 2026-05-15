/* This is not the optimal solution of this question
Time Complexity : O(n)
Space complexity: O(1)

We can solve this question with time complexity of O(log n)*/


/*class Solution {
    public int findMin(int[] nums) {
        int min=Integer.MAX_VALUE;
        for(int num:nums){
            min=Math.min(min,num);
        }
        return min;
    }
}*/

//The question says that initial array is sorted but gets rotated between 1 to n times

// Approach: Binary Search 

class Solution{
    public int findMin(int[] nums){
        int left =0 , right= nums.length-1;
        while(left<right){
            int mid = left+(right-left)/2;
            if(nums[mid]>nums[right]){ // means minimum lies in the right half
                left=mid+1;
            }else{ // means minimum lies in left half including mid
                right=mid;
            }
        }
        return nums[left];
    }
} 
/* Space complexity: Since there is no extra array is used , only left-right-mid varibles
 are used. So, it's O(1). Time Complexity as Question asked : O(log n)*/