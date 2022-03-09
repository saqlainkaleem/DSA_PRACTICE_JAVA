public class minimumInArray {
    public static void main(String[] args) {
        int[] arr={12, 25,32,52,4,5,2,5,4};
        System.out.println(Search(arr));
    }

    private static int Search(int[] arr) {
        int a=arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(a>arr[i]){
                a=arr[i];
            }
        }
    return a;}
}
