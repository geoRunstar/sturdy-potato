import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class View extends JFrame implements ActionListener {

    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private Console con = System.console();
    private Table table;
    private JTextArea textArea;
    private Table tableLinked ;
    private Table tableQuad ;
    private Table tableRehash;
    private Table tableLinear ;
    private String ledger =" New Program ";
    private int lastPos=0;
    private String forFile="";
    private JButton QuickSort, performance, find, clearHash, loadFileQuadratic,loadFileLinkHash, readNewEntryQuad,readNewEntryLink
            ,readNewEntryLinear ,readNewEntryRehash , quit, loadFileLinear,loadFileRehash;
    /**
     * Launch the application.
     */


    /**
     * Create the frame.
     *
     *
     */



    public View( ) throws IOException {

        this.table = new Table(16);

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

        JLabel lblInsertNumber = new JLabel("Insert file name or key");
        lblInsertNumber.setForeground(new Color(0, 0, 0));
        north.add(lblInsertNumber);

        this.textField_1 = new JTextField();
        north.add(textField_1);
        textField_1.setColumns(10);
        textField_1.setText("testFileRandomNames.txt");
        JLabel lblInsertValue = new JLabel("Insert Values, delimited by ',' ");
         lblInsertValue.setForeground(new Color(0, 0, 0));
         north.add(lblInsertValue);

        this.textField = new JTextField();
         north.add(textField);
         textField.setColumns(10);

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

        loadFileQuadratic = new JButton("Load file to Quatratic");
        loadFileQuadratic.setIcon(new ImageIcon(View.class.getResource("/javax/swing/plaf/metal/icons/ocean/computer.gif")));
        south.add(loadFileQuadratic);
        loadFileQuadratic.addActionListener(this);

        loadFileLinear = new JButton("Load file to Linear");
        loadFileLinear.setIcon(new ImageIcon(View.class.getResource("/javax/swing/plaf/metal/icons/ocean/computer.gif")));
        south.add(loadFileLinear);
        loadFileLinear.addActionListener(this);



        loadFileLinkHash= new JButton("Load file to Linked");
        loadFileLinkHash.setIcon(new ImageIcon(View.class.getResource("/javax/swing/plaf/metal/icons/ocean/computer.gif")));
        loadFileLinkHash.setBackground(new Color(152, 118, 170));
        south.add(loadFileLinkHash);
        loadFileLinkHash.addActionListener(this);

        readNewEntryQuad = new JButton("read New Entry Quad");
        readNewEntryQuad.setIcon(new ImageIcon(View.class.getResource("/com/sun/java/swing/plaf/windows/icons/Computer.gif")));
        readNewEntryQuad.setBackground(new Color(152, 118, 170));
        south.add(readNewEntryQuad);
        readNewEntryQuad.addActionListener(this);

        readNewEntryLinear = new JButton("read New Entry Linear");
        readNewEntryLinear.setIcon(new ImageIcon(View.class.getResource("/com/sun/java/swing/plaf/windows/icons/Computer.gif")));
        readNewEntryLinear.setBackground(new Color(152, 118, 170));
        south.add(readNewEntryLinear);
        readNewEntryLinear.addActionListener(this);



        readNewEntryLink = new JButton("read New Entry Link");
        readNewEntryLink.setIcon(new ImageIcon(View.class.getResource("/javax/swing/plaf/metal/icons/ocean/computer.gif")));
        south.add(readNewEntryLink);
        readNewEntryLink.addActionListener(this);

        find = new JButton("find");
        find.setIcon(new ImageIcon(View.class.getResource("/javax/swing/plaf/metal/icons/ocean/computer.gif")));
        south.add(find);
        find.addActionListener(this);

        performance = new JButton("performance");
        performance.setIcon(new ImageIcon(View.class.getResource("/javax/swing/plaf/metal/icons/ocean/computer.gif")));
        south.add(performance);
        performance.addActionListener(this);

        clearHash = new JButton("Clear hashes");
        clearHash.setIcon(new ImageIcon(View.class.getResource("/javax/swing/plaf/metal/icons/ocean/computer.gif")));
        south.add(clearHash);
        clearHash.addActionListener(this);

        QuickSort= new JButton("QuickSort file");
        QuickSort.setIcon(new ImageIcon(View.class.getResource("/javax/swing/plaf/metal/icons/ocean/computer.gif")));
        south.add(QuickSort);
        QuickSort.addActionListener(this);

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
        if(button == readNewEntryLink){
            if(tableLinked==null){
                tableLinked = new Table(16);
            }
            tableLinked.addNewLink(textField_1.getText(), textField.getText());
        }
        else if(button == loadFileLinkHash) {
            forFile = "";
            HashingWrapper.setCollisionCounter(0);
            long start = System.nanoTime();
            BufferedReader buff;
            String s;
            File file = new File(textField_1.getText());
            if (file.exists()) {
                                 try {
                               buff = new BufferedReader(new FileReader(textField_1.getText()));

                                             if(tableLinked == null){
                                                 tableLinked = new Table(16);}

                         while ((s = buff.readLine()) != null) {
                             if(!s.equals("")) {

                                  StringTokenizer tok = new StringTokenizer(s, ":");
                                   String a = tok.nextToken();
                                 String b = tok.nextToken();

                                 tableLinked.addNewLink(a, b);
                             }
                                                                }//end while

                                     }//end try

                            catch (IOException e1) {
                              e1.printStackTrace();
                                                    }//end catch


            long time = System.nanoTime()-start;

            HashingWrapper.displayTable(tableLinked.getLinkHash());

            ledger = ledger+"\n"+ tableLinked.getLedger() + "loaded file "+'"'+ textField_1.getText()+'"'+"\n"+" in nanoseconds: " + time + ": collsions = "+HashingWrapper.getCollisionCounter();
            System.out.println(" performance in nano seconds : " + time);

        }//end if
        }

    else if(button== readNewEntryQuad){

        if(tableQuad==null)
      tableQuad= new Table(16);
            tableQuad.addNewQuad(textField_1.getText(),textField.getText());

            HashingWrapper.displayTableQuad(tableQuad.getQuadHash());
        }

        else if(button == loadFileQuadratic) {
            forFile = "";
            HashingWrapper.setCollisionCounter(0);
            long start = System.nanoTime();
            BufferedReader buff;
            String s;
            File file = new File(textField_1.getText());
            if (file.exists()) {
                try {
                    buff = new BufferedReader(new FileReader(textField_1.getText()));

                    if(tableQuad == null){
                        tableQuad= new Table(16);}

                    while ((s = buff.readLine()) != null) {
                        if(!s.equals("")) {

                             StringTokenizer tok = new StringTokenizer(s, ":");
                             String a = tok.nextToken();
                            String b = tok.nextToken();

                            tableQuad.addNewQuad(a, b);
                        }
                    }//end while

                }//end try

                catch (IOException e1) {
                    e1.printStackTrace();
                }//end catch


            long time = System.nanoTime()-start;

            HashingWrapper.displayTableQuad(tableQuad.getQuadHash());
            ledger = ledger+"\n"+ tableQuad.getLedger() + "loaded file "+'"'+ textField_1.getText()+'"'+"\n"+" in nanoseconds: "+ time+ ": collsions = "+HashingWrapper.getCollisionCounter();
            System.out.println(" performance in nano seconds : " + time);
            }//end if
        }

        else if(button== readNewEntryLinear){

            if(tableLinear==null)
                tableLinear= new Table(16);
            tableLinear.addNewLinear(textField_1.getText(),textField.getText());

            HashingWrapper.displayTableQuad(tableLinear.getOpenLinHash());
        }

        else if(button == loadFileLinear) {
            forFile = "";
            HashingWrapper.setCollisionCounter(0);
            long start = System.nanoTime();
            BufferedReader buff;
            String s;
            File file = new File(textField_1.getText());
            if (file.exists()) {
                try {
                    buff = new BufferedReader(new FileReader(textField_1.getText()));

                    if (tableLinear == null) {
                        tableLinear = new Table(16);
                    }

                    while ((s = buff.readLine()) != null) {
                        if (!s.equals("")) {
                            System.out.println(s);
                            StringTokenizer tok = new StringTokenizer(s, ":");
                            String a = tok.nextToken();
                            String b = tok.nextToken();

                            tableLinear.addNewLinear(a, b);
                        }
                    }//end while

                }//end try

                catch (IOException e1) {
                    e1.printStackTrace();
                }//end catch
                long time = System.nanoTime()-start;

                HashingWrapper.displayTableQuad(tableLinear.getOpenLinHash());
                ledger = ledger+"\n"+ tableLinear.getLedger() + "loaded file "+ '"'+ textField_1.getText()+'"'+ "\n"+" in nanoseconds: " + time +": collsions = "+HashingWrapper.getCollisionCounter();
                System.out.println(" performance in nano seconds : " + time);
            }//end if
        }


        else if (button == find){
            if(tableQuad!=null){
             long a = System.nanoTime();
           textArea.append( tableQuad.find(textField_1.getText()) + " search time with Quadratic hash = "+(long)(System.nanoTime()-a));
            }
            if(tableLinked!=null){
                long b = System.nanoTime();
                textArea.append( tableLinked.find(textField_1.getText())+ " search time with Linked hash = "+(long)(System.nanoTime()-b));
            }

            if(tableLinear!=null){
                long d = System.nanoTime();
                textArea.append( tableLinear.find(textField_1.getText())+ " search time with Linear hash = "+(long)(System.nanoTime()-d));
            }

        }
        else if(button==QuickSort){

            if(tableLinear ==null){
                textField.setText("PLEASE LOAD LINEAR HASH FIRST !!!!!!");
                return;
            }

            LKV[] temp = QuickSortWrap.sort(tableLinear.getOpenLinHash());

            String a = "";
            for(int i=0; i< temp.length; i++){
                if(temp[i]!= null){
                    String b= "";
                    for(int j=0; j< temp[i].getAPtr().length; j++){
                        b = b + temp[i].getAPtr()[j]+ ",";
                    }
                    a = a +"\n"+ temp[i].getKey() + ":"+ b;
                }
            }
            File file = new File("testFileSorted.txt");
            PrintWriter write = null;
            try {
                write = new PrintWriter(new BufferedWriter(new FileWriter(file)));
            } catch (IOException e1) {
                e1.printStackTrace();
            }

            write.println(a);
            write.close();
            textField_1.setText("testFileSorted.txt");
            textArea.setText(" Now load this ^ new file into desired hashes to compare performances");

        }
        else if(button == performance){
            textArea.setText(ledger);
        }
        else if( button == clearHash){
            tableQuad =null;
            tableLinear=null;
            tableLinked= null;

        }
        else if(button == quit){
            System.exit(0);
        }
    }



}