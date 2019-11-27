package intermediate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 1, 2, 3, 4
 * (1)
 * (1, 2)
 * (1, 3)
 * (1, 4)
 * (1, 2, 3)
 * (1, 2, 4)
 * (1, 3, 2)
 * (1, 3, 4)
 * (1, 4, 2)
 * (1, 4, 3)
 * (1, 2, 3, 4)
 */
class Challenge349 {

    String stack(String input) {
        String[] parts = input.split(" ");
        int numStacks = Integer.parseInt(parts[0]);

        List<Integer> sizes = Arrays.stream(parts[1].split("(?!^)"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        Integer totalSize = sizes.stream().reduce(Integer::sum).get();

        if (totalSize % numStacks != 0) {
            return "No Solution";
        }

        Integer maxStackSize = Math.floorDiv(totalSize, numStacks);

        List<List<Integer>> finalList = new ArrayList<>();
        for (int i = 1; i <= parts[1].length(); i++) {
            powerset(sizes, i).forEach(integers -> {
                integers.sort(Integer::compareTo);
                finalList.add(integers);
            });
        }

        List<List<Integer>> validList = finalList.stream()
                .distinct()
                .filter(integers -> integers.stream().reduce(Integer::sum).get() <= maxStackSize)
                .collect(Collectors.toList());

        for (List<Integer> integers : validList) {
            System.out.println(integers);
        }

        return "";
    }

    /**
     * This is an adaptation of Guava's Sets.powerset(Set set) found on via Stackoverflow
     * https://stackoverflow.com/a/5162713
     * https://stackoverflow.com/questions/5162254/all-possible-combinations-of-an-array
     */
    private <T> List<List<T>> powerset(List<T> values, int size) {
        if (size == 0) {
            return Collections.singletonList(Collections.<T>emptyList());
        }
        if (values.isEmpty()) {
            return Collections.emptyList();
        }

        List<List<T>> combination = new LinkedList<List<T>>();

        T actual = values.iterator().next();

        List<T> subset = new LinkedList<T>(values);
        subset.remove(actual);

        List<List<T>> subsetCombination = powerset(subset, size - 1);

        for (List<T> set : subsetCombination) {
            List<T> newSet = new LinkedList<T>(set);
            newSet.add(0, actual);
            combination.add(newSet);
        }
        combination.addAll(powerset(subset, size));

        return combination;
    }

    public static void main(String[] args) {
        Challenge349 challenge349 = new Challenge349();
        challenge349.stack("3 34312332");
    }

}
