import java.util.LinkedList;
import java.util.NoSuchElementException;

public class StackLinkedList<T> {

    private LinkedList<T> list;

    public StackLinkedList(){
        list=new LinkedList();
    }

    public void push(T item){
        list.addFirst(item);
    }

    public T pop(){
        if(list.isEmpty()){
            throw new NoSuchElementException();
        }
        return list.removeFirst();
        }

        public T peek(){
        if(list.isEmpty()){
            throw new NoSuchElementException();
        }
        return list.getFirst();
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }
}
