package io.ayte.utility.collection.queue;

import io.ayte.utility.collection.Iterators;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.TimeUnit;

public class EmptyDeque<E> implements BlockingDeque<E> {
    @SuppressWarnings("squid:S2386") // Heya Sonar, this class only looks mutable
    public static final EmptyDeque INSTANCE = new EmptyDeque<>();

    protected EmptyDeque() {}

    @Override
    public boolean add(E e) {
        throw createModificationException();
    }

    @Override
    public boolean offer(E e) {
        return false;
    }

    @Override
    public E remove() {
        throw createModificationException();
    }

    @Override
    public E poll() {
        return null;
    }

    @Override
    public E element() {
        throw createModificationException();
    }

    @Override
    public E peek() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return Iterators.empty();
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return a;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        // this instance is already empty, but let's prevent extra
        // UnsupportedOperationException if it is unnecessary.
    }

    @Override
    public void addFirst(E e) {
        throwModificationException();
    }

    @Override
    public void addLast(E e) {
        throwModificationException();
    }

    @Override
    public boolean offerFirst(E e) {
        return false;
    }

    @Override
    public boolean offerLast(E e) {
        return false;
    }

    @Override
    public void putFirst(E e) {
        throwModificationException();
    }

    @Override
    public void putLast(E e) {
        throwModificationException();
    }

    @Override
    public boolean offerFirst(E e, long timeout, TimeUnit unit) {
        return false;
    }

    @Override
    public boolean offerLast(E e, long timeout, TimeUnit unit) {
        return false;
    }

    @Override
    public E takeFirst() {
        throw createUnsupportedFunctionalityException();
    }

    @Override
    public E takeLast() {
        throw createUnsupportedFunctionalityException();
    }

    @Override
    public E pollFirst(long timeout, TimeUnit unit) {
        return null;
    }

    @Override
    public E pollLast(long timeout, TimeUnit unit) {
        return null;
    }

    @Override
    public boolean removeFirstOccurrence(Object o) {
        return false;
    }

    @Override
    public boolean removeLastOccurrence(Object o) {
        return false;
    }

    @Override
    public void put(E e) {
        throw createUnsupportedFunctionalityException();
    }

    @Override
    public boolean offer(E e, long timeout, TimeUnit unit) {
        return false;
    }

    @Override
    public E take() {
        throw createUnsupportedFunctionalityException();
    }

    @Override
    public E poll(long timeout, TimeUnit unit) {
        return null;
    }

    @Override
    public void push(E e) {
        throwModificationException();
    }

    @Override
    public E removeFirst() {
        throw createFetchException();
    }

    @Override
    public E removeLast() {
        throw createFetchException();
    }

    @Override
    public E pollFirst() {
        return null;
    }

    @Override
    public E pollLast() {
        return null;
    }

    @Override
    public E getFirst() {
        throw createFetchException();
    }

    @Override
    public E getLast() {
        throw createFetchException();
    }

    @Override
    public E peekFirst() {
        return null;
    }

    @Override
    public E peekLast() {
        return null;
    }

    @Override
    public E pop() {
        throw createFetchException();
    }

    @Override
    public Iterator<E> descendingIterator() {
        return Iterators.empty();
    }

    @Override
    public int remainingCapacity() {
        return 0;
    }

    @Override
    public int drainTo(Collection<? super E> c) {
        throw createUnsupportedFunctionalityException();
    }

    @Override
    public int drainTo(Collection<? super E> c, int maxElements) {
        throw createUnsupportedFunctionalityException();
    }

    private static IllegalStateException createModificationException() {
        String message = "Congratulations, you've tried to modify EmptyDeque. " +
                "It is intentionally made immutable, " +
                "so probably you have semantically incorrect code.";
        return new IllegalStateException(message);
    }

    private static void throwModificationException() {
        throw createModificationException();
    }

    private static NoSuchElementException createFetchException() {
        String message = "You've tried to take element of EmptyDeque. " +
                "It is intentionally made immutable and non-fetchable, " +
                "so probably you have semantically incorrect code.";
        return new NoSuchElementException(message);
    }
    
    private static UnsupportedOperationException createUnsupportedFunctionalityException() {
        String message = "Unfortunately, EmptyDeque doesn't support this operation. " +
                "Modify your code to either not use this operation or " +
                "exclude methods that may return EmptyDeque " +
                "(Queues.empty(), Deques.materialize(), etc.)";
        return new UnsupportedOperationException(message);
    }
}
