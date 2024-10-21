/*
 You are given an array prices where prices[i] is the price of a given stock on the ith day, and an integer fee representing a transaction fee.

Find the maximum profit you can achieve. You may complete as many transactions as you like, but you need to pay the transaction fee for each transaction.

Note:

You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
The transaction fee is only charged once for each stock purchase and sale.
 

Example 1:

Input: prices = [1,3,2,8,4,9], fee = 2
Output: 8
Explanation: The maximum profit can be achieved by:
- Buying at prices[0] = 1
- Selling at prices[3] = 8
- Buying at prices[4] = 4
- Selling at prices[5] = 9
The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
Example 2:

Input: prices = [1,3,7,5,10,3], fee = 3
Output: 6
 

Constraints:

1 <= prices.length <= 5 * 10^4
1 <= prices[i] < 5 * 10^4
0 <= fee < 5 * 10^4
 */

 class Solution {
    int[][] dp;
    public int maxProfit(int[] prices, int fee) {
    dp=new int[prices.length+1][2];
    for(int i=0;i<dp.length;i++){
        for(int j=0;j<dp[0].length;j++){
            dp[i][j]=-1;
        }
    }
    return solveMem(prices,1,0,fee);
    }
    
    public int solveMem(int[] nums,int buy,int i,int fee){
        if(i>=nums.length){
            return 0;
        }
        if(dp[i][buy]!=-1){
            return dp[i][buy];
        }
        int p1=0,p2=0,p3=0,p4=0;
        if(buy==1){
        p1=-nums[i]+solveMem(nums,0,i+1,fee); 
        p2=0+solveMem(nums,buy,i+1,fee);
        }
        else{
        p3=-fee+nums[i]+solveMem(nums,1,i+1,fee); 
        p4=0+solveMem(nums,buy,i+1,fee);   
        }
        dp[i][buy] = (int)Math.max(Math.max(p1,p2),Math.max(p3,p4));
        return dp[i][buy];
        
    }
}