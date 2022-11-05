package onboarding;

import java.util.*;

public class Problem7 {
    private static Map<String, Integer> friendsPointMap = new HashMap<>();
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        visitorsPoint(visitors);
        return answer;
    }

    private static void visitorsPoint(List<String> visitors) {
        visitors.stream().forEach(k -> friendsPointMap.put(k, friendsPointMap.getOrDefault(k, 0) + 1));
    }
}
