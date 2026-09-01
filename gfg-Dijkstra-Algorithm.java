class Pair{
    int first;
    int second;
    Pair(int _first, int _second){
        this.first = _first;
        this.second = _second;
    }
}

class Solution {
    public ArrayList<Integer> dijkstra(int V, int[][] edges, int src) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i =0;i<V;i++) adj.add(new ArrayList<>());
        for(int i =0;i<edges.length;i++){
            adj.get(edges[i][0]).add(new Pair(edges[i][2],edges[i][1]));
            adj.get(edges[i][1]).add(new Pair(edges[i][2],edges[i][0]));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((a,b)->a.first-b.first);
        int[] dist = new int[V];
        for(int i =0;i<V;i++)dist[i] = (int)(1e9);
        dist[src] = 0;
        pq.add(new Pair(0,src));
        while(!pq.isEmpty()){
            Pair current = pq.poll();
            int node = current.second;
            int weight = current.first;
            if(dist[node]<weight) continue;
            for(Pair it: adj.get(node)){
                int adjNode = it.second;
                int adjWeight  = it.first;
                if(weight+adjWeight<dist[adjNode]){
                    dist[adjNode] = weight + adjWeight;
                    pq.add(new Pair(weight+adjWeight,adjNode));
                }
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        for(int i =0;i<V;i++){
            result.add(dist[i]);
        }
        return result;
    }
}