class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration){
        int landTowater = calculate(landStartTime,landDuration,waterStartTime,waterDuration);
        int waterToland = calculate(waterStartTime,waterDuration,landStartTime,landDuration);

        return Math.min(landTowater,waterToland);

    }

    private int calculate(int[] firstRideTime, int[] firstRideDuration, int[] secondRideTime, int[] secondRideDuration){
        int earliestFinish = Integer.MAX_VALUE;
        for(int i=0;i<firstRideTime.length;i++){
            earliestFinish = Math.min(earliestFinish,firstRideTime[i]+firstRideDuration[i]);
        }

        int ans = Integer.MAX_VALUE;

        for(int i=0;i<secondRideTime.length;i++){
            int finishTime = Math.max(earliestFinish,secondRideTime[i])+secondRideDuration[i];
            ans = Math.min(ans,finishTime);
        }

        return ans;
    }
}

// Time complexity : O(m*n) for each land ride O(n) and for each water ride O(m)
// Space Complexity : O(1)
