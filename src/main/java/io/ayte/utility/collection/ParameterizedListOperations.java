package io.ayte.utility.collection;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.function.Function;

public class ParameterizedListOperations {
    private ParameterizedListOperations() {}

    @SuppressWarnings({"squid:S1452"})
    public static <E> Function<List<? extends E>, List<List<E>>> partition(int size) {
        return new ParameterizedListOperations.Partition<>(size);
    }

    @RequiredArgsConstructor
    private static class Partition<E> implements Function<List<? extends E>, List<List<E>>> {
        private final int size;

        @Override
        public List<List<E>> apply(List<? extends E> subject) {
            return Lists.partition(subject, size);
        }
    }
}
