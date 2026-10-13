import java.util.Stack;

class MyQueue {
    private Stack<Integer> inputStack;
    private Stack<Integer> outputStack;

    public MyQueue() {
        inputStack = new Stack<>();
        outputStack = new Stack<>();
    }
    
    // Transfer elements from inputStack to outputStack when outputStack is empty
    private void transfer() {
        if (outputStack.isEmpty()) {
            while (!inputStack.isEmpty()) {
                outputStack.push(inputStack.pop());
            }
        }
    }
    
    public void push(int x) {
        inputStack.push(x);
    }
    
    public int pop() {
        transfer();
        return outputStack.pop();
    }
    
    public int peek() {
        transfer();
        return outputStack.peek();
    }
    
    public boolean empty() {
        return inputStack.isEmpty() && outputStack.isEmpty();
    }
}