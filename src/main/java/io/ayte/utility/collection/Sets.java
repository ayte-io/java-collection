package io.ayte.utility.collection;

import lombok.val;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.function.Supplier;

@SuppressWarnings("unused")
public class Sets {
    private Sets() {}

    // Factory operations

    // A little bit more concise version of same thing
    public static <E> Set<E> empty() {
        return Collections.emptySet();
    }

    public static <E> Set<E> mutable(Iterable<? extends E> source) {
        return mutable(source.iterator());
    }

    public static <E> Set<E> mutable(Iterator<? extends E> source) {
        val target = new HashSet<E>();
        while (source.hasNext()) {
            target.add(source.next());
        }
        return target;
    }

    @SafeVarargs // lol deal with your own data yourself, users
    public static <E> Set<E> mutable(E... sources) {
        return mutable(Arrays.asList(sources));
    }

    public static <E> Set<E> immutable(Iterator<? extends E> source) {
        return Collections.unmodifiableSet(mutable(source));
    }

    public static <E> Set<E> immutable(Iterable<? extends E> source) {
        return immutable(source.iterator());
    }

    @SafeVarargs
    public static <E> Set<E> immutable(E... sources) {
        return immutable(Arrays.asList(sources));
    }

    @SuppressWarnings("unchecked")
    public static <E> Set<E> of(E... elements) {
        return immutable(elements);
    }

    // Common operations

    public static <E> Set<E> orElse(Set<E> subject, Set<E> fallback) {
        return AmplifiedCollections.orElse(subject, fallback);
    }

    public static <E> Set<E> orSupply(Set<E> subject, Supplier<? extends Set<E>> supplier) {
        return AmplifiedCollections.orSupply(subject, supplier);
    }

    public static <E> Set<E> materialize(Set<E> subject) {
        return AmplifiedCollections.materialize(subject);
    }

    public static <E> SortedSet<E> materialize(SortedSet<E> subject) {
        return AmplifiedCollections.materialize(subject);
    }

    public static <E> NavigableSet<E> materialize(NavigableSet<E> subject) {
        return AmplifiedCollections.materialize(subject);
    }

    public static <E> boolean isBlank(Set<E> subject) {
        return subject == null || subject.isEmpty();
    }

    public static <E> boolean isNotBlank(Set<E> subject) {
        return !isBlank(subject);
    }

    @SuppressWarnings("unchecked")
    public static <E> Set<E> downcast(Set<? extends E> subject) {
        return (Set<E>) subject;
    }

    @SuppressWarnings("unchecked")
    public static <E> NavigableSet<E> downcast(NavigableSet<? extends E> subject) {
        return (NavigableSet<E>) subject;
    }

    @SuppressWarnings("unchecked")
    public static <E> SortedSet<E> downcast(SortedSet<? extends E> subject) {
        return (SortedSet<E>) subject;
    }

    // Type operations

    public static <E> Set<E> union(Set<? extends E> left, Set<? extends E> right) {
        val accumulator = Sets.<E>mutable(left);
        accumulator.addAll(right);
        return accumulator;
    }

    public static <E> Set<E> difference(Set<? extends E> minuend, Set<? extends E> subtrahend) {
        val difference = Sets.<E>mutable(minuend);
        difference.removeAll(subtrahend);
        return difference;
    }

    public static <E> Set<E> intersection(Set<? extends E> left, Set<? extends E> right) {
        val intersection = Sets.<E>mutable(left);
        intersection.retainAll(right);
        return intersection;
    }

    public static <E> boolean areDisjoint(Set<? extends E> left, Set<? extends E> right) {
        return intersection(left, right).isEmpty();
    }

    public static <E> boolean isSubsetOf(Set<? extends E> subject, Set<? extends E> superset) {
        return intersection(subject, superset).equals(subject);
    }

    public static <E> boolean isSupersetOf(Set<? extends E> subject, Set<? extends E> subset) {
        return isSubsetOf(subset, subject);
    }
}
