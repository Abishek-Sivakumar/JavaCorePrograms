import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class TImerTaskProgram {
    public static void main(String[] args) {
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            int count=10;
            @Override
            public void run() {
                if(count>0){
                    System.out.println("Countdown "+count);
                    count--;
                }else{
                    System.out.println("Very Good");
                    timer.cancel();
                }
            }
        };
//        timer.schedule(timerTask,3000);
        Calendar date= Calendar.getInstance();
        date.set(Calendar.YEAR,2025);
        date.set(Calendar.MONTH,Calendar.JANUARY);
        date.set(Calendar.DAY_OF_MONTH,23);
        date.set(Calendar.HOUR_OF_DAY,23);
        date.set(Calendar.MINUTE,24);
        date.set(Calendar.SECOND,50);
        date.set(Calendar.MILLISECOND,0);
//
//        timer.schedule(timerTask,date.getTime());
//
        timer.scheduleAtFixedRate(timerTask,date.getTime(),1000);


    }
}
