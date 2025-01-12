import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;

class Solution {
    public int singleNumber(int[] nums) {
        var map = Arrays.stream(nums)
        .boxed()
        .collect(
            Collectors.groupingBy(
                    s -> s,
                    LinkedHashMap::new,
                    Collectors.counting()
                    )
                );
        
        return Math.toIntExact(map.entrySet().stream()
                .filter(entry -> entry.getValue() == 1L)
                .map(Map.Entry::getKey)
                .findFirst().orElse(1));
    }
}