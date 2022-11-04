package onboarding;

import java.util.List;
import java.util.stream.Stream;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = 0;
        int pobiMax = maxResult(pobi);
        int crongMax = maxResult(crong);

        if(pobiMax > crongMax) {
            answer = 1;
        } else if (pobiMax < crongMax) {
            answer = 2;
        } else {
            answer = 0;
        }

        return answer;
    }

    private static int maxResult(List<Integer> list) {
        int max = 0;
        // TODO: 예외사항에 대한 처리 필요

        for(Integer i : list) {
            int sum = Stream.of(String.valueOf(i).split("")).mapToInt(Integer::parseInt).sum();
            int mul = Stream.of(String.valueOf(i).split("")).mapToInt(Integer::parseInt).reduce(1, (a, b) -> a * b);
            int calcMax = Math.max(sum, mul);
            if(max < calcMax) {
                max = calcMax;
            }
        }
        return max;
    }
}