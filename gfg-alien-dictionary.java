class Solution {
    
    private List<Integer> topoSort(List<List<Integer>> adj , int k,boolean[] present){
        int[] indegree = new int[k];
        for(int i =0;i<k;i++){
            for(int it : adj.get(i)){
                indegree[it]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i =0;i<k;i++){
            if(indegree[i]==0 && present[i] ) q.add(i);
        }
        List<Integer> topo = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.remove();
            topo.add(node);
            for(int it : adj.get(node)){
                indegree[it]--;
                if(indegree[it]==0) q.add(it);
            }
        }
        return topo;
    }
    
    
    public String findOrder(String[] words) {
        int n = words.length;
        int k = 26;
        
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<k;i++){
            adj.add(new ArrayList<>());
        }
        boolean[] present = new boolean[26];
        for(String word : words){
            for(char ch : word.toCharArray()){
                present[ch-'a']=true;
            }
        }
        int characterCount = 0;
        for(boolean value : present){
            if(value)characterCount++;
        }
        boolean[][] edges = new boolean[26][26];
        for(int i =0;i<n-1;i++){
            String s1 = words[i];
            String s2 = words[i+1];
            boolean noDuplicate = false;
            int len = Math.min(s1.length(),s2.length());
            for(int j=0;j<len;j++){
                if(s1.charAt(j)!=s2.charAt(j)){
                    int u = s1.charAt(j)-'a';
                    int v = s2.charAt(j)-'a';
                    if(!edges[u][v]){
                        adj.get(u).add(v);
                        edges[u][v]=true;
                    }
                    noDuplicate = true;
                    break;
                }
            }
            if(!noDuplicate && s1.length()>s2.length()){
                return "";
            }
        }
        List<Integer> topo = topoSort(adj,k,present);
        if(topo.size()!=characterCount) return "";
        StringBuilder ans = new StringBuilder();
        for(int it : topo){
            if(present[it]){
                ans.append((char)(it+'a'));
            }
        }
        return ans.toString() ;
    }
}