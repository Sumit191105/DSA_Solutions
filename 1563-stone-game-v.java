class Solution{

    int[][] t = new int[501][501];
    private int solve(int left, int right, int[] cumSum){
        if(left>=right) return 0;
        if(t[left][right]!=-1) return t[left][right];
        int score =0;
        for(int mid = left; mid<right;mid++){
            int leftSum = cumSum[mid]-(left-1>=0?cumSum[left-1]:0);
            int rightSum = cumSum[right]-cumSum[mid];
            if(leftSum<rightSum){
                score = Math.max(score,leftSum+solve(left,mid,cumSum));
            }else if(leftSum>rightSum){
                score = Math.max(score,rightSum+solve(mid+1,right,cumSum));
            }else{
                score = Math.max(score,Math.max(leftSum+solve(left,mid,cumSum),rightSum+solve(mid+1,right,cumSum)));
            }
        }
        return t[left][right]=score;
    }
    public int stoneGameV(int[] stoneValue){
        int n = stoneValue.length;
        int[] cumSum = new int[n];
        cumSum[0] = stoneValue[0];
        for(int i=1;i<n;i++){
            cumSum[i] = cumSum[i-1]+stoneValue[i];
        }
        for(int[] row: t){
            Arrays.fill(row,-1);
        } 
        return solve(0,n-1,cumSum);
    }
}