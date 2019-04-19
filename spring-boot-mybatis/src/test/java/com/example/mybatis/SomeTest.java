package com.example.mybatis;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static java.util.stream.Collectors.toList;

/**
 * @author zyd
 * @date 2019/01/21
 */
public class SomeTest {

    public CompletableFuture<Integer> doSomethingAsync() {
        return CompletableFuture.supplyAsync(() -> 1);
    }

    @Test
    public void test1() throws ExecutionException, InterruptedException {
        List<CompletableFuture<Integer>> futures = new ArrayList<>(3);
        for (int i = 0; i < 3; i++) {
            futures.add(doSomethingAsync());
        }

        CompletableFuture<List<Integer>> future = CompletableFuture
                .allOf(futures.toArray(new CompletableFuture[0]))
                .thenApply(o -> futures.stream().map(CompletableFuture::join).collect(toList()));

        List<Integer> integers = future.get();
        System.out.println(integers);
    }

}
