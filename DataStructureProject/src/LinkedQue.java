/**
 * Created by geordie on 11/4/17.
 */
public class LinkedQue <T> {
LinkElement front;
    LinkElement rear;
public LinkedQue(){
  front = rear = null;
}
    public void push(T element){
        LinkElement newElement = new LinkElement(element);
        if(front == null){
            front = newElement;
            rear = newElement;
        front.setNext(rear);}
            else
                rear.setNext(newElement);
       rear = newElement;

    }

    public T pop(){
        LinkElement popElement = front;

        front = front.getNext();

        return (T) popElement.getValue();
    }
    public T peek(){

        return (T) front;
    }
    public T peekForheap(){
        if(front ==null)return null;
        return (T)front;
    }
    public boolean compare(int type){
        HeapElement temp = new HeapElement(type);
        if(front == null)return false;
        if(((Comparable<T>)front.getValue()).compareTo((T)temp.getValue())==0);
        return true;
    }
public boolean isEmpty(){
    return front == null;
}
public T getRear(){
    return (T)rear;
}


}
