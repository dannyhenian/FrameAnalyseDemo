package com.danny.concurrent.locks;/**
 * Created by danny on 2018-01-26.
 */

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * @author danny
 * @create 2018-01-26 10:51
 */

public class BufferReadWriteLock {
    private final int capacity;
    private final Deque<String> recent;
    private int discarded;

    private final FunctionalReadWriteLock guard;

    public BufferReadWriteLock(int capacity) {
        this.capacity = capacity;
        recent = new ArrayDeque<>(capacity);
        guard = new FunctionalReadWriteLock();
    }

    public void putItem(String item) {
        guard.write(() -> {
            while (recent.size() >= capacity) {
                recent.removeFirst();
                ++discarded;
            }
            recent.addLast(item);
        });
    }

    public List<String> getRecent() {
        return guard.read(() -> {
            return recent.stream().collect(toList());
        });
    }

    public int getDiscardedCount() {
        return guard.read(() -> discarded);
    }

    public int getTotal() {
        return guard.read(() -> discarded + recent.size());
    }

    public void flush() {
        guard.write(() -> {
            discarded += recent.size();
            recent.clear();
        });
    }

}
