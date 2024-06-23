class Solution {
    public int longestSubarray(int[] nums, int limit) {
      int left = 0, right = 0;
    int maxLength = 0;
    Deque<Integer> maxDeque = new LinkedList<>();
    Deque<Integer> minDeque = new LinkedList<>();

    while (right < nums.length) {
        while (!maxDeque.isEmpty() && maxDeque.peekLast() < nums[right]) {
            maxDeque.pollLast();
        }
        maxDeque.offerLast(nums[right]);

        while (!minDeque.isEmpty() && minDeque.peekLast() > nums[right]) {
            minDeque.pollLast();
        }
        minDeque.offerLast(nums[right]);

        while (maxDeque.peekFirst() - minDeque.peekFirst() > limit) {
            if (maxDeque.peekFirst() == nums[left]) {
                maxDeque.pollFirst();
            }
            if (minDeque.peekFirst() == nums[left]) {
                minDeque.pollFirst();
            }
            left++;
        }

        maxLength = Math.max(maxLength, right - left + 1);
        right++;
    }

    return maxLength;  
    }
}
