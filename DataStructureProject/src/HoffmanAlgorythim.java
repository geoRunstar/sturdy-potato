import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

import javax.swing.*;
import java.util.StringTokenizer;

/**
 * Created by geordie on 11/4/17.
 */
public class HoffmanAlgorythim {
   private String value, displayFreqString;

  private  HeapTree<Integer> listOfFreq;
    //private HeapTree<Integer> listForTree;
    private  int[] listForFreq;
    String forOutput="";
    LinkedQue<Integer> list;
    LinkedQue<HeapElement> listHeapEl;
    HeapElement<Integer> heapElement, left, right;
    HeapElement<Integer>[] hEleArray = new HeapElement[1000];
    private int[] temp;
    int arraySize =0;
    String forDrawTree="";
    String[] DrawTreeArray;
    int drawArraySize=0;
    public HoffmanAlgorythim(String value){

        this.value = value;
    }
    public HoffmanAlgorythim(){

    }
public void setValue(String value){

    this.value = value;
}
    public void countFreq(){// ccounts the frequnecy of each character in the string value
    forOutput="";
    list = new LinkedQue<>();
    for (int i = 0; i < value.length(); i++) {
        if (value.indexOf(value.charAt(i)) == i) {
            forOutput = forOutput + value.charAt(i);
            list.push(countCharFreq(value.charAt(i)));
        }

    }

    fillArray();// calls the method fillarray fill listForFreq
}

    private void fillArray(){// fills the array listForFreq and adds to the heap ListOfFreq the character frequencies popped from que
        listOfFreq = new HeapTree<>(forOutput.length());
        listForFreq = new int[forOutput.length()];
        for(int i =0; i< forOutput.length(); i ++){
            int v = list.pop();
            listOfFreq.add(v);
            listForFreq[i]= v;
        }

    }

    private int countCharFreq(char c){// returns the frequency of character
        int numOfFreq =0;
        for ( int i =0; i < value.length(); i++){
            if (c == value.charAt(i))
                numOfFreq++;

        }
        return numOfFreq;
    }

    public String printList(){// prints the characters and their frequencies
        displayFreqString = "Character - - - Frequency";
        for(int i =0; i<forOutput.length(); i++){
          System.out.println(forOutput.charAt(i)+ " : " + listForFreq[i]);
            displayFreqString += "\n"+ forOutput.charAt(i) + "\t"+ listForFreq[i];

        }
        return displayFreqString;

    }


    private void addToarray(HeapElement e){//adds a HeapElement to the array hEleArray
        if(arraySize<1000)
        hEleArray[arraySize]= e;
        arraySize++;

    }
    private HeapElement<Integer> getandremove(int a){// gets the HeapElement at the index, removes it from array and then returns element
        HeapElement<Integer> z = hEleArray[a];
        for(int i = 0; i< arraySize; i++){
            System.out.println("Before "+ hEleArray[i]);
        }
            hEleArray[a] = hEleArray[arraySize-1];
        arraySize--;
        for(int i = 0; i< arraySize; i++){
            System.out.println("After "+hEleArray[i]);
        }
        return z;
    }
    private int getIndex(int value){// returns the index if int value exists as one the heapelements value in the array

        for(int i =0; i< arraySize; i++){
            if(hEleArray[i].getValue()==value)
                return i;
        }
        return -1;
    }
public void heapSort(){// builds the tree by heap sorting adding and removing elements and setting left and right children.

    listOfFreq.heapSort();
    int a = listOfFreq.getIndex(0);
    listOfFreq.remove();
    listOfFreq.heapSort();
    int b = listOfFreq.getIndex(0);
    listOfFreq.remove();
    System.out.println("a + b = "+ (a+b));
    heapElement = new HeapElement<Integer>(a+b);
    left = new HeapElement<>(a);
    right = new HeapElement<>(b);


    if(getIndex(left.getValue())>-1){
        heapElement.setLeft(getandremove(getIndex(left.getValue())));
    }
    else
        heapElement.setLeft(left);


   if(getIndex(right.getValue())>-1){
       heapElement.setRight(getandremove(getIndex(right.getValue())));
   }
    else
        heapElement.setRight(right);


    addToarray(heapElement);
    listOfFreq.add(a+b);


}
public void build(){//
    listHeapEl = new LinkedQue<>();
    while(listOfFreq.getLastPos()!=0){
        heapSort();
    }

    System.out.println(": " + forDrawTree);
}
public void buildPreFixString(HeapElement<Integer> h){// builds a prefix string of tree to be passed for drawing tree
         if(h == null)return;

    forDrawTree = forDrawTree + ":"+ h.getValue();
    buildPreFixString(h.getLeft());
    buildPreFixString(h.getRight());

    System.out.println(forDrawTree);
}
public void DrawTree(){// creates graphic tree and adds to a jframe to be popped up
    DrawTreeArray= new String[forDrawTree.length()];
    StringTokenizer tok = new StringTokenizer(forDrawTree ,":" );
    while(tok.hasMoreTokens()){
        DrawTreeArray[drawArraySize]= tok.nextToken();
        drawArraySize++;
    }
    for(int i=0;i<drawArraySize;i++){
        for(int j =0; j<listForFreq.length;j++){

            String a = String.valueOf(listForFreq[j]);

            if(DrawTreeArray[i].equals(a)){
                listForFreq[j]=-1;
                DrawTreeArray[i]= DrawTreeArray[i]+ "\n"+ forOutput.charAt(j);
            continue;}

        }
        System.out.println(" : "+ DrawTreeArray[i]);
    }
    DrawTree d = new DrawTree();
    d.setSizeArray(drawArraySize);
    d.setDroot(DrawTreeArray);
    d.drawTheTree(hEleArray[arraySize-1]);
    JFrame frame = new JFrame();
    frame.setVisible(true);
    frame.setSize(1000,1000);
    frame.add(d);

}
public void printCodes(){
    System.out.println("last array pos is " + hEleArray[arraySize-1].getValue());
    int[] a = listForFreq;
    HoffMethods.printCodes(hEleArray[arraySize-1],a, forOutput, new StringBuffer());

}
public String getForOutput(){
    return forOutput;
}
public  HeapElement<Integer> gethEleArray(){
    return hEleArray[arraySize-1];
}
public String getValue(){
    return value;
}
public int[] getListForFreq(){
    return listForFreq;
}

public void setTemp(int[] temp){
    this.temp = temp;
}
public int[] getTemp(){
    return temp;
}

}
