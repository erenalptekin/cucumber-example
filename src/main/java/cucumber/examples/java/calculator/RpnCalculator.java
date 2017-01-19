package cucumber.examples.java.calculator;

import java.util.Deque;
import java.util.LinkedList;

public class RpnCalculator {
    private final Deque<Integer> stack = new LinkedList<Integer>();

    public void push(String operation) {
        if (!"+".equals(operation) && !"*".equals(operation)) {
            throw new IllegalArgumentException("Don't know about operation: " + operation);
        }
        int y = stack.removeLast();
        int x = stack.isEmpty() ? 0 : stack.removeLast();
        if(operation == "+")
            stack.push(x + y);
        else if (operation == "*")
            stack.push(x * y);
    }

    public void push(int value) {
        stack.push(value);
    }

    public int value() {
        return stack.getLast();
    }
}
