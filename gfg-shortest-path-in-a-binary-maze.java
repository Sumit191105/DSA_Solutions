class Tuple{
    int step;
    int row;
    int col;
    Tuple(int _step, int _row, int _col){
        this.step = _step;
        this.row = _row;
        this.col = _col;
    }
}


class Solution {
    public int shortestPath(int[][] mat, int[] src, int[] dest) {
        if(mat[src[0]][src[1]]==0 || mat[dest[0]][dest[1]]==0) return -1;
        if(src[0]==dest[0] && src[1]==dest[1]) return 0;
        PriorityQueue<Tuple> pq = new PriorityQueue<>((a,b)->a.step-b.step);
        int n = mat.length;
        int m = mat[0].length;
        int[][] dist = new int[n][m];
        for(int i =0;i<n;i++){
            for(int j=0;j<m;j++){
                dist[i][j]=(int)(1e9);
            }
        }
        dist[src[0]][src[1]]=0;
        pq.add(new Tuple(0,src[0],src[1]));
        int[] dr = {-1,0,+1,0};
        int[] dc = {0,+1,0,-1};
        while(!pq.isEmpty()){
            Tuple node = pq.poll();
            int step = node.step;
            int row = node.row;
            int col = node.col;
            if(mat[row][col]==0) continue;
            if(row==dest[0] && col==dest[1]) return step;
            for(int i =0;i<4;i++){
                int nrow = row + dr[i];
                int ncol = col + dc[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && mat[nrow][ncol]==1 && step+1<dist[nrow][ncol] ){
                    dist[nrow][ncol]=step+1;
                    if(dest[0]==nrow && dest[1]==ncol) return step+1;
                    pq.add(new Tuple(step+1,nrow,ncol));
                    
                }
            }
        }
        return -1;
    }
}