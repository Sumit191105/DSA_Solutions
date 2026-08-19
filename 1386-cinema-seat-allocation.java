class Solution{
    public int maxNumberOfFamilies(int n , int[][] reservedSeats){
        Map<Integer,Set<Integer>> map = new HashMap<>();
        for(int[] seats: reservedSeats){
            int row = seats[0];
            int col = seats[1];
            map.computeIfAbsent(row,k->new HashSet<>()).add(col);
        }
            /*Or
            (!map.containsKey(row)){
            map.put(row,new HashSet<>());
            map.get(row).add(col)} */
        int ans = n*2;// maximum answer we could get
        for(Set<Integer> reserved: map.values()){
            boolean left = true; // 2345
            boolean middle = true; //4567
            boolean right = true; //6789
            for(int seat: reserved){
                if(seat>=2 && seat<=5) left = false;
                if(seat>=4 && seat<=7) middle = false;
                if(seat>=6 && seat<=9) right = false;
            }
            if(left && right) continue;
            else if(left || middle || right ) ans--;
            else{
                ans-=2;
            }
        }
    return ans ;        
    }
}