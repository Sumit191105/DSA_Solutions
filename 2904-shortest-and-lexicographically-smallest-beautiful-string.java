class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();
        int i =0 , j =0;
        int ones = 0;
        String result = "";
        while(j<n){
            if(s.charAt(j)=='1') ones++;
            while(i<=j &&(s.charAt(i)=='0') || ones>k ){
                if(s.charAt(i)=='1') ones--;
                i++;
            }
            if(ones==k){
                String temp = s.substring(i,j+1);
                if(temp.length()<result.length() || result.isEmpty() || (result.length()==temp.length() && temp.compareTo(result)<0)) result = temp;
            }
            j++;
        }
        return result;
    }
}