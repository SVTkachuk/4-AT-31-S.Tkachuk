package case_4.Threads;

public class PingPongMain {
    public static void main(String[] args) {
        //Make two threads and connect them to play a Ping-Pong game. One thread should write “ping” to the console,
        // another - “pong”. Each thread should add his own name to his message. It will be good to finish that game after a few seconds.
        // Try to use Executors and different implementation of Thread

        PingPong player1 = new PingPong("ping");
        PingPong player2 = new PingPong("pong");
        player1.start();
        player2.start();
    }
}
