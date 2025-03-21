import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ArrayProblems {
    //Easy Problems {2,4,4,5,7,8};
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
        reverseArray(arr, d,n-1); //Reverse after d {2,1,7,6,5,4,3}
        reverseArray(arr,0,n-1); //Now reverse the whole array for answer {3 4 5 6 7 1 2}
    }

    public static int[] moveZerosToEnd(int[] arr,int n){
        int j=-1;
        for(int i=0;i<n;i++){ //To find the first occurrence of zero in the given array
            if(arr[i]==0){
                j=i;
                break;
            }
        }

        if(j==-1){
            return arr;
//            return arr since there are no zeros in the given array .Without this the test case fails in codeninja;
        }

        for(int i=j+1;i<n;i++){ //{1,2,4,4,0,0,0,5,0,6}
            if(arr[i]!=0){
                arr[j]=arr[i];
                arr[i]=0;
                j++;
            }
        }
        return arr;
    }

    public static void linearSearch(int[] arr,int n,int k){
        int pos=-1;
        for(int i=0;i<n;i++){
            if(arr[i]==k){
                pos=i+1;
                break;
            }
        }
        if(pos==-1){
            System.out.println("Element not found");
        }else{
            System.out.println("Element found at position "+pos);
        }
    }

    public static List<Integer> unionOfSorted(int[] arr1, int[] arr2){
        //int[] arr1 = {1,2,4,4,5,6};
        //int[] arr2 = {2,4,5,5,7,8};
        LinkedList<Integer> res = new LinkedList<Integer>();

        int n1= arr1.length;
        int n2= arr2.length;
        int i=0;
        int j=0;
        while(i<n1 && j<n2){
            if(arr1[i]<=arr2[j]){
                if(res.size()==0 || res.peekLast()!=arr1[i]){
                    res.add(arr1[i]);
                }
                i++;
            }else{
                if(res.isEmpty() || res.peekLast()!=arr2[j]){
                    res.add(arr2[j]);
                }
                j++;
            }
        }

        while(i<n1){
            if(res.isEmpty() || res.peekLast()!=arr1[i]){
                res.add(arr1[i]);
            }
            i++;
        }

        while(j<n2){
            if(res.size()==0 || res.peekLast()!=arr2[j]){
                res.add(arr2[j]);
            }
            j++;
        }

        List<Integer> finalResult = new ArrayList<>(res);

        return finalResult;
    }

    public static List<Integer> intersectionOfSorted(int[] arr1,int[] arr2 ){
        //The problem is this will return 4,4 as two distinct pairs rather than the same element
        //It will return all the distinct pairs instead of the distinct individual elements
        List<Integer> ans = new ArrayList<>();
      int n1= arr1.length;
      int n2= arr2.length;
      int i=0,j=0;
      while(i<n1 && j<n2){
          if(arr1[i]<arr2[j]){
              i++;
          }else if(arr2[j]<arr1[i]){
              j++;
          }else{ //ie both the arr1[i] and arr2[j] are equal
              ans.add(arr1[i]);
              i++;
              j++;
          }
      }
      return ans;
    }

    public static void findMissingNumber(int[] arr){
        //{1,2,4}
        //METHOD 1
//        int n = arr.length;
//        int sum = ((n+1)*(n+2))/2; //This will be equal to 10
//        System.out.println(sum);
//        int s2 = 0;
//        for(int i=0;i<n;i++){
//            s2+=arr[i];
//        } //Now s2 will be 7 The  10-7 gives 3 which is the missing number
//        System.out.println("The missing number is "+ (sum-s2));
//        This method may not be optimal since the array size can be 10 power 5 which will result in not storing the sum in int

        //METHOD 2
        //{1,2,4}
        int n=arr.length;
        int xor1 = 0;
        int xor2 = 0;
        for(int i=0;i<n;i++){
            xor1 = xor1 ^ (i+1); //This will store the xor values upto 1,2,3 .We must add the xor 4 after loop
            xor2 = xor2 ^ arr[i]; //THis will store the xor values of 1,2,4
        }
        xor1 = xor1 ^ (n+1); //THIS IS VERY IMPORTANT SINCE WE MUST INCLUDE THE LAST NUMBER ALSO FOR XOR
        System.out.println("The missing number is "+ (xor1 ^ xor2));
    }

    public static void onceNotTwice(int[] arr){
        int n=arr.length;
        int xor = 0;
        for(int i=0;i<n;i++){
            xor = xor ^ arr[i];
        }
        System.out.println("The element that appears once is "+xor);
    }

    public static void longestSubarrayWithSumK(int[] arr,int k){
        //VERY IMPORTANT
        //This method only works if there are positive or zeros in the array
        //It will not work if the array contains negative numbers
        int n= arr.length;
        int left = 0;
        int right = 0;
        long sum=arr[0]; //Since the sum can be very large
        int maxLen = 0;
        while(right<n){
            while(left<=right && sum>k){
                //If the sum exceeds the value k,
                // Then subtract one element ie the left element to make it less than or equal to k
                //Repeat the looping until it becomes less tha or equal to k
                sum-=arr[left];
                left++;
            }
            // If the sum == k , then assign the max of maxLen and i-j+1 to maxLen
            if(sum==k){
                maxLen = Math.max(maxLen,right-left+1);
            }

            //This step is crucial
            //The right element will be added to sum
            //Before adding we must check whether right++ indicates out of bounds or not ie one position after the last index
            right++;
            if(right<n){
                sum+=arr[right];
            }
        }
        System.out.println("The Maximum subarray is "+maxLen);
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,1,1,1,1};
        longestSubarrayWithSumK(arr,3);
