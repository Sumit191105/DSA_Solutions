class Solution {
    public ArrayList<Integer> findOrder(int n, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : prerequisites) {
            int course = edge[0];
            int prerequisite = edge[1];
            adj.get(prerequisite).add(course);
        }
        int[] indegree = new int[n];
        for (int i = 0; i < n; i++) {
            for (int it : adj.get(i)) {
                indegree[it]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        ArrayList<Integer> topo = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.remove();
            topo.add(node);
            for (int it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) {
                    q.add(it);
                }
            }
        }
        if (topo.size() != n) {
            return new ArrayList<>();
        }
        return topo;
    }
}