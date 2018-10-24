/**
 * Created by geordie on 11/12/17.
 */
public class HoffMethods {
    private static HeapElement<Integer> root;
    private static int[] arrayForTree = new int[50];
    static int arraySize=0;
    //static String s;
    static String forOutput;

    public static int returnIndex(int [] freq, int a){
        for(int i = 0; i< freq.length; i ++){

            if( freq[i] == a){
                freq[i]=-7;
                return i;

            }
        }
        return -1;
    }
    public static String getCodes(HeapElement tree,int[] freq,String s){

        forOutput= "Character- - - Frequency - - - HoffmanCode " + "\n";
        printCodes( tree, freq,s, new StringBuffer());
        return forOutput;

    }
    public static void printCodes(HeapElement tree, int[] freq,String s, StringBuffer prefix) {
        // only the leaves have characters of the message
            int [] temp = freq;
       // BinaryTree.s = s;
        if (tree.getLeaf()) {
            // print out character, frequency, and code for this leaf
            //(which is just the prefix)
            char c = s.charAt(returnIndex(temp,(int)tree.getValue()));
            System.out.println(c + "\t" + tree.getValue() + "\t" + prefix);
            forOutput += c + "\t" + tree.getValue() + "\t" + prefix+"\n";

        } else if (!tree.getLeaf()) {
            HeapElement node =  tree;

            // traverse left

            prefix.append('0');
            printCodes(node.getLeft(),temp, s, prefix);
            prefix.deleteCharAt(prefix.length()-1);

            // traverse right
            prefix.append('1');
            printCodes(node.getRight(),temp,s, prefix);
            prefix.deleteCharAt(prefix.length()-1);

        }

    }
}
