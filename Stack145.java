// 155. Min Stack
// Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
// 
// push(x) -- Push element x onto stack.
// pop() -- Removes the element on top of the stack.
// top() -- Get the top element.
// getMin() -- Retrieve the minimum element in the stack.
//  
// 
// Example:
// 
// MinStack minStack = new MinStack();
// minStack.push(-2);
// minStack.push(0);
// minStack.push(-3);
// minStack.getMin();   --> Returns -3.
// minStack.pop();
// minStack.top();      --> Returns 0.
// minStack.getMin();   --> Returns -2.
class Stack145 {
    
    private Stack<Integer> s1 = new Stack<Integer>();
    private Stack<Integer> sMin = new Stack<Integer>();

    /** initialize your data structure here. */
    public MinStack() {
        sMin.add(Integer.MAX_VALUE);
    }
    
    public void push(int x) {
        if (x <= sMin.peek()) {
            sMin.push(x);
        }
        s1.push(x);
    }
    
    public void pop() {
        if (s1.isEmpty()) return;
        int p = s1.pop();
        if (p == sMin.peek()) {
            sMin.pop();
        }
    }
    
    public int top() {
        return s1.peek();
    }
    
    public int getMin() {
        return sMin.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */