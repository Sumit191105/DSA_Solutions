class Node{
    int first;
    int second;
    Node(int _first, int _second){
        this.first = _first;
        this.second = _second;
    }
}

class Solution {
    public int minSteps(int[] arr, int start, int end) {
        int n = arr.length;
        int[] dist = new int[1000];
        for(int i=0;i<1000;i++)dist[i] = (int)1e9;
        dist[start]=0;
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0,start));
        while(!q.isEmpty()){
            Node temp = q.poll();
            int steps = temp.first;
            int num = temp.second;
            if(num==end) return steps;
            for(int i =0;i<n;i++){
                int newVal = (num*arr[i])%1000;
                if(steps+1<dist[newVal]){
                    dist[newVal]=steps+1;
                    q.add(new Node(steps+1,newVal));
                }
            }
        }
        return -1;
    }
}