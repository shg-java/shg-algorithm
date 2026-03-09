import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

class IsValid {
    public boolean isValid(String s) {
        if (s.length() % 2 == 1) {
            return false;
        }
        ArrayDeque<Character> stack = new ArrayDeque<>();
        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (pairs.containsKey(ch)) {
                if (stack.isEmpty() || stack.peek() != pairs.get(ch)) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(ch);
            }

        }
        return stack.isEmpty();
    }
}