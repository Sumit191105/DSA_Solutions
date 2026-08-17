class Solution {
    
    private boolean dfs(int node , int[] visit, int[] pathVis, ArrayList<ArrayList<Integer>> adj){
        visit[node]=1;
        pathVis[node]=1;
        for(int it: adj.get(node)){
            if(visit[it]==0){
                if(dfs(it,visit,pathVis,adj)==true)return true;
            }else if(pathVis[it]==1){
                return true;
            }
        }
        pathVis[node] = 0;
        return false;
    }
    public boolean isCyclic(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);//for directed graph you should add only this 
            //adj.get(v).add(u);
        }
        int[] visit = new int[V];
        int[] pathVis =new int[V];
        for(int i=0;i<V;i++){
            if(visit[i]==0){
                if(dfs(i,visit,pathVis,adj)==true)return true;
            }
        }
        return false;
    }
}