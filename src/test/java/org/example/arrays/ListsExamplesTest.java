package org.example.arrays;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import org.hamcrest.MatcherAssert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThrows;

public class ListsExamplesTest {

    @Test
    public void test_listOperationsUsingArraysAsList() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        assertThrows(UnsupportedOperationException.class, () -> list.add(6));

        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
        assertThrows(UnsupportedOperationException.class, () -> list1.remove(1));

        Integer[] array = new Integer[]{1, 2, 3};
        List<Integer> list2 = Arrays.asList(array);
        array[0] = 1000;
        assertThat(list2.getFirst()).isEqualTo(1000);

        List<Integer> list3 = Arrays.asList(1, 2, 3, 4);
        list3.set(1, 1000);
        assertThat(list3.get(1)).isEqualTo(1000);

        Integer[] array1 = new Integer[]{1, 2, 3};
        List<Integer> list4 = Arrays.asList(array1);
        list4.set(0, 1000);
        assertThat(array1[0]).isEqualTo(1000);
    }

    @Test
    public void test_listOperationsUsingListOf() {
        String[] array = new String[]{"one", "two", "three"};
        List<String> list = List.of(array);
        assertThat(list).containsExactly("one", "two", "three");

        String[] array1 = new String[]{"one", "two", "three"};
        List<String> list1 = List.of(array1);
        array1[0] = "thousand";
        assertThat(list1.getFirst()).isEqualTo("one");

        List<String> list2 = List.of("one", "two", "three");
        assertThrows(UnsupportedOperationException.class, () -> list2.set(1, "four"));

        assertThrows(NullPointerException.class, () -> List.of("one", null, "two"));
    }

    @Test
    public void givenList_whenPartitioningIntoNSubLists_thenCorrect() {
        List<Integer> intList = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8);
        List<List<Integer>> subSets = Lists.partition(intList, 3);

        List<Integer> lastPartition = subSets.get(2);
        List<Integer> expectedLastPartition = Lists.newArrayList(7, 8);
        MatcherAssert.assertThat(subSets.size(), equalTo(3));
        MatcherAssert.assertThat(lastPartition, equalTo(expectedLastPartition));
    }

    @Test
    public void givenCollection_whenPartitioningIntoNSubLists_thenCorrect() {
        Collection<Integer> intCollection = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8);
        Iterable<List<Integer>> subSets = Iterables.partition(intCollection, 3);

        List<Integer> firstPartition = subSets.iterator().next();
        List<Integer> expectedLastPartition = Lists.newArrayList(1, 2, 3);
        MatcherAssert.assertThat(firstPartition, equalTo(expectedLastPartition));
    }

}