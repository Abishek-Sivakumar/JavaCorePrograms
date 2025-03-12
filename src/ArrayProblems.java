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

    public static void main(String[] args) {
        int[] arr = {1,1,1,2,2,3};
        removeDuplicates(arr,arr.length);

    }
}
