class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int num:nums){
            min = Math.min(min,num);
            max = Math.max(max,num);
            map.put(num,1);
        }
        for(int i = min+1; i<max; i++){
            if(!map.containsKey(i)){
                ans.add(i);
            }
        }
        return ans ;     

    }
}