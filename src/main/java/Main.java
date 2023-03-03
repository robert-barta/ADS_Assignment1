import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        PostfixCalculator calculator=new PostfixCalculator();
        ArrayList<Token> tokens=new ArrayList<>();


        Token token1=new Operand(5);
        Token token2=new Operand(2);
        Token token3=new Operator('+');

        tokens.add(token1);
        tokens.add(token2);
        tokens.add(token3);

        System.out.println(calculator.evaluateExpression(tokens));


    }
}
