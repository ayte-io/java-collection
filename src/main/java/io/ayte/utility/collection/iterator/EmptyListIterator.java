package io.ayte.utility.collection.iterator;

import java.util.ListIterator;
import java.util.NoSuchElementException;

public class EmptyListIterator<E> implements ListIterator<E> {
    public static final EmptyListIterator INSTANCE = new EmptyListIterator<>();

    private EmptyListIterator() {}

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public E next() {
        throw new NoSuchElementException();
    }

    @Override
    public boolean hasPrevious() {
        return false;
    }

    @Override
    public E previous() {
        throw new NoSuchElementException();
    }

    @Override
    public int nextIndex() {
        return 0;
    }

    @Override
    public int previousIndex() {
        return -1;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void set(E e) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(E e) {
        throw new UnsupportedOperationException();
    }
}
