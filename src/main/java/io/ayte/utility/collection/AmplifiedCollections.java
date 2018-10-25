package io.ayte.utility.collection;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
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
}
