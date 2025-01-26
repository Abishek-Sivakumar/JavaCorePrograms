import java.util.*;

class Cognizant{

}

class CognizantUSA<T> extends Cognizant{
    ArrayList<String> arr;
    public CognizantUSA(){
        arr=new ArrayList<>();
        arr.add("John");
        arr.add("David");
    }
}

class CognizantIndia<T> extends Cognizant {
    ArrayList<String> arr;
    public CognizantIndia(){
        arr=new ArrayList<>();
        arr.add("Steve");
        arr.add("Michael");
    }
}


public class JavaCollections {

    public void display(ArrayList<? extends CognizantUSA> ar){
        System.out.println(ar);
    }

    public static void main(String[] args) {
        CognizantUSA us = new CognizantUSA();
        CognizantIndia ind = new CognizantIndia();
        JavaCollections j = new JavaCollections();
        j.display(ind.arr);
    }
}