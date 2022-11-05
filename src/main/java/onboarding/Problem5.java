package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        int[] moneyArray = new int[]{50000, 10000, 5000, 1000, 500, 100, 50, 10};
        for(int i : moneyArray) {
            answer.add(money / i);
            money %= i;
        }
        answer.add(money);
        return answer;
    }
}
