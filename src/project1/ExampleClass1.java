package project1;

public class ExampleClass1 {
    public void hybridSort (int[] arr, int n, int m, int s){
        // s is the minimum blk size during merge
        if (n+s<=m){
            int mid = (n+m)/2;
            hybridSort(arr, n, mid, s);
            hybridSort(arr, mid+1, m, s);

            merge(arr, n, mid, m);
        }
        else{
            // insertion sort for every minimum blk
            for(int i = n+1; i<=m;i++){
                for (int j=i; j>n ; j--){
                    if (arr[j] < arr[j-1])
                        swap(arr, j-1, j);
                    else
                        break;
                }
            }
        }
    }

    private void merge (int[] arr, int l, int m, int r){
        if (l<r){
            int[] temp = new int[r-l+1];
            int n, i=l, j = m+1;
            for (n = 0;(i<=m && j<=r);){
                if (arr[i] <= arr[j]){
                    temp[n] = arr[i];
                    i++;
                }
                else{
                    temp[n] = arr[j];
                    j++;
                }
                n++;
            }
            while (j<=r || i<=m){
                if (i<=m){
                    temp[n] = arr[i];
                    i++;
                }
                if (j<=r){
                    temp[n] = arr[j];
                    j++;
                }
                n++;
            }
            for (int k=l, h=0;k<=r;k++, h++){
                arr[k] = temp[h];
            }
        }

    }

    private void swap (int[] arr, int i, int j){
        arr[i] = arr[i]^arr[j];
        arr[j] = arr[i]^arr[j];
        arr[i] = arr[i]^arr[j];
    }
}
