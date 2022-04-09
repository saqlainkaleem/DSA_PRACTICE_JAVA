public class negativeInOneSideOfArray {
    public static void main(String[] args) {
        int[] arr={-2,-1,2,4,-3,-4,-9,20,-21},narr=new int[arr.length];
        int j=0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]<0){
                narr[j]=arr[i];
                j++;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]>0){
                narr[j]=arr[i];
                j++;
            }
        }
        for (int i = 0; i < narr.length; i++) {
            System.out.print(narr[i] + " ");
        }
    }
}
