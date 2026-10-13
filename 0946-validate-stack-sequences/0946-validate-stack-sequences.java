import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack = new ArrayDeque<>();
        int i = 0; // Pointer for popped array
        
        for (int val : pushed) {
            stack.push(val); // Push current element
            
            // Pop matching elements as long as top of stack equals popped[i]
            while (!stack.isEmpty() && stack.peek() == popped[i]) {
                stack.pop();
                i++;
            }
        }
        
        // If stack is empty, all elements were successfully matched and popped
        return stack.isEmpty();
    }
}