import java.util.*;

class Solution {
    public int minJumps(int[] arr) {

        int n = arr.length;

        if (n == 1) return 0;

        // value -> indices
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.putIfAbsent(arr[i], new ArrayList<>());
            map.get(arr[i]).add(i);
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[n];

        q.offer(0);
        vis[0] = true;

        int steps = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            while (size-- > 0) {

                int curr = q.poll();

                // reached end
                if (curr == n - 1) {
                    return steps;
                }

                // same value indices
                for (int next : map.get(arr[curr])) {

                    if (!vis[next]) {
                        vis[next] = true;
                        q.offer(next);
                    }
                }

                // important optimization
                map.get(arr[curr]).clear();

                // left
                if (curr - 1 >= 0 && !vis[curr - 1]) {
                    vis[curr - 1] = true;
                    q.offer(curr - 1);
                }

                // right
                if (curr + 1 < n && !vis[curr + 1]) {
                    vis[curr + 1] = true;
                    q.offer(curr + 1);
                }
            }

            steps++;
        }

        return -1;
    }
}

//Approach : BFS with hashmap optimization
//Time complexity : O(n)
//Space complexity : O(n)