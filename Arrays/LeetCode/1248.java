class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int res = 0;
    int count = 0;
    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, 1);
    
    for (int i = 0; i < nums.length; i++) {
        count += nums[i] % 2;
        res += map.getOrDefault(count - k, 0);
        map.put(count, map.getOrDefault(count, 0) + 1);
    }
    
    return res;
    }
}
