package io.ayte.utility.collection;

@SuppressWarnings("unused")
public class Iterables {
    private Iterables() {}

    public static <E> Iterable<E> empty() {
        return AmplifiedCollections.emptyIterable();
    }
}
