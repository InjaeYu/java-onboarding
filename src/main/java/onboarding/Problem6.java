package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<List<String>> tempForms = new ArrayList<>(forms);
        List<String> result = new ArrayList<>();
        String[] nameArr = tempForms.stream().map(o -> o.get(1)).toArray(String[]::new);
        Map<String, Integer> checkMap = new HashMap<>();
        for(String s : nameArr) {
            if(s.length() < 2) continue;
            Set<String> tempSet = new HashSet<>();

//            for(int i = 2; i <= s.length(); i++) {
//                for(int j = 0; j <= s.length() - i; j++) {
//                    String key = s.substring(j, j + i);
//                    checkMap.put(key, checkMap.getOrDefault(key, 0) + 1);
//                }
//            }
            for(int j = 0; j <= s.length() - 2; j++) {
                String key = s.substring(j, j + 2);
                tempSet.add(key);
            }

            for(String key : tempSet) {
                checkMap.put(key, checkMap.getOrDefault(key, 0) + 1);
            }
        }

        checkMap.entrySet().removeIf(o -> o.getValue() == 1);
        for(String k : checkMap.keySet()) {
            for (int i = 0; i < tempForms.size();) {
                if (tempForms.get(i).get(1).contains(k)) {
                    result.add(tempForms.get(i).get(0));
                    tempForms.remove(i);
                } else {
                    i += 1;
                }
            }
        }

        return result.stream().distinct().sorted().collect(Collectors.toList());
    }
}
