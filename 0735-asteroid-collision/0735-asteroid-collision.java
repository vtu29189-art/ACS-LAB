import java.util.Stack;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int asteroid : asteroids) {
            boolean exploded = false;

            // Collision only happens when the top of stack is moving right (> 0) 
            // and the current asteroid is moving left (< 0)
            while (!stack.isEmpty() && stack.peek() > 0 && asteroid < 0) {
                if (stack.peek() < -asteroid) {
                    // Top asteroid is smaller, so it explodes; pop it and keep checking
                    stack.pop();
                    continue;
                } else if (stack.peek() == -asteroid) {
                    // Both asteroids are equal in size, both explode
                    stack.pop();
                    exploded = true;
                    break;
                } else {
                    // Current asteroid is smaller, it explodes
                    exploded = true;
                    break;
                }
            }

            // If current asteroid didn't explode, push it to stack
            if (!exploded) {
                stack.push(asteroid);
            }
        }

        // Convert stack to result array
        int[] result = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }
}