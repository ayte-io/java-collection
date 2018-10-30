package io.ayte.utility.collection;

import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

@SuppressWarnings("unused")
public class SetOperations {
    private SetOperations() {}

    @SuppressWarnings("unchecked")
    public static <E> BiFunction<Set<E>, Set<E>, Set<E>> union() {
        return (BiFunction) ParameterizedSetOperations.<E>union();
    }

    @SuppressWarnings("unchecked")
    public static <E> BiFunction<Set<E>, Set<E>, Set<E>> intersection() {
        return (BiFunction) ParameterizedSetOperations.<E>intersection();
    }

    @SuppressWarnings({"unchecked"})
    public static <E> BiPredicate<Set<E>, Set<E>> areDisjoint() {
        return (BiPredicate) ParameterizedSetOperations.<E>areDisjoint();
    }

    @SuppressWarnings("unchecked")
    public static <E> BiPredicate<Set<E>, Set<E>> isSubsetOf() {
        return (BiPredicate) ParameterizedSetOperations.isSubsetOf();
    }

    public static <E> Predicate<Set<E>> isNotBlank() {
        return CollectionOperations.isNotBlank();
    }

    public static <E> Predicate<Set<E>> isBlank() {
        return CollectionOperations.isBlank();
    }
}
