/**
 * Created by geordie on 11/7/17.
 */
public class HeapElement<T> {

    HeapElement<T> leftChild, rightChild ;
    private   T value;

    public HeapElement(T element){
        value = element;
    }
    public HeapElement(T element, T elementL, T elementR){
        value = element;
        leftChild = new HeapElement<T>(elementL);
        rightChild = new HeapElement<T>(elementR);
    }

    public T getValue(){
        return value;
    }
    public HeapElement getLeft(){
        return leftChild;
    }
    public void setLeft(HeapElement leftChild){
        this.leftChild = leftChild;
    }
    public HeapElement getRight(){
        return rightChild;
    }
    public void setRight(HeapElement rightChild){
        this.rightChild = rightChild;
    }

    public void setValue(T value){
        this.value=value;

    }
public boolean getLeaf(){
    return (leftChild==null && rightChild==null);
}
    public String toString(){

      //  System.out.print(value);

        return ""+value;
    }

}
