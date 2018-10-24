/**
 * Created by geordie on 11/9/17.
 */
public class BinaryTree {
   private static HeapElement<Integer> root;
    private static int[] arrayForTree = new int[50];
   static int arraySize=0;
    static String s;

    public static int returnIndex(int [] freqArray, int a){
        for(int i = 0; i< freqArray.length; i ++){

            if( freqArray[i] == a){
                freqArray[i]=-1;
            return i;

            }
        }
        return -1;
    }
    public static void printCodes(HeapElement tree,int[] freqArray,String s, StringBuffer prefix) {
        // only the leaves have characters of the message

        BinaryTree.s = s;
        if (tree.getLeaf()) {
            // print out character, frequency, and code for this leaf
            //(which is just the prefix)

            System.out.println(s.charAt(returnIndex(freqArray,(int)tree.getValue())) + "\t" + tree.getValue() + "\t" + prefix);


        } else if (!tree.getLeaf()) {
            HeapElement node =  tree;

            // traverse left

            prefix.append('0');
            printCodes(node.getLeft(),freqArray, s, prefix);
            prefix.deleteCharAt(prefix.length()-1);

            // traverse right
            prefix.append('1');
            printCodes(node.getRight(),freqArray,s, prefix);
            prefix.deleteCharAt(prefix.length()-1);

        }
    }
}
