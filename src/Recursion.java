class Rec{
    int count=1;
    int[] arr = {3,2,1,2};
    public void printNum1to10(int n){
        if(count>4){
            return;
        }else{
            System.out.println(count);
            count++;
            printNum1to10(n+1);
        }
    }

    public void printNum10to1(int n){
        if(n<1){
            return;
        }else{

            printNum10to1(n-1);
            System.out.println(n);
        }
    }
    public void parameterizedSum(int i,int sum){
        //Here parameterized means getting the value of i also from the user
        if(i<1){
            System.out.println(sum);
            return;
        }
        parameterizedSum(i-1,sum+i);
    }

    public int functionalSum(int n){
        if(n==0){
            return 0; // Here the base case can return 0 or stop with n==1 return 1 since we are adding the numbers
        }else {
            return n + functionalSum(n-1);
        }
    }

    public int functionalFactorial(int n){
        if(n==1){ // if(n==0)
            return 1; // Here the base case must return 1 since multiply with 0 will result in final ans as 0
        }else{
            return n*functionalFactorial(n-1);
        }
    }

    public void reverseArray(int i, int n) {
        if(i>=n/2){
            return;
        }
        int temp=this.arr[i];
        this.arr[i]=this.arr[n-i-1];
        this.arr[n-i-1]=temp;
        reverseArray(i+1,n);
    }

    public boolean checkPalindrome(int i,String word){
        if(i>=word.length()){
            return true;
        }
        if(word.charAt(i)!=word.charAt(word.length()-i-1)){
            return false;
        }
        return checkPalindrome(i+1,word);
    }

    public void dispArray() {
        System.out.println(this.arr);
    }
}

public class Recursion {
    public static void main(String[] args) {
        Rec r = new Rec();
        boolean ans = r.checkPalindrome(0,"MADM");
        System.out.println(ans);

    }
}
