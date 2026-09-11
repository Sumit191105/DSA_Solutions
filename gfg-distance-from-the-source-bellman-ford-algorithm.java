class Solution {
    public ArrayList<Integer> bellmanFord(int V, int[][] edges, int src) {
        int[] dist = new int[V];
        for(int i=0;i<V;i++)dist[i]=(int)(1e8);
        dist[src]=0;
        for(int i =0;i<V-1;i++){
            for(int[] edge:edges){
                int u = edge[0];
                int v = edge[1];
                int wt = edge[2];
                if(dist[u]!=(int)1e8 && wt+dist[u]<dist[v]){
                    dist[v]=wt+dist[u];
                }
            }
        }
        //Nth cycle to check the negative cycle
        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            if(dist[u]!=(int)1e && dist[u]+wt<dist[v]){
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(-1);
                return temp;
                
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        for(int n: dist){
            result.add(n);
        }
        return result;
    }
}
