class Solution{
    private int digitProduct(int n){ // O(log n )
        int product = 1;
        while(n>0){
            product*=n%10;
            n/=10;
        }
    }

    public int smallestNumber(int n , int t){
        if(digitProduct(n)==0)return n;
        while(digitProduct(n)%t!=0){ //O(k)
            n++;
        }
        return n;
    }
}