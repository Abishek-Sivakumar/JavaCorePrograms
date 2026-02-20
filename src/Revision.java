import java.util.*;

class NewGame{
    public void sayName(String name){
        System.out.println(name);
    }
    public void sayYear(int year){
        System.out.println(year);
    }
}




public class Revision {

    public static void printDivisors(){
        List<Integer> myList = new ArrayList<Integer>();
        int num = 36;
        for(int i=1;i<=Math.sqrt(num);i++){
            if(num%i==0){
//                System.out.println(i);
                myList.add(i);
            }
            if(num/i!=i){
//                System.out.println(num/i);
                myList.add(num/i);
            }
        }
        Collections.sort(myList);
        System.out.println(myList);
    }

    public static void primeNumbers() {
        int num = 36,count=0;
        for(int i=1;i<=Math.sqrt(num);i++){ // This has time comp of O(sq(num))
            // for(int i=1;i*i<=num;i++) This is an alternative with better time complexity
            if(num%i==0){
                count++;
                if(num/i!=i){
                    count++;
                }
            }
        }
        if(count==2){
            System.out.println("Prime number");
        }else{
            System.out.println("Not Prime");
        }
    }

    public static void findGCD(){
        int a = 8;
        int b = 8;
        while(a>0 && b>0){
            if(a>b){
                a=a%b;
            }else{
                b=b%a;
            }
        }
        if(a==0){
            System.out.println("The GCD is : "+ b);
        }else{
            System.out.println("THe GCD is : "+a);
        }
    }

    public static void printByRecursion(int i, int n){
        if(i>n){
            return;
        }
        System.out.println("Abishek");
        i++;
        printByRecursion(i,n);
    }

    public static void print1toN(int i, int n) {
        if(i>n){
            return;
        }
        System.out.println(i);
        print1toN(i+1,n);
    }

    public static void printNto1(int i,int n){
        if(i>n){
            return;
        }
        printNto1(i+1,n);
        System.out.println(i);
    }

    public static void printSumUsingRecursion(int n,int sum){
        if(n<1){
            System.out.println("The Sum is : "+sum);
            return;
        }
        sum=sum+n;
        printSumUsingRecursion(n-1,sum);
    }

    public static int factUsingRecursion(int n){
        if(n==1){
            return 1;
        }
        return n * factUsingRecursion(n-1);
    }

    public static void findNumberofDigits(int num,int count){
        if(num==0){
            System.out.println("The number of digits is : "+count);
            return;
        }
        num=num/10;
        findNumberofDigits(num, count+1);
    }

    public static void printInReverse(int num){
        if(num==0){
            return;
        }
        System.out.print(num%10);
        printInReverse(num/10);
    }

    public static void reverseNumber(int num,int rev){
        if(num==0){
            System.out.println("The reverse of number is : " + rev);
            return;
        }
        int last = num%10;
        num=num/10;
        rev=(rev*10)+last;
        reverseNumber(num,rev);
    }

    public static void reverseArrayOfNumbers(int arr[],int i,int n){
        if(i>=n/2){
            return;
        }
        int temp = arr[i];
        arr[i]=arr[n-i-1];
        arr[n-i-1]=temp;
        reverseArrayOfNumbers(arr,i+1,n);
    }

    public static void selectionTillk(int arr[],int k){
        int n = arr.length;
        for(int m=0;m<k;m++) {
            for (int i = 0; i < n - 1; i++) {
                int min = i;
                for (int j = i + 1; j < n; j++) {
                    if (arr[j] < arr[min]) {
                        min = j;
                    }
                }
                int temp = arr[min];
                arr[min] = arr[i];
                arr[i] = temp;
            }
        }
        for(int i=0;i<k;i++){
            System.out.println(arr[i]);
        }
    }

    public static void selectionSort(int arr[]){
        int n = arr.length;
        for (int i=0;i<n-1;i++){
            int min=i;
            for(int j=i+1;j<n;j++){
                if(arr[j]<arr[min]){
                    min=j;
                }
            }
            int temp = arr[min];
            arr[min]=arr[i];
            arr[i]=temp;
        }
    }

