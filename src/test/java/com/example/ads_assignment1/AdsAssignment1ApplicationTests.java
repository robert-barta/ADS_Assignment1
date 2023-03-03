package com.example.ads_assignment1;

import ch.qos.logback.core.subst.Token;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.expression.spel.ast.Operator;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AdsAssignment1ApplicationTests {

    @Test
    public void testPushAndPeek() {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertEquals(3, stack.peek().intValue());
    }

    @Test
    public void testPop() {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertEquals(3, stack.pop().intValue());
        assertEquals(2, stack.pop().intValue());
        assertEquals(1, stack.pop().intValue());
    }

    @Test
    public void testPopFromEmptyStack() {
        Stack<Integer> stack = new Stack<Integer>();
        stack.pop();
        assertNull(stack.pop());
    }

    @Test
    public void testPeekFromEmptyStack() {
        Stack<Integer> stack = new Stack<Integer>();
        stack.peek();
        assertNull(stack.peek());
    }

    @Test
    public void testIsEmpty() {
        Stack<Integer> stack = new Stack<Integer>();
        assertTrue(stack.isEmpty());

        stack.push(1);
        assertFalse(stack.isEmpty());

        stack.pop();
        assertTrue(stack.isEmpty());
    }
    @Test
    void testEvaluateExpression() {
        // Test case 1: 5 + 3
        ArrayList<Token> tokenList1 = new ArrayList<>();
        tokenList1.add(new Operand(5));
        tokenList1.add(new Operand(3));
        tokenList1.add(new Operator('+'));
        int expected1 = 8;
        int actual1 = Calculator.evaluateExpression(tokenList1);
        assertEquals(expected1, actual1);

        // Test case 2: 10 - 2 * 3
        ArrayList<Token> tokenList2 = new ArrayList<>();
        tokenList2.add(new Operand(10));
        tokenList2.add(new Operand(2));
        tokenList2.add(new Operand(3));
        tokenList2.add(new Operator('*'));
        tokenList2.add(new Operator('-'));
        int expected2 = 4;
        int actual2 = Calculator.evaluateExpression(tokenList2);
        assertEquals(expected2, actual2);

        // Test case 3: Empty list
        ArrayList<Token> tokenList3 = new ArrayList<>();
        Exception exception3 = assertThrows(NoSuchElementException.class, () -> {
            Calculator.evaluateExpression(tokenList3);
        });
        assertEquals("The stack is empty", exception3.getMessage());
    }

}
