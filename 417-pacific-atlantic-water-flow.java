class Solution {
    int dir[][] ={{0,1},{1,0},{0,-1},{-1,0}};
    private void dfs(int[][] heights, int row, int col, int prev, boolean[][] ocean){
        if(row<0 || row>=heights.length || col<0 || col>=heights[0].length) return;
        if(heights==null || heights.length==0 || heights[0].length==0) return;
        if(heights[row][col]<prev || ocean[row][col]) return;
        ocean[row][col] = true;
        for(int[] d:dir){
            dfs(heights,row+d[0],col+d[1],heights[row][col],ocean);
        }
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        if(heights==null || heights.length==0 || heights[0].length==0) return res;
        int row = heights.length;
        int col = heights[0].length;
        boolean[][] pacific = new boolean[row][col];
        boolean[][] atlantic = new boolean[row][col];
        for(int i=0;i<row;i++){ // cols connected to the ocean
            dfs(heights,i,0,Integer.MIN_VALUE,pacific);
            dfs(heights,i,col-1,Integer.MIN_VALUE,atlantic);
        }
        for(int i=0;i<col;i++){
            dfs(heights,0,i,Integer.MIN_VALUE,pacific);
            dfs(heights,row-1,i,Integer.MIN_VALUE,atlantic);
        }
        for(int i=0; i<row;i++){
            for(int j=0;j<col;j++){
                if(pacific[i][j] && atlantic[i][j]) res.add(Arrays.asList(i,j));
            }
        }
        return res;
    }
}