import java.util.concurrent.ArrayBlockingQueue;

class Consumidor implements Runnable {
    private ArrayBlockingQueue<Integer> buffer;

    public Consumidor(ArrayBlockingQueue<Integer> buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (true) {
            try {
                int item = buffer.take(); 
                consumirItem(item);
                System.out.println("Consumido: " + item);
                Thread.sleep(1500); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void consumirItem(int item) {
        this.buffer.remove(item);
    }
}