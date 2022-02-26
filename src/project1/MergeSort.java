package project1;

public class MergeSort {
    public void mergeSort (int[] arr, int n, int m){
        // merge until the blk size == 1
        if (n+1<=m){
            int mid = (n+m)/2;
            mergeSort(arr, n, mid);
            mergeSort(arr, mid+1, m);

            merge(arr, n, mid, m);
        }
        else{
            return;
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
}
