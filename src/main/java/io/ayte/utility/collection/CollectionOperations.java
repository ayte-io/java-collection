package io.ayte.utility.collection;

import lombok.RequiredArgsConstructor;

import java.util.Collection;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class CollectionOperations {
    private CollectionOperations() {}

    @SuppressWarnings("unchecked")
    public static <E, C extends Collection<E>> Predicate<C> isBlank() {
        return (Predicate<C>) IsBlank.INSTANCE;
    }

    @SuppressWarnings("unchecked")
    public static <E, C extends Collection<E>> Predicate<C> isNotBlank() {
        return (Predicate<C>) IsNotBlank.INSTANCE;
    }

    public static <E, C extends Collection<E>> Function<C, C> orSupply(Supplier<? extends C> supplier) {
        return new OrSupply<>(supplier);
    }

    public static <E, C extends Collection<E>> Function<C, C> orFallback(C fallback) {
        return new OrElse<>(fallback);
    }

    private static class IsBlank<E, C extends Collection<E>> implements Predicate<C> {
        public static final IsBlank<?, ?> INSTANCE = new IsBlank<>();

        @Override
        public boolean test(C subject) {
            return AmplifiedCollections.isBlank(subject);
        }
    }

    private static class IsNotBlank<E, C extends Collection<E>> implements Predicate<C> {
        public static final IsNotBlank<?, ?> INSTANCE = new IsNotBlank<>();

        @Override
        public boolean test(C subject) {
            return AmplifiedCollections.isNotBlank(subject);
        }
    }

    @RequiredArgsConstructor
    private static class OrSupply<E, C extends Collection<? extends E>> implements Function<C, C> {
        private final Supplier<? extends C> supplier;

        @Override
        public C apply(C subject) {
            return AmplifiedCollections.orSupply(subject, supplier);
        }
    }

    @RequiredArgsConstructor
    private static class OrElse<E, C extends Collection<? extends E>> implements Function<C, C> {
        private final C fallback;

        @Override
        public C apply(C subject) {
            return AmplifiedCollections.orElse(subject, fallback);
        }
    }
}
