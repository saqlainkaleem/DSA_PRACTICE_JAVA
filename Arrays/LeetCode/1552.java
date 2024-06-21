class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int left = 1, right = position[position.length - 1] - position[0];
        int ans = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canDistribute(position, m, mid)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
    
    private boolean canDistribute(int[] position, int m, int force) {
        int count = 1, prev = position[0];
        for (int i = 1; i < position.length; i++) {
            if (position[i] - prev >= force) {
                count++;
                prev = position[i];
            }
            if (count >= m) {
                return true;
            }
        }
        return false;
    }
}
