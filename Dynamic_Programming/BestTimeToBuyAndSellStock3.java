/*
 You are given an array prices where prices[i] is the price of a given stock on the ith day.

Find the maximum profit you can achieve. You may complete at most two transactions.

Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

 

Example 1:

Input: prices = [3,3,5,0,0,3,1,4]
Output: 6
Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
Example 2:

Input: prices = [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are engaging multiple transactions at the same time. You must sell before buying again.
Example 3:

Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.
 

Constraints:

1 <= prices.length <= 105
0 <= prices[i] <= 105
 */

 class Solution {
    int[][][] dp;
    public int maxProfit(int[] prices) {
    /*dp=new int[prices.length+1][2][3];
    /*for(int i=0;i<dp.length;i++){
        for(int j=0;j<dp[0].length;j++){
        for(int k=0;k<dp[0][0].length;k++){
            dp[i][j][k]=-1;  
        }
          
        }
    }*/
    return solveSO(prices);    
    }
    public int solveSO(int[] nums){
    int[][] prev=new int[2][3];
    int[][] curr=new int[2][3];
     for(int i=nums.length-1;i>=0;i--){
    for(int j=0;j<=1;j++){
     for(int k=1;k>=0;k-- ){
     int p1=0,p2=0,p3=0,p4=0;
        if(j==1){
            p1=-nums[i]+prev[0][k];
            p2=0+prev[j][k];
        }
        else{
           p3=nums[i]+prev[1][k+1];
          p4=0+prev[j][k];  
        }
        int a= (int)(Math.max(Math.max(p1,p2),Math.max(p3,p4)));
        curr[j][k]=a;    
     }   
    }
prev=curr;
curr=new int[2][3];
    }
        return prev[1][0];   
    }
    public int solveTab(int[] nums){
    for(int i=nums.length-1;i>=0;i--){
    for(int j=0;j<=1;j++){
     for(int k=1;k>=0;k-- ){
     int p1=0,p2=0,p3=0,p4=0;
        if(j==1){
            p1=-nums[i]+dp[i+1][0][k];
            p2=0+dp[i+1][j][k];
        }
        else{
           p3=nums[i]+dp[i+1][1][k+1];
          p4=0+dp[i+1][j][k];  
        }
        int a= (int)(Math.max(Math.max(p1,p2),Math.max(p3,p4)));
        dp[i][j][k]=a;    
     }   
    }    
    }
        return dp[0][1][0];
    }
    public int solveMem(int[] nums,int i,int buy,int count){
        if(i>=nums.length){
            return 0;
        }
        if(count>=2){
            return 0;
        }
        if(dp[i][buy][count]!=-1){
            return dp[i][buy][count];
        }
        int p1=0,p2=0,p3=0,p4=0;
        if(buy==1){
            p1=-nums[i]+solveMem(nums,i+1,0,count);
            p2=0+solveMem(nums,i+1,buy,count);
        }
        else{
           p3=nums[i]+solveMem(nums,i+1,1,count+1);
          p4=0+solveMem(nums,i+1,buy,count);  
        }
        int a= (int)(Math.max(Math.max(p1,p2),Math.max(p3,p4)));
        dp[i][buy][count]=a;
        return a;
    }
}