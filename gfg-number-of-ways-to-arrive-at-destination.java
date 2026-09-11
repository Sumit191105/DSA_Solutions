import java.util.PriorityQueue;

class Pair{
    int first;
    int second;
    Pair(int _first, int _second){
        this.first = _first;
        this.second = _second;
    }
}

class Solution {
    public int countPaths(int V, int[][] edges){
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i =0;i<edges.length;i++){
            adj.add(new ArrayList<>());
        }
        for(int i =0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int time = edges[i][2];
            adj.get(u).add(new Pair(time,v));
            adj.get(v).add(new Pair(time,u));
        }
        long[] dist = new long[V];
        long[] ways = new long[V];
        for(int i =0;i<V;i++){
            dist[i]=(long)1e9;
        }
        ways[0]=1;
        dist[0]=0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y)->x.first-y.first);
        pq.add(new Pair(0,0));
        int mod = (int)(1e9+7);
        while(!pq.isEmpty()){
            Pair temp = pq.poll();
            int dis = temp.first;
            int node = temp.second;
            for(Pair it : adj.get(node)){
                int adjW = it.first;
                int adjNode = it.second;
                if(adjW+dis<dist[adjNode]){
                    dist[adjNode]=adjW+dis;
                    pq.add(new Pair(adjW+dis,adjNode));
                    ways[adjNode]=ways[node];
                }else if(adjW + dis == dist[adjNode]){
                    ways[adjNode]=ways[adjNode]+ways[node]%mod;
                }
            }
        }
        return (int)ways[V-1];
    }
}