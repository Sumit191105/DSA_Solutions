class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int n = numCourses;
        for(int i =0 ; i<n ;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : prerequisites){
            int u = edge[0];
            int v = edge[1];
            adj.get(v).add(u);
        }
        int[] indegree = new int[n];
        for(int i =0 ;i<n;i++){
            for(int it : adj.get(i)){
                indegree[it]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0 ; i<n ;i++){
            if(indegree[i]==0) q.add(i);
        }
        int[] topo = new int[n];
        int idx=0;
        while(!q.isEmpty()){
            int node = q.remove();
            topo[idx++]= node;
            for(int it : adj.get(node)){
                indegree[it]--;
                if(indegree[it]==0) q.add(it);
            }
        }
        if(idx==n) return topo;
        return new int[0];
    }
}