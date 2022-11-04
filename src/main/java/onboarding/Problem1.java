package onboarding;

import java.util.List;
import java.util.stream.Stream;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = 0;
        int pobiMax = maxResult(pobi);
        int crongMax = maxResult(crong);

        if(pobiMax == -1 || crongMax == -1) {
            return -1;
        }

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

        if(exceptionCheck(list)) {
            return -1;
        }

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

    private static boolean exceptionCheck(List<Integer> list) {
        int minPage = 1, maxPage = 400;
        if(list.size() < 2) {
            return true;
        }

        for(int i = 1; i < list.size(); i++) {
            Integer right = list.get(i);
            Integer left = list.get(i - 1);

            if(left >= right) {
                return true;
            }

            if(left <= minPage) {
                return true;
            }

            if(right >= maxPage) {
                return true;
            }

            if(right - left != 1) {
                return true;
            }
        }

        return false;
    }
}