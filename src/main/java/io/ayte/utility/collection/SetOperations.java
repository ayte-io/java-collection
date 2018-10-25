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
        return (BiFunction<Set<E>, Set<E>, Set<E>>) Union.INSTANCE;
    }

    @SuppressWarnings({"unchecked", "squid:S1452"})
    public static <E> BiFunction<Set<? extends E>, Set<? extends E>, Set<E>> parameterizedUnion() {
        return (Union<E>) Union.INSTANCE;
    }

    @SuppressWarnings("unchecked")
    public static <E> BiFunction<Set<E>, Set<E>, Set<E>> intersection() {
        return (BiFunction<Set<E>, Set<E>, Set<E>>) Intersection.INSTANCE;
    }

    @SuppressWarnings({"unchecked", "squid:S1452"})
    public static <E> BiFunction<Set<? extends E>, Set<? extends E>, Set<E>> parameterizedIntersection() {
        return (Intersection<E>) Intersection.INSTANCE;
    }

    @SuppressWarnings({"unchecked"})
    public static <E> BiPredicate<Set<E>, Set<E>> areDisjoint() {
        return (BiPredicate<Set<E>, Set<E>>) AreDisjoint.INSTANCE;
    }

    @SuppressWarnings({"unchecked", "squid:S1452"})
    public static <E> BiPredicate<Set<? extends E>, Set<? extends E>> parameterizedAreDisjoint() {
        return (AreDisjoint<E>) AreDisjoint.INSTANCE;
    }

    @SuppressWarnings("unchecked")
    public static <E> BiPredicate<Set<E>, Set<E>> isSubsetOf() {
        return (BiPredicate<Set<E>, Set<E>>) IsSubsetOf.INSTANCE;
    }

    @SuppressWarnings({"unchecked", "squid:S1452"})
    public static <E> BiPredicate<Set<? extends E>, Set<? extends E>> parameterizedIsSubsetOf() {
        return (IsSubsetOf<E>) IsSubsetOf.INSTANCE;
    }

    public static <E> Predicate<Set<E>> isNotBlank() {
        return CollectionOperations.isNotBlank();
    }

    public static <E> Predicate<Set<E>> isBlank() {
        return CollectionOperations.isBlank();
    }

    private static class Union<E> implements BiFunction<Set<? extends E>, Set<? extends E>, Set<E>> {
        public static final Union INSTANCE = new Union<>();

        @Override
        public Set<E> apply(Set<? extends E> left, Set<? extends E> right) {
            return Sets.union(left, right);
        }
    }

    private static class Intersection<E> implements BiFunction<Set<? extends E>, Set<? extends E>, Set<E>> {
        public static final Intersection INSTANCE = new Intersection<>();

        @Override
        public Set<E> apply(Set<? extends E> left, Set<? extends E> right) {
            return Sets.intersection(left, right);
        }
    }

    private static class AreDisjoint<E> implements BiPredicate<Set<? extends E>, Set<? extends E>> {
        private static final AreDisjoint INSTANCE = new AreDisjoint();

        @Override
        public boolean test(Set<? extends E> left, Set<? extends E> right) {
            return Sets.areDisjoint(left, right);
        }
    }

    private static class IsSubsetOf<E> implements BiPredicate<Set<? extends E>, Set<? extends E>> {
        private static final IsSubsetOf INSTANCE = new IsSubsetOf();

        @Override
        public boolean test(Set<? extends E> subject, Set<? extends E> space) {
            return Sets.isSubsetOf(subject, space);
        }
    }
}
