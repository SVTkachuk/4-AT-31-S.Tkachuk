package case_4.Threads;

public class PingPong extends Thread{

    final static int[] count = new int[1];
    final static String[] ball = new String[1];

    public PingPong(String name){
        super(name);
    }
    public void run(){
        System.out.println(getName() + " ready");
        while(count[0] < 100){
            synchronized (ball){
                play();
            }

        }

    }
    private void play(){
        if(!getName().equals(ball[0])){
            ball[0]=getName();

        System.out.println(ball[0] + " " + count[0]);
        count[0]++;
        }
    }

}
