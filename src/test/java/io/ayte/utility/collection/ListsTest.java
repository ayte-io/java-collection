package io.ayte.utility.collection;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ListsTest {
    public static Object[][] partitions() {
        return new Object[][] {
                {Lists.empty(), 4, Lists.empty()},
                {Lists.of(1), 1, Lists.of(Lists.of(1))},
                {Lists.of(1), 4, Lists.of(Lists.of(1))},
                {Lists.of(1, 2, 3, 4), 4, Lists.of(Lists.of(1, 2, 3, 4))},
                {Lists.of(1, 2, 3, 4, 5), 4, Lists.of(Lists.of(1, 2, 3, 4), Lists.of(5))}
        };
    }

    @ParameterizedTest
    @MethodSource("partitions")
    public void partitionsCorrectly(List<Integer> input, int size, List<Integer> expectation) {
        assertThat(Lists.partition(input, size), equalTo(expectation));
    }
}
