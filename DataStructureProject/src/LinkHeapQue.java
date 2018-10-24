/**
 * Created by geordie on 11/9/17.
 */

    public class LinkHeapQue <T> {
        LinkElement front;
        LinkElement rear;
        public LinkHeapQue(){
            front = rear = null;
        }
        public void push(T element, T elementL, T elementR){
            HeapElement hElement = new HeapElement(element, elementL, elementR);
            LinkElement newElement = new LinkElement(hElement);
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
        public boolean isEmpty(){
            return front == null;
        }
}
