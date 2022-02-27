package blockchain;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Function;
import java.util.function.Supplier;

public class ParallelExecutor<T> {
    private final int threads;
    private final int taskCopies;

    public ParallelExecutor(int threads, int taskCopies) {
        this.threads = threads;
        this.taskCopies = taskCopies;
    }

    @SuppressWarnings("unchecked")
    public T execute(Function<Integer, Supplier<T>> function) {
        ExecutorService service = Executors.newFixedThreadPool(threads);
        List<CompletableFuture<T>> futures = new ArrayList<>(taskCopies);

        for (int i = 0; i < taskCopies; i++) {
            futures.add(CompletableFuture.supplyAsync(function.apply(i), service));
        }

        CompletableFuture<Object> future = CompletableFuture.anyOf(futures.toArray(new CompletableFuture[0]));
        T result = (T) future.join();
        service.shutdownNow();
        return result;
    }
}