package io.ayte.utility.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

@SuppressWarnings("unused")
public class Iterators {
    private Iterators() {}

    public static <E> Iterator<E> empty() {
        return AmplifiedCollections.emptyIterator();
    }

    public static <E> ListIterator<E> emptyListIterator() {
        return AmplifiedCollections.emptyListIterator();
    }

    public static <E> Iterator<E> materialize(Iterator<E> subject) {
        return AmplifiedCollections.materialize(subject);
    }

    public static <E> ListIterator<E> materialize(ListIterator<E> subject) {
        return AmplifiedCollections.materialize(subject);
    }

    public static <E, C extends Collection<E>> C drain(Iterator<? extends E> subject, C sink) {
        while (subject.hasNext()) {
            sink.add(subject.next());
        }
        return sink;
    }

    public static <E> List<E> drain(Iterator<? extends E> subject) {
        return drain(subject, new ArrayList<>());
    }
}
