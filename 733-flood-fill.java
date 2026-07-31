class Solution {

    private void dfs(int sr, int sc, int[][] ans, int[][] image, int delRow[], int delCol[], int iniColor,int color){
        ans[sr][sc]=color;
        int n = image.length;
        int m = image[0].length;
        for(int i=0;i<4;i++){
            int nrow = sr+delRow[i];
            int ncol = sc+delCol[i];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && ans[nrow][ncol]!=color && image[nrow][ncol]==iniColor){
                dfs(nrow,ncol,ans,image,delRow,delCol,iniColor,color);
            }
        }
    }



    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int[][] ans = image;
        int iniColor = image[sr][sc];
        int[] delRow ={-1,0,+1,0};
        int[] delCol ={0,+1,0,-1};
        dfs(sr,sc,ans,image,delRow,delCol,iniColor,color);
        return ans;
    }
}