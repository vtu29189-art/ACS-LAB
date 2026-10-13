import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        // A valid string must have an even length
        if (s.length() % 2 != 0) {
            return false;
        }

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            // Push expected closing bracket onto stack for each opening bracket
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } 
            // If stack is empty or top doesn't match current closing bracket
            else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }

        // Return true if all opening brackets were matched and popped
        return stack.isEmpty();
    }
}