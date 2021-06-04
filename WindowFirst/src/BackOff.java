import java.util.Timer;
import java.util.TimerTask;

public class BackOff {
	int y=600;
	public void sety() {
		 y=y-1;
	}
	public int gety() {
		return y;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Timer timer = new Timer();
		BackOff off=new BackOff();
        TimerTask  task = new TimerTask (){
         public void run() {
        	 off.sety();
        	 if(off.gety()>0) {
        			
        	      System.out.println(off.gety());
        		 }else {
        		 timer.cancel();}
           }
         
};
timer.schedule (task, 1000L, 1000L); //每秒閃爍一次游標

	}

}
