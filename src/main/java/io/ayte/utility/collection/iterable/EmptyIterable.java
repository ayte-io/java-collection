package io.ayte.utility.collection.iterable;

import io.ayte.utility.collection.Iterators;

import java.util.Iterator;

public class EmptyIterable<E> implements Iterable<E> {
    public static final EmptyIterable INSTANCE = new EmptyIterable<>();

    private EmptyIterable() {}

    @Override
    public Iterator<E> iterator() {
        return Iterators.empty();
    }
}
