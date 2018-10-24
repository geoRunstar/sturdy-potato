import javax.swing.*;
import java.io.*;

/**
 * Created by geordie on 11/30/17.
 */
public class MakeFile {
    private String key="";
    private String value="";
    private int numOfInputs;
    public MakeFile(int numOfInputs){
        this.numOfInputs=numOfInputs;
        build();
    }
    private void build() {
        String forFile= "";
        File file = new File("testFileRandomNames.txt");
        PrintWriter write = null;
        String abc = "abcdefghijklmnopqrstuvwxyz";
        JProgressBar bar = new JProgressBar(0,numOfInputs);
        JFrame frame = new JFrame();
        frame.setBounds(300,300,300,300);
        frame.add(bar);
        frame.setVisible(true);
        for(int i =0; i<numOfInputs; i++){
            int length=0;
            while(length<6) {
                int c = (int) Math.floor(Math.random()*25+1);
                int b = (int) Math.floor(Math.random()* 101 +1);
                key = key + abc.charAt(c);
                value = value + b + ",";
            length++;
            }

            try {
                write = new PrintWriter(new BufferedWriter(new FileWriter(file)));
            } catch (IOException e1) {
                e1.printStackTrace();
            }

            forFile= forFile + key +":"+ value +"\n";
            key ="";
            value="";
           bar.setValue(i);

        }

        write.println(forFile);
        write.close();
        System.exit(0);
    }
    public static void main(String[] args){
MakeFile make = new MakeFile(10000);

    }

}
