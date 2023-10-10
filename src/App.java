import java.util.concurrent.ArrayBlockingQueue;

public class App {
    public static void main(String[] args) throws Exception {
        int tamanhoBuffer = 10;

        ArrayBlockingQueue<Integer> buffer = new ArrayBlockingQueue<>(tamanhoBuffer);

        Thread produtorThread = new Thread(new Produtor(buffer));
        Thread consumidorThread = new Thread(new Consumidor(buffer));

        produtorThread.start();
        consumidorThread.start();
    }
}
