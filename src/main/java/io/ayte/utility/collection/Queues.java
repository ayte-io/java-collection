package io.ayte.utility.collection;

import java.util.Queue;
import java.util.concurrent.BlockingQueue;

@SuppressWarnings("unused")
public class Queues {
    private Queues() {}

    public static <E> boolean isBlank(Queue<E> subject) {
        return AmplifiedCollections.isBlank(subject);
    }

    public static <E> boolean isNotBlank(Queue<E> subject) {
        return AmplifiedCollections.isNotBlank(subject);
    }

    public static <E> Queue<E> empty() {
        return AmplifiedCollections.emptyQueue();
    }

    public static <E> BlockingQueue<E> emptyBlockingQueue() {
        return AmplifiedCollections.emptyBlockingQueue();
    }

    public static <E> Queue<E> materialize(Queue<E> subject) {
        return AmplifiedCollections.materialize(subject);
    }

    public static <E> BlockingQueue<E> materialize(BlockingQueue<E> subject) {
        return AmplifiedCollections.materialize(subject);
    }
}
