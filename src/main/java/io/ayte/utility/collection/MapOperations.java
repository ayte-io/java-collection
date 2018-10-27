package io.ayte.utility.collection;

import lombok.RequiredArgsConstructor;

import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class MapOperations {
    private MapOperations() {}

    @SuppressWarnings("unchecked")
    public static <K, V, M extends Map<K, V>> Predicate<M> isBlank() {
        return (Predicate<M>) IsBlank.INSTANCE;
    }

    @SuppressWarnings("unchecked")
    public static <K, V, M extends Map<K, V>> Predicate<M> isNotBlank() {
        return (Predicate<M>) IsNotBlank.INSTANCE;
    }

    public static <K, V, M extends Map<K, V>> Function<M, M> orSupply(Supplier<M> fallback) {
        return new OrSupply<>(fallback);
    }

    public static <K, V, M extends Map<K, V>> Function<M, M> orElse(M fallback) {
        return new OrElse<>(fallback);
    }

    private static class IsBlank<K, V, M extends Map<K, V>> implements Predicate<M> {
        public static final IsBlank<?, ?, ?> INSTANCE = new IsBlank<>();

        @Override
        public boolean test(M subject) {
            return AmplifiedCollections.isBlank(subject);
        }
    }

    private static class IsNotBlank<K, V, M extends Map<K, V>> implements Predicate<M> {
        public static final IsNotBlank<?, ?, ?> INSTANCE = new IsNotBlank<>();

        @Override
        public boolean test(M subject) {
            return AmplifiedCollections.isNotBlank(subject);
        }
    }

    @RequiredArgsConstructor
    private static class OrSupply<K, V, M extends Map<K, V>> implements Function<M, M> {
        private final Supplier<M> fallback;

        @Override
        public M apply(M subject) {
            return AmplifiedCollections.orSupply(subject, fallback);
        }
    }

    @RequiredArgsConstructor
    private static class OrElse<K, V, M extends Map<K, V>> implements Function<M, M> {
        private final M fallback;

        @Override
        public M apply(M subject) {
            return AmplifiedCollections.orElse(subject, fallback);
        }
    }
}
