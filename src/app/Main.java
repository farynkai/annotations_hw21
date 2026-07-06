package app;

import java.lang.reflect.Method;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] testArray = {5, 3, 8, 1, 9, 2, 5, 1};

        ArrayUtils utils = new ArrayUtils();

        System.out.printf("Test array data: %s%n", Arrays.toString(testArray));
        System.out.printf("Duplicates: %s%n", utils.findDuplicates(testArray));
        System.out.printf("Indices: %s%n", Arrays.toString(utils.twoSum(testArray, 5)));
        utils.reverseInPlace(testArray);
        System.out.printf("Reversed: %s%n%n", Arrays.toString(testArray));

        Method[] methods = ArrayUtils.class.getDeclaredMethods();
        for (Method method : methods) {
            MethodInfo methodInfo = method.getAnnotation(MethodInfo.class);
            Author author = method.getAnnotation(Author.class);
            String authorName = author != null ? author.firstName() + " " + author.lastName() : "unknown";

            System.out.println(methodInfo.name() + "()");
            System.out.printf("\tReturn type: %s%n", methodInfo.returnType());
            System.out.printf("\tDescription: %s%n", methodInfo.description());
            System.out.printf("\tAuthor: %s%n%n", authorName);
        }
    }
}
