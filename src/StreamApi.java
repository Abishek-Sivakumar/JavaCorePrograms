import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Stream;

public class StreamApi {
    public static void main(String[] args) {

        List<Integer> integerList = Arrays.asList(3,1,13,6,2,4);

//        integerList.forEach(num-> System.out.println(num));

//        System.out.println(integerList);
//        for(int num: integerList){
//            System.out.println(num);
//        }

        Stream<Integer> s1 = integerList.stream();
        Stream<Integer> s2 = s1.filter(num->num%2==0); // A Stream can only be used once that's why initiate a new stream every time
        Stream<Integer> s3 = s2.map(num->num*2);

        Stream<Integer> result=integerList.stream()
                .filter(num->num%2==0)
                .map(num->num*2);
//                .reduce(0,(c,e)->c+e);
        ArrayList<Integer> doubleOfEven= new ArrayList<>();
        result.forEach(n-> doubleOfEven.add(n));
        System.out.println(doubleOfEven);

//        int sum=0;
//        for (int num:integerList){
//            if(num%2==0){
//                num*=2;
//                sum*=num;
//            }
//        }
    }
}
