public class Main {
    public static void main(String[] args) {
        // create instances and start threads here
        WorkerThread workerThreadX = new WorkerThread("worker-X");
        WorkerThread workerThreadY = new WorkerThread("worker-Y");

        workerThreadX.start();
        workerThreadY.start();
    }
}

// Don't change the code below
class WorkerThread extends Thread {
    private static final int NUMBER_OF_LINES = 3;

    public WorkerThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        final String name = Thread.currentThread().getName();

        if (!name.startsWith("worker-")) {
            return;
        }

        for (int i = 0; i < NUMBER_OF_LINES; i++) {
            System.out.println("do something...");
        }
    }
}