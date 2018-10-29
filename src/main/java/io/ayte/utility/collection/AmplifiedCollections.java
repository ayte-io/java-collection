package io.ayte.utility.collection;

import io.ayte.utility.collection.iterable.EmptyIterable;
import io.ayte.utility.collection.iterator.EmptyListIterator;
import io.ayte.utility.collection.queue.EmptyDeque;

import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.function.Supplier;

@SuppressWarnings("unused")
public class AmplifiedCollections {
    private AmplifiedCollections() {}

    // Common methods

    public static <E> boolean isBlank(Collection<E> subject) {
        return subject == null || subject.isEmpty();
    }

    public static <E> boolean isNotBlank(Collection<E> subject) {
        return !isBlank(subject);
    }

    public static <K, V> boolean isBlank(Map<K, V> subject) {
        return subject == null || subject.isEmpty();
    }

    public static <K, V> boolean isNotBlank(Map<K, V> subject) {
        return !isBlank(subject);
    }

    // Factory methods

    public static <E> List<E> emptyList() {
        return Collections.emptyList();
    }

    public static <E> Set<E> emptySet() {
        return Collections.emptySet();
    }

    public static <E> NavigableSet<E> emptyNavigableSet() {
        return Collections.emptyNavigableSet();
    }

    public static <E> SortedSet<E> emptySortedSet() {
        return Collections.emptySortedSet();
    }

    public static <E> Iterator<E> emptyIterator() {
        return emptyListIterator();
    }

    @SuppressWarnings("unchecked")
    public static <E> ListIterator<E> emptyListIterator() {
        return EmptyListIterator.INSTANCE;
    }

    @SuppressWarnings("unchecked")
    public static <E> Iterable<E> emptyIterable() {
        return EmptyIterable.INSTANCE;
    }

    public static <E> Queue<E> emptyQueue() {
        return emptyBlockingDeque();
    }

    public static <E> BlockingQueue<E> emptyBlockingQueue() {
        return emptyBlockingDeque();
    }

    public static <E> Deque<E> emptyDeque() {
        return emptyBlockingDeque();
    }

    @SuppressWarnings("unchecked")
    public static <E> BlockingDeque<E> emptyBlockingDeque() {
        return EmptyDeque.INSTANCE;
    }

    // Materialization

    public static <E, C extends Collection<? extends E>> C orElse(C subject, C fallback) {
        return subject != null ? subject : fallback;
    }

    public static <E, C extends Collection<? extends E>> C orSupply(C subject, Supplier<? extends C> fallback) {
        return subject != null ? subject : fallback.get();
    }

    public static <K, V, M extends Map<? extends K, ? extends V>> M orElse(M subject, M fallback) {
        return subject != null ? subject : fallback;
    }

    public static <K, V, M extends Map<? extends K, ? extends V>> M orSupply(M subject, Supplier<? extends M> fallback) {
        return subject != null ? subject : fallback.get();
    }

    public static <E> List<E> materialize(List<E> subject) {
        return subject != null ? subject : Collections.emptyList();
    }

    public static <E> Set<E> materialize(Set<E> subject) {
        return subject != null ? subject : Collections.emptySet();
    }

    public static <E> SortedSet<E> materialize(SortedSet<E> subject) {
        return subject != null ? subject : Collections.emptySortedSet();
    }

    public static <E> NavigableSet<E> materialize(NavigableSet<E> subject) {
        return subject != null ? subject : Collections.emptyNavigableSet();
    }

    public static <K, V> Map<K, V> materialize(Map<K, V> subject) {
        return subject != null ? subject : Collections.emptyMap();
    }

    public static <K, V> SortedMap<K, V> materialize(SortedMap<K, V> subject) {
        return subject != null ? subject : Collections.emptySortedMap();
    }

    public static <K, V> NavigableMap<K, V> materialize(NavigableMap<K, V> subject) {
        return subject != null ? subject : Collections.emptyNavigableMap();
    }

    public static <E> Iterator<E> materialize(Iterator<E> subject) {
        return subject != null ? subject : emptyIterator();
    }

    public static <E> ListIterator<E> materialize(ListIterator<E> subject) {
        return subject != null ? subject : emptyListIterator();
    }

    public static <E> Iterable<E> materialize(Iterable<E> subject) {
        return subject != null ? subject : emptyIterable();
    }

    public static <E> Queue<E> materialize(Queue<E> subject) {
        return subject != null ? subject : emptyQueue();
    }

    public static <E> BlockingQueue<E> materialize(BlockingQueue<E> subject) {
        return subject != null ? subject : emptyBlockingQueue();
    }

    public static <E> Deque<E> materialize(Deque<E> subject) {
        return subject != null ? subject : emptyDeque();
    }

    public static <E> BlockingDeque<E> materialize(BlockingDeque<E> subject) {
        return subject != null ? subject : emptyBlockingDeque();
    }
}
