import java.util.ArrayList;

public class mergeSort {
    public static void main(String[] args) {
        int[] arr = {9,8,7,6,5,4,3,2,1};
        mergeSortFunc(arr,0,arr.length-1);
        // java.util.Arrays.sort(arr);
        for(int i : arr){
            System.out.print(i + " ");
        }
    }

    static void mergeSortFunc(int[] arr , int low , int high){
        if(low >= high) return;
        int mid = (low + high)/2;
        mergeSortFunc(arr, low, mid);
        mergeSortFunc(arr,mid+1,high);
        merge(arr,low,mid,high);
    }

    static void merge(int[] arr , int low , int mid , int high){
        java.util.ArrayList<Integer> temp = new ArrayList<>();
        int left = low;
        int right = mid + 1;

        while(left <= mid && right <= high){
            if(arr[left] < arr[right]){
                temp.add(arr[left]);
                left++;
            } else{
                temp.add(arr[right]);
                right++;
            }
        }
        while(left <= mid){
                temp.add(arr[left]);
                left++;
        }
        while(right <= high){
                temp.add(arr[right]);
                right++;
        }
        int index = low;
        for(int i : temp){
            arr[index] = i;
            index++;
        }
    }
}
