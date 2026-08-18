class Solution {

    private boolean dfs(int node , int[] vis, int[] pathVis, int[] check, ArrayList<ArrayList<Integer>> adj){
        vis[node] = 1;
        pathVis[node] =1;
        check[node] =0;
        for(int it : adj.get(node)){
            if(vis[it]==0){
                if(dfs(it,vis,pathVis,check,adj)==true) return true;
            }else if(pathVis[it]==1)return true;
        }
        pathVis[node]=0;
        check[node]=1;
        return false;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) { 
        int n = graph.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            for(int v:graph[i]){
                adj.get(i).add(v);
            }
        }
        int[] vis = new int[n];
        int[] pathVis = new int[n];
        int[] check = new int[n];

        for(int i=0;i<n;i++){
            if(vis[i]==0){
                dfs(i,vis,pathVis,check,adj);
            }
        }
        ArrayList<Integer> safeNode = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(check[i]==1) safeNode.add(i);
        }
        return safeNode;
    } 
}