class myGeneric <T1 ,T2>{
    //class myGeneric <T1 extends Number,T2>
    T1 x;
    T2 y;
    myGeneric(T1 x,T2 y ){
        this.x=x;
        this.y=y;
    }
    public void disp(){
        System.out.println(x+" "+y);
    }
}

public class Generics {


    public static void main(String[] args) {
        Integer[] arr = {2,3,4,5,};
        String[] arr2 = {"Abishek","Deephak"};
        display(arr2);
        System.out.println(getFirst(arr2));
        myGeneric<Integer,String> mg = new myGeneric<>(67,"Abi");
        myGeneric<String,Integer> mg2 =new myGeneric<>("Iron Man",52);
        mg.disp();
        mg2.disp();
    }

    public static <T> void display(T[] arr){
        for(T el : arr){
            System.out.print(el+" ");
        }
    }

    public static <T> T getFirst(T[] arr){
        return arr[0];
    }
}
