class Solution {
    
    private boolean dfs(int node , int[] vis, int[] pathVis, int[] check, ArrayList<ArrayList<Integer>> adj){
        vis[node]=1;
        pathVis[node]=1;
        check[node]=0;
        for(int it : adj.get(node)){
            if(vis[it]==0){
                if(dfs(it,vis,pathVis,check,adj)==true)return true;
            }else if(pathVis[it]==1)return true;
        }
        pathVis[node]=0;
        check[node]=1;
        return false;
    }
    
    public ArrayList<Integer> safeNodes(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
        }
        int[] vis = new int[V];
        int[] pathVis = new int[V];
        int[] check = new int[V];
        for(int i=0;i<V;i++){
            if(check[i]==0){
                dfs(i,vis,pathVis,check,adj);
            }
        }
        ArrayList<Integer> safeNodes = new ArrayList<>();
        for(int i=0;i<V;i++){
            if(check[i]==1) safeNodes.add(i);
        }
        return safeNode
        
    }
}