import java.util.Queue;

class Solution{
    public ArrayList<Integer> topoSort(int V, int[][] edges){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
        }
        int[] freq = new int[V];
        for(int i=0;i<V;i++){
            for(int it : adj.get(i)){
                freq[it]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<V;i++){
            if(freq[i]==0)q.add(i);
        }
        ArrayList<Integer> res = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.peek();
            q.remove();
            res.add(node);
            for(int it : adj.get(node)){
                freq[it]--;
                if(freq[it]==0)q.add(it);
            }
        }
        return res;
    }
}