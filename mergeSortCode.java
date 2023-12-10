// import java.util.Arrays;

import java.util.ArrayList;

public class mergeSortCode {

    public static void main(String[] args) {
        int[] arr = {8,76,34,3,2,1};
        mergeSort(arr,0,arr.length -1);

        for(int i : arr){
            System.out.print(" " + i);
        }

    }

    static void mergeSort(int[] arr , int low , int high){
        if(low < high){
            
        
        int mid = (low + high)/2;
        mergeSort(arr, low, mid);
        mergeSort(arr,mid+1,high);
        merge(arr,low,mid,high);
        }
    }

    static void merge(int[] arr , int low , int mid , int high){
        java.util.ArrayList<Integer> temp = new ArrayList<>();
        int left = low ;
        int right = mid + 1;
        while(left <= mid && right <= high){
            if(arr[left] <= arr[right]){
                temp.add(arr[left]);
                left++;
            }else{
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
        for(int value : temp){
            arr[index] = value;
            index++;
        }
    }
}
