class Solution{
    //Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

//Let's Start with BFS
    private HashMap<Node,Node> map = new HashMap<>();

    private Node bfs(Node start){
        Queue<Node> q = new LinkedList<>();
        q.offer(start);
        while(!q.isEmpty()){
            Node node = q.poll();
            Node cloneNode = map.get(node);
            for(int adj:node.neighbors){
                if(!map.containsKey(adj)){
                    Node clone = new Node(adj.val);
                    map.put(adj,clone);
                    q.offer(adj);
                }
                cloneNode.neighbors.add(map.get(adj));
            }
        }
        return map.get(start);
    }

    // BFS = O(V+E)
    public Node cloneGraph(Node node){
        if(node==null) return null;
        map.put(node,new Node(node.val));
        return bfs(node);

    }
}