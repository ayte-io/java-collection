package io.ayte.utility.collection;

import java.util.Deque;
import java.util.concurrent.BlockingDeque;

@SuppressWarnings("unused")
public class Deques {
    private Deques() {}

    public static <E> boolean isBlank(Deque<E> subject) {
        return AmplifiedCollections.isBlank(subject);
    }

    public static <E> boolean isNotBlank(Deque<E> subject) {
        return AmplifiedCollections.isNotBlank(subject);
    }

    public static <E> Deque<E> empty() {
        return AmplifiedCollections.emptyDeque();
    }

    public static <E> BlockingDeque<E> emptyBlockingDeque() {
        return AmplifiedCollections.emptyBlockingDeque();
    }

    public static <E> Deque<E> materialize(Deque<E> subject) {
        return AmplifiedCollections.materialize(subject);
    }

    public static <E> BlockingDeque<E> materialize(BlockingDeque<E> subject) {
        return AmplifiedCollections.materialize(subject);
    }
}
