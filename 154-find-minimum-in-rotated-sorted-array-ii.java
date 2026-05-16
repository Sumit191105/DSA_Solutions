/*This approach can only give the solution if there's is no duplicate present
Here duplicate is present so this approach will not work for this question.*/ 


/*class Solution {
    public int findMin(int[] nums) {
        int left=0,right=nums.length;
        while(left<right){
            int mid = left+(right-left)/2;
            if(nums[mid]>nums[right]) left=mid+1;        // Time complexity : O(logn)
            else{                                        // Test case passed : 183/193
                right=mid;
            }
        }
        return nums[left];
    }
}*/


class Solution{
    public int findMin(int[] nums){
        return fnc(0,nums.length-1,nums);
    }

    public int fnc(int left,int right,int[] nums){
        if(left==right){
            return nums[left];
        }
        if(nums[left]<nums[right]){                    //Time complexity : O(logn)
            return nums[left];                         //This solution passes all the test case.
        }                                              //Approach : Divide And Conquror
        int mid =(left+right)  >> 1;

        return Math.min(fnc(left,mid,nums),fnc(mid+1,right,nums));
    }
}