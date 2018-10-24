/**
 * Created by geordie on 11/11/17.
 */

import org.w3c.dom.html.HTMLOptGroupElement;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.*;
import java.text.NumberFormat;
import java.util.StringTokenizer;

public class View extends JFrame implements ActionListener {

    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private Console con = System.console();
    private HoffmanAlgorythim hoff;
    private JTextArea textArea;
    private HoffmanAlgorythim[] hoffArray = new HoffmanAlgorythim[150];
    private int lastPos=0;
    private String forFile="";
    private JButton displayTheFile, saveHuffManCodeFile, determineCodes, clearHeap, loadInputFile, displayFreq, readString, drawTree, quit;
    /**
     * Launch the application.
     */


    /**
     * Create the frame.
     *
     *
     */



    public View( ) throws IOException {

        this.hoff = new HoffmanAlgorythim();

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setBounds(100, 100, 900, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel north = new JPanel();
        north.setBackground(new Color(204, 120, 50));
        contentPane.add(north, BorderLayout.NORTH);
        north.setLayout(new GridLayout(2, 2, 0, 0));

        JLabel lblInsertNumber = new JLabel("Insert file name or input string");
        lblInsertNumber.setForeground(new Color(0, 0, 0));
        north.add(lblInsertNumber);

        this.textField_1 = new JTextField();
        north.add(textField_1);
        textField_1.setColumns(10);
        textField_1.setText("testFile.txt");
        //JLabel lblInsertValue = new JLabel("Insert Variables");
       // lblInsertValue.setForeground(new Color(0, 0, 0));
       // north.add(lblInsertValue);

        //this.textField = new JTextField();
       // north.add(textField);
       // textField.setColumns(10);

        JPanel center = new JPanel();
        center.setBackground(new Color(104, 151, 187));
        contentPane.add(center, BorderLayout.CENTER);
        center.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        this.textArea = new JTextArea();
        textArea.setColumns(60);
        textArea.setRows(20);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);
        JScrollPane pane = new JScrollPane(textArea);

        pane.setPreferredSize(new Dimension(600,300));


        center.add(pane);


        JPanel south = new JPanel();
        south.setBackground(new Color(204, 120, 50));
        contentPane.add(south, BorderLayout.SOUTH);
        south.setLayout(new GridLayout(0, 5, 0, 0));

////BUTTONS ////////////////////////////////////////////////////

        loadInputFile = new JButton("Load Stirng file");
        loadInputFile.setIcon(new ImageIcon(View.class.getResource("/javax/swing/plaf/metal/icons/ocean/computer.gif")));
        south.add(loadInputFile);
        loadInputFile.addActionListener(this);

        readString= new JButton("Read String");
        readString.setIcon(new ImageIcon(View.class.getResource("/javax/swing/plaf/metal/icons/ocean/computer.gif")));
        readString.setBackground(new Color(152, 118, 170));
        south.add(readString);
        readString.addActionListener(this);

       displayTheFile = new JButton("Display File");
        displayTheFile.setIcon(new ImageIcon(View.class.getResource("/com/sun/java/swing/plaf/windows/icons/Computer.gif")));
        displayTheFile.setBackground(new Color(152, 118, 170));
        south.add(displayTheFile);
        displayTheFile.addActionListener(this);

        displayFreq = new JButton("Didplay Freqs");
        displayFreq.setIcon(new ImageIcon(View.class.getResource("/javax/swing/plaf/metal/icons/ocean/computer.gif")));
        south.add(displayFreq);
        displayFreq.addActionListener(this);

        determineCodes = new JButton("Determine codes");
        determineCodes.setIcon(new ImageIcon(View.class.getResource("/javax/swing/plaf/metal/icons/ocean/computer.gif")));
        south.add(determineCodes);
        determineCodes.addActionListener(this);

        drawTree = new JButton("Draw Tree");
        drawTree.setIcon(new ImageIcon(View.class.getResource("/javax/swing/plaf/metal/icons/ocean/computer.gif")));
        drawTree.setEnabled(false);
        south.add(drawTree);
        drawTree.addActionListener(this);

        clearHeap = new JButton("Clear heap");
        clearHeap.setIcon(new ImageIcon(View.class.getResource("/javax/swing/plaf/metal/icons/ocean/computer.gif")));
        south.add(clearHeap);
        clearHeap.addActionListener(this);

        saveHuffManCodeFile= new JButton("Save File");
        saveHuffManCodeFile.setIcon(new ImageIcon(View.class.getResource("/javax/swing/plaf/metal/icons/ocean/computer.gif")));
        south.add(saveHuffManCodeFile);
        saveHuffManCodeFile.addActionListener(this);

        quit = new JButton("Quit");
        quit.setIcon(new ImageIcon(View.class.getResource("/javax/swing/plaf/metal/icons/ocean/computer.gif")));
        south.add(quit);
        quit.addActionListener(this);

        JPanel east = new JPanel();
        east.setBackground(new Color(102, 102, 153));
        contentPane.add(east, BorderLayout.WEST);

        JPanel west = new JPanel();
        west.setBackground(new Color(102, 102, 153));
        contentPane.add(west, BorderLayout.EAST);
    }


