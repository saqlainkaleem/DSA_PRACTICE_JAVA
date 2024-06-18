class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        Integer[] indices = new Integer[difficulty.length];
    for (int i = 0; i < difficulty.length; i++) {
        indices[i] = i;
    }
    Arrays.sort(indices, (a, b) -> difficulty[a] - difficulty[b]);
    Arrays.sort(worker);
    
    int maxProfit = 0, i = 0, res = 0;
    for (int w : worker) {
        while (i < difficulty.length && difficulty[indices[i]] <= w) {
            maxProfit = Math.max(maxProfit, profit[indices[i++]]);
        }
        res += maxProfit;
    }
    return res;
    }
}