//        removeDuplicates(arr2,arr2.length);
//        linearSearch(arr,arr.length,4);
//        List<Integer> res = intersectionOfSorted(arr1,arr2);
//        for(int i=0;i<arr2.length;i++){
//            System.out.print(arr2[i]+" ");
//        }
//        System.out.println(res);

    }
}

//public static List<Integer> findUnion2(int[] arr1 ,int[] arr2){
//    LinkedList<Integer> res = new LinkedList<>();
//    int n1= arr1.length;
//    int n2= arr2.length;
//    int i=0;
//    int j=0;
//    while(i<n1 && j<n2){
//        if(arr1[i]<=arr2[j]){
//            if(res.isEmpty() || res.peekLast()!=arr1[i]){
//                res.add(arr1[i]);
//            }
//            i++;
//        }else {
//            if (res.isEmpty() || res.peekLast() != arr2[j]) {
//                res.add(arr2[j]);
//                j++;
//            }
//            j++;
//        }
//    }
//    while(i<n1){
//        if(res.isEmpty() || res.peekLast()!=arr1[i]){
//            res.add(arr1[i]);
//            i++;
//        }
//    }
//    while(j<n2){
//        if(res.isEmpty() || res.peekLast()!=arr2[j]){
//            res.add(arr2[j]);
//            j++;
//        }
//    }
//    List<Integer> ans = new ArrayList<>(res);
//    return ans;
//}
//
//public static List<Integer> findIntersection2(int[] arr1,int[] arr2){
//    List<Integer> res = new ArrayList<>();
//    int n1= arr1.length;
//    int n2 =arr2.length;
//    int i=0,j=0;
//    while(i<n1 && j<n2){
//        if(arr1[i]<arr2[j]){
//            i++;
//        }else if(arr2[j]<arr1[i]) {
//            j++;
//        }else{
//            res.add(arr1[i]);
//            i++;
//            j++;
//        }
//    }
//    return res;
//}
//
//public static int[] findSecondLargest2(int[] arr){
//    int largest=arr[0],n=arr.length,slargest=Integer.MIN_VALUE;
//    for(int i=1;i<n;i++){
//        if(arr[i]>largest){
//            slargest=largest;
//            largest=arr[i];
//        }else if(arr[i]<largest && arr[i]>slargest){
//            slargest=arr[i];
//        }
//    }
//    return new int[]{largest,slargest};
//}
//
//public static void reverse2(int[] arr,int start,int end){
//    while(start<end){
//        int temp = arr[start];
//        arr[start] = arr[end];
//        arr[end]=temp;
//        start++;
//        end--;
//    }
//}
//
//public static void leftRotate2(int[] arr,int d){
//    reverse2(arr,0,d-1);
//    reverse2(arr,d,arr.length-1);
//    reverse2(arr,0, arr.length-1);
//}
//
//public static int[] moveZerosToEnd2(int[] arr){
//    int n=arr.length;
//    int j=-1;
//    for(int i=0;i<n;i++){
//        if(arr[i]==0){
//            j=i;
//            break;
//        }
//    }
//    if(j==-1){
//        return arr;
//    }
//    //{2,4,5,0,0,0,5,7,8}
//    for(int i=j+1;i<n;i++){
//        if(arr[i]!=0){
//            arr[j]=arr[i];
//            arr[i]=0;
//            j++;
//        }
//    }
//    return arr;
//}
//
//public static void removeDuplicates2(int[] arr){
//    int n= arr.length;
//    int i=0;
//    for(int j=1;j<n;j++) {
//        if (arr[j] != arr[i]) {
//            arr[i + 1] = arr[j];
//            i++;
//        }
//    }
//}