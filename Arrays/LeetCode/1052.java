class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;
    int total = 0;
    for (int i = 0; i < n; i++) {
        if (grumpy[i] == 0) {
            total += customers[i];
        }
    }
    int maxIncrease = 0;
    int windowSum = 0;
    for (int i = 0; i < n; i++) {
        if (grumpy[i] == 1) {
            windowSum += customers[i];
        }
        if (i >= minutes && grumpy[i - minutes] == 1) {
            windowSum -= customers[i - minutes];
        }
        maxIncrease = Math.max(maxIncrease, windowSum);
    }
    return total + maxIncrease;
    }
}