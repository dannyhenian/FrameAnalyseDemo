package com.danny.concurrent;
import java.util.concurrent.*;

/**
 * ExecutorCompletionService自身维护一个任务队列，取值时优先取任务完成的结果
 * @author danny
 * @create 2018-02-01 17:36
 */

public class CompletionServiceTest {
    static class Task implements Callable<String> {
        private int i;

        public Task(int i){
            this.i = i;
        }

        @Override
        public String call() throws Exception {
            Thread.sleep(10000);
            return Thread.currentThread().getName() + "执行完任务：" + i;
        }
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException{
        testExecutorCompletionService();
    }

    private static void testExecutorCompletionService() throws InterruptedException, ExecutionException {
        int numThread = 5;
        ExecutorService executor = Executors.newFixedThreadPool(numThread);
        CompletionService<String> completionService = new ExecutorCompletionService<String>(executor);
        for(int i = 0;i<numThread;i++ ){
            completionService.submit(new CompletionServiceTest.Task(i));
        }
        for(int i = 0;i<numThread;i++ ){
            System.out.println(completionService.take().get());
        }

        executor.shutdown();
    }


}
