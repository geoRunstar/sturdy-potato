/**
 * Created by geordie on 11/21/17.
 */
public class LinkElement {
    private LKV element;
    private LinkElement next;
    public LinkElement(LKV element){
        this.element = element;
    }

    public LKV getElement() {
        return element;
    }

    public LinkElement getNext() {
        return next;
    }

    public void setElement(LKV element) {
        this.element = element;
    }

    public void setNext(LinkElement next) {
        this.next = next;
    }
}
