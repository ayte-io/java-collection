package io.ayte.utility.collection;

import java.util.List;
import java.util.function.Function;

public class ListOperations {
    private ListOperations() {}

    @SuppressWarnings("unchecked")
    public static <E> Function<List<E>, List<List<E>>> partition(int size) {
        return (Function) ParameterizedListOperations.partition(size);
    }
}
