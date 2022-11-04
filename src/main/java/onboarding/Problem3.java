package onboarding;

import java.util.stream.Stream;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for(int i = 1; i <= number; i++) {
            answer += Stream.of(String.valueOf(i).split("")).mapToInt(Integer::parseInt).filter(o -> o != 0 && o % 3 == 0).count();
        }
        return answer;
    }
}
