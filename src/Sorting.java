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
            //After the first iteration the last element will be the biggest
            //So we traverse from the last -1 position after each i loop
            for(int j=0;j<=i-1;j++){
                if(arr[j]%4==0){
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

    public static void main(String[] args) {
        int[] arr = {4,2,7,1};
        bubbleSort(arr);
        for (int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
