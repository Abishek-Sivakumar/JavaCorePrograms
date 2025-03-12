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
        int largest = arr[0];
        int slargest = Integer.MIN_VALUE;
        for(int i=1;i<n;i++){
            if(arr[i]>largest){
                slargest=largest;
                largest=arr[i];
            }else if(arr[i]<largest && arr[i]>slargest){
                slargest=arr[i];
            }
        }
        return new int[]{largest,slargest};
    }

    public static void main(String[] args) {
        int[] arr = {1,1,1,2,2,3};
        int[] slargest = findSecondLargest(arr,arr.length);
//        removeDuplicates(arr,arr.length);
        for(int i=0;i<slargest.length;i++){
            System.out.print(slargest[i]+" ");
        }
    }
}
