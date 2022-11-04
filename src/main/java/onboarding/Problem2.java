package onboarding;

import java.util.List;
import java.util.stream.Collectors;

public class Problem2 {
    public static String solution(String cryptogram) {
        int count = 0;
        boolean reverse = false;
        List<Character> charList = cryptogram.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
        Character base = charList.get(0);

        for (int i = 1; i < charList.size(); ) {
            if (charList.get(i).equals(base)) {
                count += 1;
                charList.remove(i);
            } else {
                if (count == 0) {
                    if (reverse) {
                        reverse = false;
                    }
                    base = charList.get(i++);
                } else {
                    count = 0;
                    reverse = true;
                    charList.remove(--i);
                    base = charList.get(i - 1);
                }
            }
        }
        if (count != 0) {
            charList.remove(charList.size() - 1);
        }
        return charList.stream().map(String::valueOf).collect(Collectors.joining());
    }
}
