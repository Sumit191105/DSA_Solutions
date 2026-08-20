class Solution {
    public boolean isPossible(int n, int[][] pre){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge:pre){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
        }
        int[] freq = new int[n];
        for(int i =0;i<n;i++){
            for(int it : adj.get(i)){
                freq[it]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i =0;i<n;i++){
            if(freq[i]==0) q.add(i);
        }
        List<Integer> topo = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.peek();
            q.remove();
            topo.add(node);
            for(int it : adj.get(node)){
                freq[it]--;
                if(freq[it]==0) q.add(it);
            }
        }
        if(topo.size()==n) return true;
        return false;
    }
}