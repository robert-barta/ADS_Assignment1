public class Operand implements Token{

    private int value;

    public Operand(int value){
        this.value=value;
    }

    public int getValue(){
        return value;
    }
}
