/**
 * Created by geordie on 11/21/17.
 */
public class LinkTable {
    private LinkElement top;
    private LinkElement tail;
    private int size=0;

    public void insert(LinkElement e){
        LinkElement temp = e;
        if(top == null){
            top = temp;
            top.setNext(tail);
        }
        else
            temp.setNext(top);
        top = temp;


      //  tail = e;
size++;
    }

    public LinkElement getTop() {
        return top;
    }
    public int getSize(){
        System.out.println("link size "+size);
        return size;

    }
}
