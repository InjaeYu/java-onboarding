package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    private static final Map<String, Integer> friendsPointMap = new HashMap<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        friendsPoint(user, friends);
        visitorsPoint(visitors);

        List<String> keyList = new ArrayList<>(friendsPointMap.keySet());

        for (String s : friendsFilter(user, friends)) {
            keyList.remove(s);
        }

        keyList.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int com = friendsPointMap.get(o2).compareTo(friendsPointMap.get(o1));
                if(com == 0) {
                    return o1.compareTo(o2);
                } else {
                    return com;
                }
            }
        });

        answer = keyList.subList(0, Math.min(keyList.size(), 5));

        return answer;
    }

    private static List<String> friendsFilter(String user, List<List<String>> friends) {
        return friends.stream()
                .filter(o -> o.contains(user))
                .flatMap(Collection::stream)
                .filter(o -> !o.equals(user))
                .collect(Collectors.toList());
    }

    private static void friendsPoint(String user, List<List<String>> friends) {
        List<String> friendsList = friendsFilter(user, friends);
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
        for (String k : visitors) {
            friendsPointMap.put(k, friendsPointMap.getOrDefault(k, 0) + 1);
        }
    }
}
