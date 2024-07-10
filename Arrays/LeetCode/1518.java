class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int totalBottles = numBottles;
        int emptyBottles = numBottles;
        
        while (emptyBottles >= numExchange) {
            int newBottles = emptyBottles / numExchange;
            totalBottles += newBottles;
            emptyBottles = newBottles + (emptyBottles % numExchange);
        }
        
        return totalBottles;
    }
}
