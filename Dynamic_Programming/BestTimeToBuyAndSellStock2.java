/*
 You are given an integer array prices where prices[i] is the price of a given stock on the ith day.

On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. However, you can buy it then immediately sell it on the same day.

Find and return the maximum profit you can achieve.

 

Example 1:

Input: prices = [7,1,5,3,6,4]
Output: 7
Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
Total profit is 4 + 3 = 7.
Example 2:

Input: prices = [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
Total profit is 4.
Example 3:

Input: prices = [7,6,4,3,1]
Output: 0
Explanation: There is no way to make a positive profit, so we never buy the stock to achieve the maximum profit of 0.
 

Constraints:

1 <= prices.length <= 3 * 10^4
0 <= prices[i] <= 10^4
 */

 class Solution {
    int[][] dp;
     public int maxProfit(int[] prices) {
        
     /*dp=new int[prices.length+1][2];*/
    
     return SO(prices);    
     }
     public int solveTab(int[] nums,int[][] dp){
      for(int i=nums.length-1;i>=0;i--){
          for(int j=1;j>=0;j--){
           int p1=0,p2=0,p3=0,p4=0;
         if(j==1){
             p1=-nums[i]+dp[i+1][0];
             p2=0+dp[i+1][j];
         }
         else{
         p3=nums[i]+dp[i+1][1];
         p4=0+dp[i+1][j];
         }
         dp[i][j]=(int)(Math.max(Math.max(p1,p2),Math.max(p3,p4)));   
          }
      }
     return dp[0][1];
     }
     public int SO(int[] nums){
     int[] curr=new int[2];
     int[] prev=new int[2];
       for(int i=nums.length-1;i>=0;i--){
          for(int j=1;j>=0;j--){
           int p1=0,p2=0,p3=0,p4=0;
         if(j==1){
             p1=-nums[i]+prev[0];
             p2=0+prev[j];
         }
         else{
         p3=nums[i]+prev[1];
         p4=0+prev[j];
         }
         curr[j]=(int)(Math.max(Math.max(p1,p2),Math.max(p3,p4)));   
          }
          prev=curr;
           curr=new int[2];
      }
     return prev[1];   
     }
     // maxPro represents memoization
     public int maxPro(int[] nums,int buy,int i){
         if(i>=nums.length){
             return 0;
         }
         if(dp[i][buy]!=-1){
             return dp[i][buy];
         }
         int p1=0,p2=0,p3=0,p4=0;
         if(buy==1){
             p1=-nums[i]+maxPro(nums,0,i+1);
             p2=0+maxPro(nums,1,i+1);
         }
         else{
         p3=nums[i]+maxPro(nums,1,i+1);
         p4=0+maxPro(nums,buy,i+1);
         }
         dp[i][buy]=(int)(Math.max(Math.max(p1,p2),Math.max(p3,p4)));
         return dp[i][buy];
     }
 }