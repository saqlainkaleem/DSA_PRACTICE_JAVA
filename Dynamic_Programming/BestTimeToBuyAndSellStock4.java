/*
 You are given an integer array prices where prices[i] is the price of a given stock on the ith day, and an integer k.

Find the maximum profit you can achieve. You may complete at most k transactions: i.e. you may buy at most k times and sell at most k times.

Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

 

Example 1:

Input: k = 2, prices = [2,4,1]
Output: 2
Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.
Example 2:

Input: k = 2, prices = [3,2,6,5,0,3]
Output: 7
Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4. Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
 

Constraints:

1 <= k <= 100
1 <= prices.length <= 1000
0 <= prices[i] <= 1000
 */
class Solution {
    int[][][] dp;
    public int maxProfit(int k, int[] prices) {
    dp=new int[prices.length+1][2][k+1];
    /*for(int i=0;i<dp.length;i++){
        for(int j=0;j<dp[0].length;j++){
            for(int m=0;m<dp[0][0].length;m++){
            dp[i][j][m]=-1;
            }
        }
    }*/
    return solveTab(prices,k);
    }
    public int solveTab(int[] nums,int k){
        for(int i=nums.length-1;i>=0;i--){
            for(int j=0;j<=1;j++){
                for(int count=(k-1);count>=0;count--){
    int a=0,b=0,c=0,d=0;
    if(j==1){
    a=-nums[i]+dp[i+1][0][count]; 
    b=0+dp[i+1][j][count];    
    }
        else{
    c=nums[i]+dp[i+1][1][count+1]; 
    d=0+dp[i+1][j][count];      
        }
    dp[i][j][count]=(int)Math.max(Math.max(a,b),Math.max(c,d));
     
                }
            }
        }
        return dp[0][1][0];
    }
    public int solveMem(int[] nums,int i,int buy,int count,int k){
    if(i>=nums.length){
        return 0;
    }
    if(count>=k){
        return 0;
    }
    if(dp[i][buy][count]!=-1){
        return dp[i][buy][count];
    }
    int a=0,b=0,c=0,d=0;
    if(buy==1){
    a=-nums[i]+solveMem(nums,i+1,0,count,k); 
    b=0+solveMem(nums,i+1,buy,count,k);    
    }
        else{
    c=nums[i]+solveMem(nums,i+1,1,count+1,k); 
    d=0+solveMem(nums,i+1,buy,count,k);      
        }
    dp[i][buy][count]=(int)Math.max(Math.max(a,b),Math.max(c,d));
    return dp[i][buy][count];
    }
}