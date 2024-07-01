class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int check=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]%2!=0){
                check++;
                if(check==3){
            return true;
        }
            }
            else{
                check=0;
            }
        }
        
      
            return false;
    
    }
}
