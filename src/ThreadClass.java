public class ThreadClass extends Thread{
    int p;
    public ThreadClass(int p){
        this.p=p;
    }
//    @Override
//    public void run(){
//        if(this.isDaemon()){
//            System.out.println("Daemon Thread");
//        }else{
//            System.out.println("Normal Thread");
//        }
//    }
    @Override
    public void run(){
        System.out.println(this.getPriority());
    }
//    public void displayMsg(){
//        System.out.println("Thread"+this.getName());
//    }
}
