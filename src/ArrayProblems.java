import java.util.Arrays;

public class ArrayProblems {
    //Easy Problems
    public static void removeDuplicates(int[] arr ,int n){
        int i=0;
        for(int j=1;j<n;j++){
            if(arr[i]!=arr[j]){
                arr[i+1]=arr[j];
                i++;
            }
        }

        //return i+1 to return the number of elements in the resultant array

        for(int k=0;k<i+1;k++){
            System.out.print(arr[k]+" ");
        }
        System.out.println("\nThe number of elements in sorted array is "+(i+1));
    }

    public static int[] findSecondLargest(int[] arr,int n){
        //For the second smallest see the comments
        int largest = arr[0];
        int slargest = Integer.MIN_VALUE; // for second smallest just initialize this as Integer.MAX_VALUE
        for(int i=1;i<n;i++){
            if(arr[i]>largest){ //arr[i]<smallest
                slargest=largest;
                largest=arr[i];
            }else if(arr[i]<largest && arr[i]>slargest){ //arr[i]>smallest && arr[i]<ssmallest
                slargest=arr[i];
            }
        }
        return new int[]{largest,slargest};
    }

    public static void leftRotateByOne(int[] arr,int n){
        int temp=arr[0];
        for(int i=1;i<n;i++){
            arr[i-1]=arr[i];
        }
        arr[n-1]=temp;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,1,2,2,3};
        leftRotateByOne(arr,arr.length);
//        int[] slargest = findSecondLargest(arr,arr.length);
//        removeDuplicates(arr,arr.length);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }


    }
}
