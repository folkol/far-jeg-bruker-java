import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ConcurrencyTest {

    private static final int LOADS = 1000000;

    public static void main(String[] args) throws Exception {
        Concurrency target = new Concurrency();
        target.sharedX = 0;

        addMillionTimes(target);

        if(target.sharedX != LOADS) {
            System.out.println(String.format("Fail! (Expected target.x to be %d, but it was %d)", LOADS, target.sharedX));
        } else {
            System.out.println("Success!");
        }
    }

    private static void addMillionTimes(final Concurrency target) throws InterruptedException {
        Runnable task = new Runnable() {
            @Override
            public void run() {
                target.addOne();
            }
        };

        final ExecutorService executor = Executors.newFixedThreadPool(10);
        for (int i = 0; i < LOADS; i++) {
            executor.execute(task);
        }
        executor.shutdown();
        executor.awaitTermination(30, TimeUnit.SECONDS);
    }
}