    public void terminalInput(String s)throws IOException {// readers in input commands from terminal
        BufferedReader button = new BufferedReader(new InputStreamReader(System.in));



    }


    public void actionPerformed(ActionEvent e) {
        Object button = e.getSource();
        if(button== displayFreq){
            textArea.setText("");
            for(int i =0; i< lastPos; i++){
                System.out.println(" : " +hoffArray[i].getValue());
                hoffArray[i].countFreq();
                hoffArray[i].setTemp(hoffArray[i].getListForFreq());
                textArea.append("\n"+hoffArray[i].getValue()+"\n"+ hoffArray[i].printList());
            }
        }

       else if(button== determineCodes){
            System.out.println(" lasPos "+ lastPos );
           textArea.setText("");
            for(int i =0; i< lastPos; i++){
                hoffArray[i].countFreq();
                hoffArray[i].setTemp(hoffArray[i].getListForFreq());
                hoffArray[i].build();
                textArea.append( hoffArray[i].getValue() + "\n"+HoffMethods.getCodes(hoffArray[i].gethEleArray()
                        ,hoffArray[i].getTemp(), hoffArray[i].getForOutput()));
            }
            drawTree.setEnabled(true);
        }

        else if(button== readString){
         if(!textField_1.getText().equals("")) {
        hoffArray[lastPos] = new HoffmanAlgorythim(textField_1.getText());
        lastPos++;
            }
            drawTree.setEnabled(false);
                }
        else if(button==loadInputFile){
            forFile="";
            BufferedReader buff;
            String s;
            File file = new File(textField_1.getText());
            if(file.exists()) {
            try {
                    buff = new BufferedReader(new FileReader(textField_1.getText()));
                    while((s = buff.readLine())!=null){
                        forFile = forFile + s+ "\n";
                            if(!s.equals("")) {
                                System.out.println(s);
                                hoffArray[lastPos] = new HoffmanAlgorythim(s);
                                lastPos++;
                            }
                }

            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
            else textField_1.setText("PLEASE PROVIDE A VALID FILE");

            drawTree.setEnabled(false);
        }


        else if(button == drawTree){
            for(int i =0; i< lastPos; i++){
                hoffArray[i].countFreq();
                hoffArray[i].setTemp(hoffArray[i].getListForFreq());
                hoffArray[i].buildPreFixString(hoffArray[i].gethEleArray());
                hoffArray[i].DrawTree();
            }
        }


        else if( button == saveHuffManCodeFile){
                File file = new File(textField_1.getText());
            PrintWriter write = null;
            try {
                write = new PrintWriter(new BufferedWriter(new FileWriter(file)));
            } catch (IOException e1) {
                e1.printStackTrace();
            }

            write.println(textArea.getText());
            write.close();
        }
        else if(button == displayTheFile){
            System.out.println("forFile : "+forFile);
            textArea.setText(forFile);
        }

        else if(button == clearHeap){
            lastPos=0;
            textArea.setText("");
        }



        else if(button == quit){
            System.exit(0);
        }

    }



}
