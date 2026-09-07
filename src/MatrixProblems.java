public class MatrixProblems {

    private static void printMatrix(int[][] nums) {
        int m = nums.length;
        int n = nums[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                System.out.print(nums[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void transposeMatrix(int nums[][]){
        int n = nums.length;
        for(int i=0;i<n-1;i++){
            for(int j=i+1; j<n;j++){
                int temp = nums[i][j];
                nums[i][j] = nums[j][i];
                nums[j][i] = temp;
            }
        }
    }

    public static void reverseRow(int nums[]){
        // This is the same as reversing a normal array
        int n = nums.length;
        int start = 0;
        int end = n-1;
        while(start<=end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    //NOTE
    // FOR 90 Degree Rotation : Transpose + Reverse Rows
    // FOR 180 Degree Rotation : Reverse Rows + Reverse Columns
    // FOR 270 Degree Rotation : Transpose + Reverse Columns

    public static void rotate90(int nums[][]){
        int n = nums.length;
        transposeMatrix(nums);
        for(int i=0;i<n;i++){
            reverseRow(nums[i]);
        }
    }

    public static void reverseColumns(int nums[][]){
        int n = nums.length;
        for(int i=0;i<n/2;i++){
            int temp[] = nums[i];
            nums[i] = nums[n-1-i];
            nums[n-1-i] = temp;
        }
    }

    public static void rotate180(int nums[][]){
        int n = nums.length;
        for(int i=0;i<n;i++){
            reverseRow(nums[i]);
        }
        reverseColumns(nums);
    }

    public static void rotate270(int nums[][]){
        int n = nums.length;
        transposeMatrix(nums);
        reverseColumns(nums);
    }

    public static void main(String[] args) {
        int n = 3;
        int nums[][] = new int[n][n];
        nums[0][0] = 1;
        nums[0][1] = 2;
        nums[0][2] = 3;
        nums[1][0] = 4;
        nums[1][1] = 5;
        nums[1][2] = 6;
        nums[2][0] = 7;
        nums[2][1] = 8;
        nums[2][2] = 9;
        System.out.println("Before Rotation :");
        printMatrix(nums);
//        System.out.println("90 Degree Rotation :");
//        rotate90(nums);
//        printMatrix(nums);
//        System.out.println("180 Degree Rotation :");
//        rotate180(nums);
//        printMatrix(nums);
        System.out.println("270 Degree Rotation :");
        rotate270(nums);
        printMatrix(nums);
    }
}
