package project1;

public class InsertionSort {
    public void insertionSort (int[] arr){
        if (arr == null)
            return;
        for (int i=1; i<arr.length; i++){
            for (int j=i; j>0;j--){
                if (arr[j] < arr[j-1])
                    swap(arr, j-1, j);
                else
                    break;

            }
        }
    }

    private void swap (int[] arr, int i, int j){
        arr[i] = arr[i]^arr[j];
        arr[j] = arr[i]^arr[j];
        arr[i] = arr[i]^arr[j];
    }
}
