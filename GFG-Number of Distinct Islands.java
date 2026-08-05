class Solution {
    
    private void dfs(int row , int col , int[][] visited, char[][] grid , int row0, int col0, ArrayList<String> data){
        visited[row][col] = 1;
        data.add(toString(row-row0,col-col0));
        int n = grid.length;
        int m = grid[0].length;
        int delRow[] = {-1,0,+1,0};
        int delCol[] = {0,+1,0,-1};
        for(int i=0;i<4;i++){
            int nrow = row+delRow[i];
            int ncol = col+delCol[i];
            if(nrow>=0 && nrow < n && ncol>=0 && ncol<m && visited[nrow][ncol]==0 && grid[nrow][ncol]=='L'){
                dfs(nrow,ncol,visited,grid,row0,col0,data);
            }
        }
    }

    private String toString(int r , int c){
        return Integer.toString(r)+" "+Integer.toString(c);
    }
    
    public int countDistinctIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] visited = new int[n][m];
        HashSet<ArrayList<String>> map = new HashSet<>();
        for(int i =0;i<n;i++){
            for(int j=0;j<m;j++){
                if(visited[i][j]==0 && grid[i][j]=='L'){
                    ArrayList<String> data = new ArrayList<>();
                    dfs(i,j,visited,grid,i,j,data);
                    map.add(data);
                }
            }
        }
        return map.size();
    }
}