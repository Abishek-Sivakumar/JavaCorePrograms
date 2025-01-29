import org.w3c.dom.ls.LSInput;

import java.util.*;

public class Hashing {
    public static void main(String[] args) {
////        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        String s = "Abisshek";
        int s = 2334;
        HashMap<Character,Integer> hashMap = new HashMap<>();
        char[] arr = String.valueOf(s).toCharArray();
        for(char c:arr){
            if(hashMap.containsKey(c)){
                hashMap.put(c,hashMap.get(c)+1);
            }else{
                hashMap.put(c,1);
            }
        }

        for(Map.Entry entry : hashMap.entrySet()) {
            System.out.println("Element " + entry.getKey() + " occurs " + entry.getValue());
        }


     }
}
