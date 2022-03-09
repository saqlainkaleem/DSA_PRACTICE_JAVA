public class minimumInArray {
    public static void main(String[] args) {
        int[] arr={12, 25,32,52,4,5,2,5,4};
        System.out.println(Search(arr));
    }

    private static int Search(int[] arr) {
        int element=arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(element>arr[i]){
                element=arr[i];
            }
        }
    return element;
    }
}
