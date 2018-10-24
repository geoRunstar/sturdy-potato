/**
 * Created by geordie on 11/4/17.
 */
public class LinkElement <T> {
    LinkElement<T> next;
         private   T value;
    public LinkElement(T element){
        value = element;
    }

    public T getValue(){
        return value;
    }
    public LinkElement getNext(){
        return next;
    }
    public void setNext(LinkElement next){
        this.next = next;
    }
    public void setValue(T value){
        this.value=value;

    }

    public String toString(){

       // System.out.print(value);

        return ""+value;
    }
}
