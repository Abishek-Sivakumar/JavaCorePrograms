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

    public static void leftRotateByBrute(int[] arr,int n,int d){ //This is the Brute force approach
        // d represents the number of rotations
        int[] temp = new int[d]; //Lets say d =3
        for(int i=0;i<d;i++){ // First we store the d-1 ie 3 elements in temp array
            temp[i]=arr[i];
        }
        for(int i=d;i<n;i++){ //Next we move the elements from 3rd to nth index to the first 3 index
            arr[i-d]=arr[i]; // Here d represents 3 and i-d represents the 3-3=0 ,4-3=1, 5-3=2 and place the elements there
        }
        for(int i=n-d;i<n;i++){ //Here the starting is n-d since we will now have {4,5,6,7,     5,6,7,} we must replace these 5,6,7 with temp arr elements
            arr[i]=temp[i-(n-d)]; //here i = 7-3 =4 indicates we start from the 4rth index
        }                         // Also i-(n-d) = 4-(7-3) = 0th index of temp arr and so on 5-(7-3) = 1
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        leftRotateByBrute(arr,arr.length,2);
//        int[] slargest = findSecondLargest(arr,arr.length);
//        removeDuplicates(arr,arr.length);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }


    }
}
