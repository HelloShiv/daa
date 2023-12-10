public class quicksort {
    public static void main(String[] args) {
        int[] arr = {9,7,6,5,4,3,2,1};
        quicksortSol(arr,0,arr.length-1);
        for(int it: arr){
            System.out.print(it + " ");
        }
    }

    static  void quicksortSol(int[] arr , int low , int high){
        if(low > high) return;
        int start = low;
        int end = high;
        int pivot = (low + high)/2;
        while(start<= end){
            while(arr[start]<arr[pivot]){
                start++;
            }
            while(arr[end]>arr[pivot]){
                end--;
            }
            if(start<=end){
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }
        }

        quicksortSol(arr, low, end);
        quicksortSol(arr, start, high);
    }
}
