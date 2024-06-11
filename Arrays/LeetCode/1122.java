class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int max=0;
        for(int i=0; i<arr1.length;i++){
            max=Math.max(max,arr1[i]);
        }
        int countArr[] = new int[max+1];
        for(int i=0; i<arr1.length;i++){
            int value=arr1[i];
            countArr[value]++;
        }
        
        int j=0;
        for(int i=0;i<arr2.length;i++){
            int value = arr2[i];
            while(countArr[value]>0){
            arr1[j]=value;
            j++;
            countArr[value]--;
            }
        }
        for(int i=0;i<max+1;i++){
            while(countArr[i]>0){
                arr1[j]=i;
                j++;
                countArr[i]--;
            }
        }
        return arr1;
    }
}
