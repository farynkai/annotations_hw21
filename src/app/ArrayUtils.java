package app;

import java.util.*;

public class ArrayUtils {
    @Author(firstName = "John", lastName = "Doe")
    @MethodInfo(
            name="findDuplicates",
            returnType = "List<Integer>",
            description = "Find all the elements in the array that appear more than once"
    )
    public List<Integer> findDuplicates(int[] array) {
        Set<Integer> seen = new HashSet<>();
        Set<Integer> duplicates = new LinkedHashSet<>();

        for (int value : array) {
            if (!seen.add(value)) {
                duplicates.add(value);
            }
        }
        return new ArrayList<>(duplicates);
    }

    @Author(firstName = "Iryna", lastName = "Faryna")
    @MethodInfo(
            name = "reverseInPlace",
            returnType = "void",
            description = "Reverse the array in place without creating a new array (using the two-pointer technique)"
    )
    public void reverseInPlace(int[] array) {
        int left = 0;
        int right = array.length - 1;

        while (left < right) {
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }

    @Author(firstName = "Pavlo", lastName = "Faryna")
    @MethodInfo(
            name = "twoSum",
            returnType = "int[]",
            description = "Find the indices of two elements in the array whose sum equals the given number"
    )
    public int[] twoSum(int[] array, int target) {
        Map<Integer, Integer> valueToIndex = new HashMap<>();

        for (int i = 0; i < array.length; i++) {
            int complement = target - array[i];
            if (valueToIndex.containsKey(complement)) {
                return new int[]{valueToIndex.get(complement), i};
            }
            valueToIndex.put(array[i], i);
        }
        return new int[]{-1, -1};
    }
}