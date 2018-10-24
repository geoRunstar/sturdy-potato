/**
 * Created by geordie on 11/11/17.
 import java.awt.event.ActionEvent;
 import java.awt.event.ActionListener;
 import java.io.*;

 /**
 * Created by Geordie Jones on 11/14/17.
 * Project3
 * Dr. Sanches COCS Data Structures 2017 fall
 *
 * the purpose of this program is to take a string or file and displays the character frequency and Hoffman codes for each string
 *
 *
 */
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;


public class Controls extends View implements ActionListener, Runnable {
    private Console con;

    /**
     * Create the frame.
     */

    public Controls() throws IOException {
        con = System.console();
    }


    public static void main(String[] args) {
        Controls c = null;
        try {
            c = new Controls();

        } catch (IOException e) {
            e.printStackTrace();
        }
        c.run();

    }

    @Override
    public void run() {// creates a new GUI, which also creates a new instance of the Page class.
        try {
            View frame = new View();
            System.out.println("You may use the GUI ");
            frame.setVisible(true);
            BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));// takes in user input from the console
            while (true) {
                String in = buff.readLine();

                frame.terminalInput(in);// passes input through the terminalInput method in the view class
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}