//1486. XOR Operation in an Array
class Solution {
    public int xorOperation(int n, int start) {
        int[] nums=new int[n];
        nums[0]=start+2*0;
        int ans=nums[0];
        for(int i=1;i<n;i++){
            nums[i]=start+2*i;
            ans=ans^nums[i];
        }
        return ans;
    }
}
