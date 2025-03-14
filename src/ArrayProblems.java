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
        System.out.println("\nThe number of elements in final array is "+(i+1));
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

    public static void reverseArray(int[] arr,int start,int end){
        while(start<=end){
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
    }

    public static void leftRotateByReverseMethod(int[] arr,int n,int d){
        //int[] arr = {1,2,3,4,5,6,7}; For this array
        //This is the Optimal solution aka the reverse method to rotating an array  .
        // The time complexity is O(d) + O(n-d) + O(n) = O(2N) and the space complexity is O(1) since no new temp array is used like in Brute Force
        //FOR RIGHT ROTATION SUBTRACT THE D FORM N TO GET THE NEW D which is m
        //int D = d%n;
        //int m = nums.length - D;
        reverseArray(arr,0,d-1); // Reverse the array {2,1, 3,4,5,6,7,} ...Use m for right rotation
        reverseArray(arr,d,n-1); //Reverse after d {2,1,7,6,5,4,3}
        reverseArray(arr,0,n-1); //Now reverse the whole array for answer {3 4 5 6 7 1 2}
    }

    public static void moveZerosToEnd(int[] arr,int n){
        int j=-1;
        for(int i=0;i<n;i++){ //To find the first occurrence of zero in the given array
            if(arr[i]==0){
                j=i;
                break;
            }
        }

        if(j==-1){
//            return arr since there are no zeros in the given array .Without this the test case fails in codeninja;
        }

        for(int i=j+1;i<n;i++){
            if(arr[i]!=0){
                arr[j]=arr[i];
                arr[i]=0;
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,0,2,3,0,0,0,4,5,6,7};
        moveZerosToEnd(arr,arr.length);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }


    }
}
