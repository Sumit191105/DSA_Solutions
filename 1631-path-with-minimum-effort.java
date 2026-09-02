import java.util.PriorityQueue;

class Tuple{
    int distance;
    int row;
    int col;
    Tuple(int distance , int row, int col){
        this.distance = distance;
        this.row = row;
        this.col = col;
    }
}

class Solution {
    public int minimumEffortPath(int[][] heights){
        int n = heights.length;
        int m = heights[0].length;
        PriorityQueue<Tuple> pq = new PriorityQueue<>((a,b)->a.distance-b.distance);
        int[][] dist = new int[n][m];
        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                dist[i][j] =(int)(1e9);
            }
        }
        dist[0][0] = 0;
        pq.add(new Tuple(0,0,0));
        int dr[] ={-1,0,+1,0};
        int dc[] ={0,+1,0,-1};
        while(!pq.isEmpty()){
            Tuple node = pq.poll();
            int diff = node.distance;
            int row = node.row;
            int col = node.col;
            if(row==n-1 && col ==m-1) return diff;
            for(int i =0;i<4;i++){
                int nRow = row + dr[i];
                int nCol = col + dc[i];
                if(nRow>=0 && nRow<n && nCol>=0 && nCol<m){
                    int newEffort = Math.max((Math.abs(heights[row][col]-heights[nRow][nCol])),diff);
                    if(newEffort<dist[nRow][nCol]){
                        dist[nRow][nCol]=newEffort;
                        pq.add(new Tuple(newEffort,nRow,nCol));
                    }
                }
            }
        }
        return 0;
    }
}