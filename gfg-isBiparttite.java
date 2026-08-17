//BY DFS 
class Solution {
    
    private boolean dfs(int node , int col , ArrayList<ArrayList<Integer>> adj, int[] color){
        color[node]=col;
        for(int i:adj.get(node)){
            if(color[i]==-1){
                if(dfs(i,1-col,adj,color)==false)return false;
            }else if(color[i]==col)return false;
        }
        return true;
    }

    public boolean isBipartite(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            int u = edge[0];
            int v = edge[1];
            
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int[] color = new int[V];
        for(int i=0;i<V;i++) color[i]=-1;
        for(int i=0;i<V;i++){
            if(color[i]==-1){
                if(dfs(i,0,adj,color)==false) return false;
            }
        }
        return true;
    }
}
//Time complexity : O(V+E)