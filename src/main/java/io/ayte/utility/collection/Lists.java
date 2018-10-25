package io.ayte.utility.collection;

import lombok.val;
import lombok.var; // NOSONAR

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.function.Supplier;

@SuppressWarnings("unused")
public class Lists {
    private Lists() {}

    /**
     * Returns empty list, same as {@link Collections#emptyList()}, but
     * in a little bit more concise version.
     */
    public static <T> List<T> empty() {
        return Collections.emptyList();
    }

    /**
     * Checks if provided list is either null or empty
     */
    public static <T> boolean isBlank(List<T> subject) {
        return subject == null || subject.isEmpty();
    }

    /**
     * Checks if provided list is not null and is not empty
     */
    public static <T> boolean isNotBlank(List<T> subject) {
        return !isBlank(subject);
    }

    /**
     * Materializes list by returning empty list if null was passed.
     */
    public static <T> List<T> materialize(List<T> subject) {
        return AmplifiedCollections.materialize(subject);
    }

    public static <T> List<T> orElse(List<T> subject, List<T> fallback) {
        return AmplifiedCollections.orElse(subject, fallback);
    }

    public static <T> List<T> orSupply(List<T> subject, Supplier<? extends List<T>> supplier) {
        return AmplifiedCollections.orSupply(subject, supplier);
    }

    public static <T> List<T> concat(List<? extends T> left, List<? extends T> right) {
        val accumulator = new ArrayList<T>(left.size() + right.size());
        accumulator.addAll(left);
        accumulator.addAll(right);
        return accumulator;
    }

    public static <E> List<E> mutable(Iterator<? extends E> source) {
        val target = new ArrayList<E>();
        while (source.hasNext()) {
            target.add(source.next());
        }
        return target;
    }

    public static <E> List<E> mutable(Iterable<? extends E> source) {
        return mutable(source.iterator());
    }

    @SafeVarargs
    public static <E> List<E> mutable(E... elements) {
        return Arrays.asList(elements);
    }

    public static <E> List<E> immutable(Iterator<? extends E> iterator) {
        return Collections.unmodifiableList(mutable(iterator));
    }

    public static <E> List<E> immutable(Iterable<? extends E> source) {
        return immutable(source.iterator());
    }

    @SafeVarargs
    public static <E> List<E> immutable(E... sources) {
        return Collections.unmodifiableList(mutable(sources));
    }

    /**
     * Splits input list into sublists
     *
     * @param size Number of items in sublist
     */
    public static <E> List<List<E>> partition(List<? extends E> source, int size) {
        val iterator = source.iterator();
        val target = new ArrayList<List<E>>();
        var cursor = new ArrayList<E>();
        var i = 0;
        while (iterator.hasNext()) {
            cursor.add(iterator.next());
            if (++i == size) {
                target.add(immutable(cursor));
                cursor = new ArrayList<>();
                i = 0;
            }
        }
        return immutable(target);
    }
}
