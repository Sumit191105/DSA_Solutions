class Solution {
    public boolean canReach(int[] arr, int start) {
        boolean[] visited = new boolean[arr.length];
        return dfs(arr,start,visited);
    }

    public boolean dfs(int[] arr, int i, boolean[] visited){
        if(i<0 || i>=arr.length) return false;

        if(visited[i]) return false;

        if(arr[i]==0) return true;

        visited[i]=true;

        return dfs(arr,i+arr[i],visited)||dfs(arr,i-arr[i],visited);
    }
}

// Approach : Depth First Search
// Time complexity : O(n) Best case and worst case beacuse we are accessing each and every element present in array.
// Space complexity : O(n) Beacause we have created a visited boolean array to track the visited element.