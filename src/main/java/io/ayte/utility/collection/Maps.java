package io.ayte.utility.collection;

import lombok.Data;
import lombok.val;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.SortedMap;
import java.util.function.Supplier;

@SuppressWarnings("unused")
public class Maps {
    private Maps() {}

    public static <K, V> Map<K, V> empty() {
        return Collections.emptyMap();
    }

    public static <K, V> Map<K, V> mutable(Iterator<Tuple<? extends K, ? extends V>> source) {
        val target = new HashMap<K, V>();
        while (source.hasNext()) {
            val tuple = source.next();
            target.put(tuple.getKey(), tuple.getValue());
        }
        return target;
    }

    public static <K, V> Map<K, V> mutable(Iterable<Tuple<? extends K, ? extends V>> source) {
        return mutable(source.iterator());
    }

    @SafeVarargs
    public static <K, V> Map<K, V> mutable(Tuple<? extends K, ? extends V>... sources) {
        return mutable(Arrays.asList(sources));
    }

    public static <K, V> Map<K, V> immutable(Iterator<Tuple<? extends K, ? extends V>> sources) {
        return Collections.unmodifiableMap(mutable(sources));
    }

    public static <K, V> Map<K, V> immutable(Iterable<Tuple<? extends K, ? extends V>> sources) {
        return immutable(sources.iterator());
    }

    @SafeVarargs
    public static <K, V> Map<K, V> immutable(Tuple<? extends K, ? extends V>... sources) {
        return Collections.unmodifiableMap(mutable(sources));
    }

    @SafeVarargs
    public static <K, V> Map<K, V> of(Tuple<? extends K, ? extends V>... sources) {
        return immutable(sources);
    }

    public static <K, V> Map<K, V> materialize(Map<K, V> subject) {
        return AmplifiedCollections.materialize(subject);
    }

    public static <K, V> Map<K, V> orElse(Map<K, V> subject, Map<K, V> fallback) {
        return AmplifiedCollections.orElse(subject, fallback);
    }

    public static <K, V> Map<K, V> orElseSupply(Map<K, V> subject, Supplier<? extends Map<K, V>> supplier) {
        return AmplifiedCollections.orSupply(subject, supplier);
    }

    public static <K, V> SortedMap<K, V> materialize(SortedMap<K, V> subject) {
        return AmplifiedCollections.materialize(subject);
    }

    public static <K, V> SortedMap<K, V> orElse(SortedMap<K, V> subject, SortedMap<K, V> fallback) {
        return AmplifiedCollections.orElse(subject, fallback);
    }

    public static <K, V> SortedMap<K, V> orElseSupply(SortedMap<K, V> subject, Supplier<? extends SortedMap<K, V>> supplier) {
        return AmplifiedCollections.orSupply(subject, supplier);
    }

    public static <K, V> NavigableMap<K, V> materialize(NavigableMap<K, V> subject) {
        return AmplifiedCollections.materialize(subject);
    }

    public static <K, V> NavigableMap<K, V> orElse(NavigableMap<K, V> subject, NavigableMap<K, V> fallback) {
        return AmplifiedCollections.orElse(subject, fallback);
    }

    public static <K, V> NavigableMap<K, V> orElseSupply(NavigableMap<K, V> subject, Supplier<? extends NavigableMap<K, V>> supplier) {
        return AmplifiedCollections.orSupply(subject, supplier);
    }

    public static <K, V> boolean isBlank(Map<K, V> subject) {
        return subject == null || subject.isEmpty();
    }

    public static <K, V> boolean isNotBlank(Map<K, V> subject) {
        return !isBlank(subject);
    }

    public static <K, V> Tuple<K, V> tuple(K key, V value) {
        return Tuple.of(key, value);
    }

    public interface Tuple<K, V> {
        K getKey();
        V getValue();

        static <K, V> Tuple<K, V> of(K key, V value) {
            return new Pair<>(key, value);
        }
    }

    /**
     * Pretty much same as Map.Entry, but specifically for passing
     * (rather than extracting) key-value data for maps.
     *
     * Remember, if long elements (<code>Maps.Tuple.of()</code>)
     * frustrate you, you can always import inner classes as well
     * (i.e. import ...Maps.Tuple;).
     *
     * @param <K>
     * @param <V>
     */
    @Data
    public static class Pair<K, V> implements Tuple<K, V> {
        private final K key;
        private final V value;

        public static <K, V> Tuple<K, V> of(K key, V value) {
            return new Pair<>(key, value);
        }
    }
}
