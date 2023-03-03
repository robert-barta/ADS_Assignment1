public class Operator implements Token{

    private char symbol;

    public Operator(char symbol){
        this.symbol=symbol;
    }

    public char getSymbol(){
        return symbol;
    }

}
