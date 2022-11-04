package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder result = new StringBuilder();
        for(char c : word.toCharArray()) {
            if(c == ' ') {
                result.append(c);
            } else if(c >= 'a' && c <= 'z') {
                result.append((char)('z' - c + 'a'));
            } else if(c >= 'A' && c <= 'Z'){
                result.append((char)('Z' - c + 'A'));
            }
        }
        return result.toString();
    }
}
