import java.util.ArrayList;

public class PostfixCalculator {

    private StackLinkedList<Operand> stack;

    public PostfixCalculator(){
        stack=new StackLinkedList<Operand>();
    }

    public int evaluateExpression(ArrayList<Token> tokenList) {
        for (Token token : tokenList) {
            if (token instanceof Operand) {
                stack.push((Operand) token);
            } else if (token instanceof Operator) {
                Operand operand2 = stack.pop();
                Operand operand1 = stack.pop();
                System.out.println("Operand2= "+operand2.getValue());
                System.out.println("Operand1= "+operand1.getValue());
                int result = getResult((Operator) token, operand1, operand2);
                stack.push(new Operand(result));
            } else {
                throw new IllegalArgumentException("Invalid token type");
            }
        }
        return stack.pop().getValue();
    }

    private int getResult(Operator operator, Operand operand1, Operand operand2) {
        switch (operator.getSymbol()) {
            case '+':
                return operand1.getValue() + operand2.getValue();
            case '-':
                return operand1.getValue() - operand2.getValue();
            case '*':
                return operand1.getValue() * operand2.getValue();
            case '/':
                return operand1.getValue() / operand2.getValue();
            default:
                throw new IllegalArgumentException("Invalid operator");
        }
    }
}
