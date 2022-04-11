public abstract class twoSum {
    public static void main(String[] args) {
        int[] arr = {5,4,52,4,5,2,5,6,2,3,5,120};
        bubble(arr);
        printArray(arr);
    }

    private static void printArray(int[] arr) {
        for (int j : arr) {
            System.out.print(j + " ");
        }
    }

    private static void bubble(int[] arr) {
        boolean swapped;
        for (int i = 0; i < arr.length; i++) {
            swapped=false;
            for (int j = 1; j < arr.length-i ; j++) {
                if (arr[j]<arr[j-1]){
                    int temp =arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=temp;
                    swapped=true;
                }
            }
            if (!swapped){
                break;
            }
        }

    }
}