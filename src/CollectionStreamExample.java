import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CollectionStreamExample {
    public static void main(String[] args) {
        // Tạo stream cho các collection
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        Set<String> set = new HashSet<>();
        set.add("1");
        set.add("2");
        set.add("3");
        set.add("4");

        int sum = list.stream()
                .filter(value -> value > 0)
                .mapToInt(value -> value)
                .sum();
        // Tổng các phần tử list
        System.out.println(sum);

        // In các phần tử set
        set.stream().forEach(s -> System.out.println(s));
    }
}
