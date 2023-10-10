import java.util.concurrent.ArrayBlockingQueue;

public class Produtor implements Runnable {

    private ArrayBlockingQueue<Integer> buffer;

    public Produtor(ArrayBlockingQueue<Integer> buffer) {
        this.buffer = buffer;
    }
    @Override
    public void run() {
        while (true) {
            try {
                int item = produzirItem();
                buffer.put(item); 
                System.out.println("Produzido: " + item);
                Thread.sleep(1000); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private int produzirItem() {
        return (int) (Math.random() * 100);
    }
    
}
