class Pair{
    int first,second;
    Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}


class Solution{
    private void topoSort(int node , ArrayList<ArrayList<Pair>> adj , Stack<Integer> st , int[] vist){
        vist[node]=1;
        for(int i =0; i<adj.get(node).size();i++){
            int v = adj.get(node).get(i).first;
            if(vist[v]==0){
                topoSort(v,adj,st,vist);
            }
        }
        st.push(node);
    }
    public ArrayList<Integer> shortestPath(int V, int[][] edges){
        int m = edges.length;
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i =0;i<V;i++){
            ArrayList<Pair> temp = new ArrayList<>();
            adj.add(temp);
        }
        for(int i =0;i<m;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            adj.get(u).add(new Pair(v,wt));
        }
        int[] vist = new int[V];
        Stack<Integer> st = new Stack<>();
        for(int i =0;i<V;i++){
            if(vist[i]==0){
                topoSort(i,adj,st,vist);
            }
        }
        int[] dist = new int[V];
        for(int i =0;i<V;i++){
            dist[i]= (int)(1e9);
        }
        dist[0]=0;
        while(!st.isEmpty()){
            int node = st.pop();
            for(int i =0;i<adj.get(node).size();i++){
                int v = adj.get(node).get(i).first;
                int wt = adj.get(node).get(i).second;
                if(dist[node]+wt<dist[v]) dist[v]= dist[node]+ wt;
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        for(int i =0;i<V;i++){
            if(dist[i]==(int)(1e9)) result.add(-1);
            else{
                result.add(dist[i]);
            }
        }
        return result;
    }
}