/*Intuition
A good array must follow the pattern:
[1, 2, 3, ..., n-1, n, n]
where:
1.numbers from 1 to n-1 appear exactly once
2.maximum number n appears exactly twice

Since the order does not matter, we use a HashMap to count the frequency of ever element

Then:

1.the array length must be max + 1
2.every number from 1 to max-1 must appear once
3.max must appear twice

If all conditions satisfy, return true; otherwise return false. -->

Approach
1.Create a HashMap to store frequencies.
2.count frequency of each element
3.find the maximum element
4.Check if array length equals max + 1.
5.Check if each number must have frequency 1
6.Check whether frequency of max is 2.
7.Return the result.

Complexity
Time complexity:
O(n)+O(n)=2O(n) means O(n)

Space complexity: O(n)*/

//code

class Solution {
    public boolean isGood(int[] nums) {
       HashMap<Integer,Integer> map = new HashMap<>();
       int max =0;

       for(int num:nums){
        map.put(num,map.getOrDefault(num,0)+1);
        max=Math.max(max,num);
       }
       
       /* if arr[]=[1,2,3,4,4] it is true , here 4 is the max element. 
       As, we can see that the length of the array should be max+1 not more
       or less than that.*/
       
       if(nums.length != max+1) return false;

       /*only the max element can occur twice while other element can occur 
        only once */

        for(int i=1;i<max;i++){
            if(map.getOrDefault(i,0)!=1) return false;
        }

        // check if max element is present twice or not if not then false.
       
        return map.getOrDefault(max,0)==2; 
       
       
    }
}