    public static void bubbleSort(int arr[]){
        int n = arr.length;
        for(int i=n-1;i>=0;i--){
            for(int j=0;j<=i-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }

    public static void insertionSort(int arr[]){
        int n = arr.length;
        for(int i=0;i<n;i++){
            int j=i;
            while(j>0 && arr[j]<arr[j-1]){
                int temp = arr[j];
                arr[j]=arr[j-1];
                arr[j-1]=temp;
                j--;
            }
        }
    }

    public static void countFrequency(String sentence){
        String[] words  = sentence.split(" ");
        HashMap<String,Integer> wordsCount = new HashMap<>();
        for(String word: words){
            word=word.toLowerCase();
            if(wordsCount.containsKey(word)){
                wordsCount.put(word, wordsCount.get(word)+1);
                //In order to get the same order use this line and also use LinkedHashMap instead of hashmap
                //wordsCount.put(word,wordsCount.getOrDefault(word,0)+1);
            }else{
                wordsCount.put(word,1);
            }
        }
        for(String key : wordsCount.keySet()){
            System.out.println(key+":"+wordsCount.get(key));
        }
    }

    public static void merge(int[] arr,int low,int mid, int high){
        int n1 = mid-low+1;
        int n2 = high - mid ;
        int[] larr = new int[n1];
        int[] rarr = new int[n2];
        for(int i=0;i<n1;i++){
            larr[i]=arr[low+i];
        }
        for(int i=0;i<n2;i++){
            rarr[i]=arr[mid+1+i];
        }
        int i=0;
        int j=0;
        int k=low;
        while(i<n1 && j<n2){
            if(larr[i]<=rarr[j]){
                arr[k]=larr[i];
                i++;
            }else{
                arr[k]=rarr[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
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

    public static void mergeSort(int[] arr,int low, int high){
        int mid = (low+high) / 2;
        if(low<high){
            mergeSort(arr,low,mid);
            mergeSort(arr,mid+1,high);
            merge(arr,low,mid,high);
        }
    }

    public static LinkedList<Integer> findUnionOfSorted(int[] arr1, int[] arr2){
        int n1 = arr1.length;
        int n2 = arr2.length;
        LinkedList<Integer> res = new LinkedList<>();
        int i=0,j=0;
        while(i<n1 && j<n2){
            if(arr1[i]<=arr2[j]){
                if(res.isEmpty() || res.peekLast()!=arr1[i]){
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
            if(res.isEmpty() || res.peekLast()!=arr2[j]){
                res.add(arr2[j]);
            }
            j++;
        }

        return res;
    }

    public static int longestSubArrayPositives(int[] arr,int k){
        int left=0,right=0,n=arr.length,sum=arr[0],max=0;
        while(right<n){
            while(sum>k && left<=right){
                sum-=arr[left];
                left++;
            }
            if(sum==k){
                max = Math.max(max,right-left+1);
            }
            right++;
            if(right<n){
                sum+=arr[right];
            }
        }
        return max;
    }

    public static void twoSumVersion1(int[] arr,int target){
        Arrays.sort(arr);
        int left=0,right=arr.length-1;
        int sum=0;
        while(left<right){
            sum=arr[left]+arr[right];
            if(sum==target){
                System.out.println("YES");
            }
            if(sum>target){
                right--;
            }else{
                left++;
            }
        }
    }

    public static void twoSumVersion2(int[] arr,int target){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            int needed = target - arr[i];
            if(map.containsKey(needed)){
                System.out.println(map.get(needed)+" "+i);
                break;
            }else{
                map.put(arr[i],i);
            }
        }
    }

    public static void sortArray012(int[] arr){
        //Here we are using the Dutch Flag algorithm to solve this problem
        int low=0,mid=0,high=arr.length-1,temp = 0;
        while(mid<=high){
            if(arr[mid]==0){
                temp = arr[mid];
                arr[mid]=arr[low];
                arr[low]=temp;
                low++;
                mid++;
            }else if(arr[mid]==1){
                mid++;
            }else if (arr[mid]==2){
                temp = arr[high];
                arr[high]=arr[mid];
                arr[mid]=temp;
                high--;
                mid++;
            }
        }
    }

    public static void majorityElement(int[] arr){
        int el = arr[0];
        int count =0;
        for(int i=0;i<arr.length;i++){
            if(count==0){
                el = arr[i];
                count=1;
            }else if(arr[i]==el){
                count++;
            }else{
                count--;
            }
        }
            System.out.println(el + " is the majority element");

    }

    public static void maximumSubArraySum(int[] arr){
        //int arr2[] = {-2,1,-3,4,-1,2,1,-5,4};
        //Here we are using the Kadane's Algorithm
        //Add the commented lines to get the index of start and end of subarray
        int sum =0 ,max = Integer.MIN_VALUE;
//        int start = 0,ansStart = -1,ansEnd = -1;
        for(int i=0;i<arr.length;i++){
//            if(sum==0){
//                start=i;
//            }
            sum+=arr[i];
            if(sum>max){
                max=sum;
//                ansStart = start;
//                ansEnd = i;
            }
            if(sum<0){
                sum=0;
            }
        }
//        System.out.println("The Maximum Subarray Sum is "+max+" from " + ansStart + " to " + ansEnd);
        System.out.println("The Maximum Subarray Sum is "+max);
    }

    public static void main(String[] args) {
        int arr1[] = {1,2,4,7};
        int arr2[] = {-2,1,-3,4,-1,2,1,-5,4};
        maximumSubArraySum(arr2);
//        for(int i=0;i<arr2.length;i++){
//            System.out.print(arr2[i]+" ");
//        }

    }
}
