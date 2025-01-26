import java.util.*;
import java.io.*;

class CakeCounter extends Thread {
    int counterVar;
    public synchronized void increment(){
        counterVar++;
    }
}

class Team extends Thread{
    CakeCounter counter;
    Team(CakeCounter counter){
        this.counter=counter;
    }
    public void run(){
        for(int i=0;i<5;i++){
            counter.increment();
        }
    }
}

public class Multithreading {

    public static void main(String[] args) {
//        CakeCounter counter=new CakeCounter();
//        Team t1 = new Team(counter);
//        Team t2 = new Team(counter);
//        t1.start();
//        t2.start();
//        try{
//            t1.join();
//            t2.join();
//        }catch (Exception e){
//
//        }
//        System.out.println(counter.counterVar);


//        ThreadClass t1 = new ThreadClass(2);
//        ThreadClass t2 = new ThreadClass(8);
//        t1.setPriority(2);
//        t2.setPriority(7);
//        t1.setName("Abishek's Thread");
//        t2.setName("Deephak's Thread");
//        t1.start();
//        t2.start();

    }

}


