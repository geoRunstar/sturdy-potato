/**
 * Created by geordie on 11/4/17.
 */
public class HeapTree<T> {
    int sizeOfHeap;
    T[] heapArray ;
    int lastPos;
    int firstPos;

    public HeapTree(int sizeOfHeap){
        this.sizeOfHeap = sizeOfHeap;
        heapArray = (T[])(new Object[sizeOfHeap]);
        lastPos=-1;
    }

    public void add(T element){
      //  System.out.println("iteming being added "+ element);
        if(lastPos == -1){
            heapArray[++lastPos]=element;
        return;}
            heapArray[++lastPos]=element;
            trickleUp(lastPos);


    }

    private void trickleUp(int pos){
        if(pos ==0)return;
        int parent = (pos-1)/2;
        if(((Comparable<T>)heapArray[pos]).compareTo(heapArray[parent])>0)
            swop(pos, parent);
        trickleUp(parent);

    }
    private void swop(int from, int to ){
       // System.out.println("SWAPPED " +from + " with "+ to);
        T temp = heapArray[from];
        heapArray[from] = heapArray[to];
        heapArray[to] = temp;
    }
public void removeForArrange(){
    T temp = heapArray[0];
    heapArray[0]= heapArray[lastPos];
    heapArray[lastPos]= temp;
    lastPos--;
    T temp2 = heapArray[1];
    heapArray[1]= heapArray[lastPos];
    heapArray[lastPos]= temp2;
    lastPos--;
    trickleDown(0);
    trickleDown(0);

}
    public void remove(){
        T temp = heapArray[0];
        heapArray[0]= heapArray[lastPos];
        heapArray[lastPos]= temp;
        lastPos--;
        trickleDown(0);
    }
    private void trickleDown(int pos){
        if(pos == lastPos)
            return;
        int childL = ((pos*2)+1);
        int childR = ((pos*2)+2);

        if(childL==lastPos && ((Comparable<T>)heapArray[pos]).compareTo(heapArray[childL])<0) {
            swop(pos, childL);
            return;
        }
        if(childR==lastPos && ((Comparable<T>)heapArray[pos]).compareTo(heapArray[childR])<0) {
            swop(pos, childR);
            return;
        }
        if(childL>=lastPos || childR>=lastPos)
            return;


        if(((Comparable<T>)heapArray[childL]).compareTo(heapArray[childR])<=0 && ((Comparable<T>)heapArray[pos]).compareTo(heapArray[childL])<0){
            swop(pos,childL);
            trickleDown(childL);
        }
        else if(((Comparable<T>)heapArray[pos]).compareTo(heapArray[childR])<0)
        {
            swop(pos, childR);
            trickleDown(childR);
        }

    }
    public void heapSort(){
        int reserveLast = lastPos;
        while(lastPos>0){
            remove();
        }

        lastPos = reserveLast;

    }

    public void add(int a, int b){
        HeapElement newElement = new HeapElement(heapArray[a]);
        newElement.setLeft(new HeapElement(heapArray[b]));


    }
    public T getIndex(int i){
        return heapArray[i];
    }
    public int getLastPos(){
        return lastPos;
    }
    public String toString(int i){
        if(i > lastPos)
            return "null";

        return ""+heapArray[i];
    }


}
