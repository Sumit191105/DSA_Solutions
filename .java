import java.util.HashMap;

class Solution{
    public int largestInteger(int[] nums, int k){
        int n = nums.length;
        Deque<Integer> dq = new ArrayDeque<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        HashMap<Integer, Integer> window = new HashMap<>();
        for (int i=0;i<k;i++){
            dq.offer(nums[i]);
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        for(int num: map.keySet()){
            window.put(num,window.getOrDefault(num,0)+1);
        }
        for(int i=k;i<n;i++){
            int removed = dq.pollFirst();
            map.put(removed,map.get(removed)-1);
            if(map.get(removed)==0){
                map.remove(removed);
            }
            int add = nums[i];
            dq.offer(add);
            map.put(add,map.getOrDefault(add,0)+1);
            for(int num : map.keySet()){
                window.put(num,window.getOrDefault(num,0)+1);
            }
        }
        int ans = -1;
        for(Map.Entry<Integer,Integer> entry: window.entrySet()){
            if(entry.getValue()==1){
                ans = Math.max(ans,entry.getKey());
            }
        }
        return ans;
    }
}