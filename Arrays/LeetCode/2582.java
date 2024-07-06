class Solution {
    public int passThePillow(int n, int time) {
        int totalPasses = time % ((n - 1) * 2);
        if (totalPasses <= n - 1) {
            return totalPasses + 1;
        }
        else {
            return n - (totalPasses - (n - 1));}
    }
}