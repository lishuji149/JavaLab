import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamMethods {
    public static double median(List<Integer> list) {
        return list.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0);
    }

    public static List<String> parseStrings(List<String> list) {
        return list.stream()
                .map(element -> "_new_" + element.toUpperCase(Locale.ROOT))
                .collect(Collectors.toList());
    }

    public static List<Integer> squares(List<Integer> list) {
        return list.stream()
                .filter(a -> Collections.frequency(list, a) < 2)
                .map(a -> a * a)
                .collect(Collectors.toList());
    }

    public static List<String> sortWithCondition(Collection<String> strings, char condition) {
        return strings.stream()
                .filter(a -> a.charAt(0) == condition)
                .sorted()
                .collect(Collectors.toList());
    }

    public static <T> T lastOrException(Collection<T> collection) throws IllegalArgumentException {
        return collection.stream()
                .skip(collection.size() - 1)
                .findFirst().orElseThrow(() -> new IllegalArgumentException("The collection is empty"));
    }

    public static int sumEven(int[] array) {
        return Arrays.stream(array)
                .filter(a -> a % 2 == 0)
                .sum();
    }

    public static Map<Character, String> stringMap(List<String> strings) {
        return strings.stream()
                .collect(Collectors.toMap(str -> str.charAt(0), str -> str.substring(1)));
    }

}
