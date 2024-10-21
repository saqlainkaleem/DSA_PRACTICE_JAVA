/*Maximal Square


Add to List

Share
Given an m x n binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

 

Example 1:


Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
Output: 4
Example 2:


Input: matrix = [["0","1"],["1","0"]]
Output: 1
Example 3:

Input: matrix = [["0"]]
Output: 0
 

Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 300
matrix[i][j] is '0' or '1'. */
class Solution {
    int[][] dp;
    int max=Integer.MIN_VALUE;
    public int maximalSquare(char[][] matrix) {
     dp=new int[matrix.length][matrix[0].length];
    for(int i=0;i<matrix.length;i++){
        for(int j=0;j<matrix[0].length;j++){
            dp[i][j]=-1;
        }
    }
        int ans=solveTab(matrix);
        return (ans*ans);
    }
    public int solveTab(char[][] mat){
        int[] prev=new int[mat[0].length+1];
        int[] curr=new int[mat[0].length+1];
        int max=Integer.MIN_VALUE;
        
            for(int j=0;j<prev.length;j++){
            prev[j]=0;
            curr[j]=0;
            }
        
        
            for(int k=mat.length-1;k>=0;k--){
            for(int j=mat[0].length-1;j>=0;j--){
        int right=curr[j+1];
         int down=prev[j];
         int diagonal=prev[j+1];
           if(mat[k][j] == '0'){
            curr[j]=0;
            max=(int)Math.max(curr[j],max);
    
        }
        else{
           curr[j]=1+(int)Math.min(right,Math.min(down,diagonal));
            max=(int)Math.max(curr[j],max);    
        }
         
            }
                prev=curr;
                curr=new int[mat[0].length+1];
                
            }
        return max;
        }
        
    
    public int solve(char[][] mat,int i,int j){
        if(i>=mat.length || j>=mat[0].length){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int right=solve(mat,i,j+1);
         int down=solve(mat,i+1,j);
         int diagonal=solve(mat,i+1,j+1);
        if(mat[i][j]=='0'){
            dp[i][j]=0;
            max=(int)Math.max(dp[i][j],max);
            return dp[i][j];
        }
        
            dp[i][j]=1+(int)Math.min(right,Math.min(down,diagonal));
            max=(int)Math.max(dp[i][j],max);
            return dp[i][j];
        }
    
}
