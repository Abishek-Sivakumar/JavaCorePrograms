import java.util.Arrays;

public class Sorting {
    static void selectionSort(int[] arr){ // The Time Complexity is O(Nsquare);
        //we select the minimum and then swap aith the index
        int n=arr.length;
        for(int i=0;i<=n-2;i++){ //or i<n-1
            //Here n-2 since the last element will be sorted after all iterations
            int min=i; // The loop is at element 3
            for(int j=i;j<=n-1;j++){ // or j<n
                //3 2 7 1
                //To iterate through the remaining elements except 3 ie 2 7 1
                if(arr[j]<arr[min]){
                    min=j;
                }
            }
            int temp=arr[min];
            arr[min]=arr[i];
            arr[i]=temp;
        }
    }

    static void bubbleSort(int[] arr){
        int n=arr.length;
        int didSwap=0;
        for(int i=n-1;i>=0;i--){
            //Adjacent Swapping
            //After the first iteration the last element will be the biggest
            //So we traverse from the last -1 position after each i loop
            for(int j=0;j<=i-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp =  arr[j+1];
                    arr[j+1]=arr[j];
                    arr[j]=temp;
                    didSwap=1;
                }
            }
            if(didSwap==0){
                //If there is no swap after the first iteraion then we will break the loop since the given array is already sorted
                //With this block of the time complexity becomes O(N) else O(Nsquare)
                break;
            }
        }
    }

    static void insertionSort(int[] arr){
        //Worst case is O(Nsquare) and best case is O(N)
        int n=arr.length;
        for(int i=0;i<=n-1;i++){
            int j=i;
            while(j>0 && arr[j-1]>arr[j]){
                int temp=arr[j];
                arr[j]=arr[j-1];
                arr[j-1]=temp;
                j--;
            }
        }
    }

    static void mergeSort(int[] arr,int l,int r){
        if(l<r){
            int mid=(l+r)/2;
            mergeSort(arr,l,mid);
            mergeSort(arr,mid+1,r);
            merge(arr,l,mid,r);
        }
    }


    private static void merge(int[] arr, int l, int mid, int r) {
        //For the array {4,2,7,1,3}
        int n1= mid - l + 1; // To find the size of the array => 2-0+1 = 3
        int n2= r-mid; // To find the size of the array => 5-2=3

        int[] larr = new int[n1]; //Creating two new arrays which contain the values of arr in two separate arrays
        int[] rarr = new int[n2];


        for(int i=0;i<n1;i++){
            larr[i]=arr[l+i]; // Allocating the left side of the arr to the array larr
        }

        for(int i=0;i<n2;i++){
            rarr[i]=arr[mid+1+i]; //Allocating the right side of the arr to rarr
        }

        int i=0;
        int j=0;
        int k=l; // Here it is not zero because the staring index of the array is l and not 0

        while(i<n1 && j<n2){ // Loop until we run out of elements in any one of the array
            if(larr[i]<=rarr[j]){
                arr[k]=larr[i];
                i++;
            }else{
                arr[k]=rarr[j];
                j++;
            }
            k++;
        }

        while(i<n1){ //Checking and filling the remaining elements of the larr in arr
            arr[k]=larr[i];
            i++;
            k++;
        }

        while(j<n2){
            arr[k]=rarr[j];
            j++;
            k++;
        }

    }

    private static void quickSort(int[] arr, int low ,int high) {
        if(low<high){
            int part = partition(arr,low,high);
            quickSort(arr,low,part-1);
            quickSort(arr,part+1,high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low;
        int j = high;

        while (i < j) {
            while (arr[i] <= pivot && i < high - 1) {
                i++;
            }
            while (arr[j] > pivot && j >= low + 1) {
                j--;
            }
            if (i < j) {
                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Swap pivot with arr[j]
        int temp = arr[j];
        arr[j] = arr[low];
        arr[low] = temp;

        return j; // Return the correct pivot index after the swap
    }

    public static void main(String[] args) {
        int[] arr = {4,2,7,1,3};
//        int[] result = Arrays.stream(arr).distinct().sorted().toArray();
        quickSort(arr,0,arr.length-1);
        for (int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }


}
