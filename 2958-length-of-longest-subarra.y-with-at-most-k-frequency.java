class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer, Integer> map= new HashMap<>();
        Deque<Integer> q = new ArrayDeque<>();
        int left = 0 , right = 0;
        int maxSize = Integer.MIN_VALUE;
        while(right<nums.length){
            map.put(nums[right],map.getOrDefault(nums[right],0)+1);
            q.offer(nums[right]);
            while(map.get(nums[right])>k){
                int removed = q.removeFirst();
                map.put(removed,map.get(removed)-1);
                left++;
            }
            maxSize = Math.max(maxSize,q.size()); 
            right++;
        }
        return maxSize;
    }
}