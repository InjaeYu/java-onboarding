package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    private static Map<String, Integer> friendsPointMap = new HashMap<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        friendsPoint(user, friends);
        visitorsPoint(visitors);

        System.out.println(friendsPointMap.toString());
        return answer;
    }

    private static void friendsPoint(String user, List<List<String>> friends) {
        List<String> friendsList = friends.stream()
                .filter(o -> o.contains(user))
                .flatMap(Collection::stream)
                .filter(o -> !o.equals(user))
                .collect(Collectors.toList());
        List<List<String>> tempList = friends.stream().filter(o -> !o.contains(user)).collect(Collectors.toList());

        for (String s : friendsList) {
            tempList.stream()
                    .filter(o -> o.contains(s))
                    .flatMap(Collection::stream)
                    .forEach(o -> {
                        if(!o.equals(s)) {
                            friendsPointMap.put(o, friendsPointMap.getOrDefault(o, 0) + 10);
                        }
                    });
        }
    }

    private static void visitorsPoint(List<String> visitors) {
        visitors.stream().forEach(k -> friendsPointMap.put(k, friendsPointMap.getOrDefault(k, 0) + 1));
    }
}
