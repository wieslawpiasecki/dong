package com.wpi.asynch;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.google.common.base.Function;
import com.google.common.collect.FluentIterable;

public class ParallelExecutorService {
    private ExecutorService executorService = Executors.newFixedThreadPool(30);

    public <T, V> List<V> execute(List<T> tasks, Function<T, V> execution) throws ExecutionException, InterruptedException {
        List<Future<V>> futureTasks = executeTasks(tasks, execution);
        return resolveFutureTasks(futureTasks);
    }

    public void execute(Runnable runnable) {
        executorService.execute(runnable);
    }

    private <T, V> List<Future<V>> executeTasks(List<T> tasks, Function<T, V> execution) {
        return FluentIterable.from(tasks).transform(new ParallelTaskExecutor<T, V>(execution)).toList();
    }

    public void cleanup() {
        executorService.shutdown();
    }

    private <V> List<V> resolveFutureTasks(List<Future<V>> futureTasks) throws InterruptedException, ExecutionException {
        List<V> results = new ArrayList<V>();
        for (Future<V> futureTask : futureTasks) {
            results.add(futureTask.get());
        }
        return results;
    }

    private class ParallelTaskExecutor<T, V> implements Function<T, Future<V>> {
        private final Function<T, V> execution;

        public ParallelTaskExecutor(Function<T, V> execution) {
            this.execution = execution;
        }

        @Override
        public Future<V> apply(T input) {
            return executeTaskAsynchronously(input);
        }

        private Future<V> executeTaskAsynchronously(final T input) {
            return executorService.submit(new Callable<V>() {
                @Override
                public V call() throws Exception {
                    return execution.apply(input);
                }
            });
        }
    }

}
