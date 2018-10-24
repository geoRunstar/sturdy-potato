import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

/**
 * Created by geordie on 10/26/17.
 */
public class DrawTree extends JComponent{// draws the tree.
    //Shape drawLine;
    // Graphics2D g2d;
    String[] Droot;
    int[] indexH;
    int[] indexW;
    String[] Sarray ;
    Shape [] lines;
    int num = 0;
    int space =50;
    int size;

    public void paint(Graphics g){
        Graphics2D  g2d = (Graphics2D)g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int i = 300;
        int j = 0;

        for(int k =0; k<size; k++){
            Shape drawLine;
            System.out.println("char :  " + Droot[k]+ "IndexH: " +indexH[k] + " indexW: "+ indexW[k] );
            g2d.setColor(Color.RED);
            g2d.drawString(Droot[k],indexH[k], indexW[k]);
            if(k>0){

               g2d.setColor(Color.GREEN);
               g2d.draw(lines[k]);



            }
        }







    }
    public void setSizeArray(int size){
        this.size=size;
    }
    public void setDroot(String[] Droot){
        this.Droot = Droot;
    }
    public void drawTheTree(HeapElement<Integer> root){// calls two recursive methods that will go throught the and x and y cordinantes according to position in tree
        indexH = new int[size];
        indexW = new int[size];
        Sarray = new String[size];
        lines = new Shape[size];
        if(root!=null){
            StringArray(num,root.toString());
            indexH[num]=500;
            indexW[num]=50;
            chkLeft(root.getLeft(),indexH[num],indexW[num]);
            chkRight(root.getRight(),600,50);
        }
    }
    public void chkLeft(HeapElement<Integer> root, int H, int W){
        if(root!=null){

            num++;


            indexH[num]=H-(space+size);
            indexW[num]=W+(space+size);

            StringArray(num,root.toString());
            int temp = getIndex(root.toString());
            int temp2 = getIndex(root.toString());
            lines[num]= new Line2D.Float(indexH[num]+10, indexW[num]-10, H+10, W-10);

            chkLeft(root.getLeft(),indexH[temp],indexW[temp2]);

            chkRight(root.getRight(),indexH[temp]-(space+size), indexW[temp2]);
        }
    }
    public void chkRight(HeapElement<Integer> root, int H, int W){
        if(root!=null){

            num++;


            indexH[num]=H+(space+size);
            indexW[num]=W+(space+size);
            StringArray(num,root.toString());
            int temp = getIndex(root.toString());
            int temp2 = getIndex(root.toString());
            lines[num]= new Line2D.Float(indexH[num]+30, indexW[num]-10, H+size, W+size);
            chkLeft(root.getLeft(),indexH[temp], indexW[temp2]);
            chkRight(root.getRight(), indexH[temp]+(space+size), indexW[temp2]);

        }

    }
    public void StringArray(int i,String s){
        Sarray[i] = s;
    }
    public int getIndex(String s){// returns the index a node x and y cordinates in the other arrays.
        for(int i = 0; i< Sarray.length;i++){
            if(Sarray[i].equals(s))
                return i;
        }
        return -1;
    }


}
