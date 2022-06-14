/**
 * @author Davis Jeffrey
 */

import java.util.Stack;

/**
 * Problem: Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 *
 * Valid operators are +, -, *, and /. Each operand may be an integer or another expression.
 * Note that division between two integers should truncate toward zero.
 *
 * It is guaranteed that the given RPN expression is always valid.
 * That means the expression would always evaluate to a result,
 * and there will not be any division by zero operation.
 *
 * Link: https://leetcode.com/problems/clone-graph/
 */
public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        if (tokens.length == 0) {
            return 0;
        }
        Stack<Integer> operands = new Stack<>();
        for (String token : tokens) {
            switch(token) {
                case "+":
                    operands.push(operands.pop() + operands.pop());
                    break;
                case "-":
                    int rightOperand = operands.pop();
                    int leftOperand = operands.pop();
                    operands.push(leftOperand - rightOperand);
                    break;
                case "*":
                    operands.push(operands.pop() * operands.pop());
                    break;
                case "/":
                    int rightOperand2 = operands.pop();
                    int leftOperand2 = operands.pop();
                    operands.push(leftOperand2 / rightOperand2);
                    break;
                default:
                    operands.push(Integer.parseInt(token));
            }
        }
        return operands.pop();
    }
}
