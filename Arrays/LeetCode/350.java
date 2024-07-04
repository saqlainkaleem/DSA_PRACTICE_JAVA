class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
         HashMap<Integer, Integer> count = new HashMap<>();
        for (int num : nums1) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        List<Integer> result = new ArrayList<>();
        for (int num : nums2) {
            if (count.containsKey(num) && count.get(num) > 0) {
                result.add(num);
                count.put(num, count.get(num) - 1);
            }
        }
        int[] array = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            array[i] = result.get(i);
        }
        return array;
    }
}
