import com.sun.xml.internal.ws.api.ha.StickyFeature;

import javax.swing.*;
import java.util.Calendar;
import java.util.StringTokenizer;

/**
 * Created by geordie on 11/16/17.
 */
public class Table {
    private LinkTable[] linkHash;

    private LKV[] openADDHash, openLinHash;
    private int size;
    private final double maxLoad = 0.75;
    private int numOfelements=0;
    private String ledger;

public Table(int size){
    this.size = size;
    ledger = " New Tabel created at " + Calendar.DATE;


}

    public void addNewQuad(String key, String value){
        if(openADDHash==null){
            this.openADDHash= new LKV[size];
            ledger = ledger + " : Quadratic Table ";

        }
        double loadFactor =  numOfelements/size;

        System.out.println("load factor "+ loadFactor);
       byte[] b = genterateBytearray(value);
        if(b!=null) {
            if (loadFactor < maxLoad)
                HashingWrapper.loadFileQuadratic(openADDHash, key.trim(), b);
            else {
                LKV[] temp = new LKV[(openADDHash.length * 2)];

                this.size = temp.length;
                openADDHash = HashingWrapper.reHashQuad(openADDHash, temp, key.trim(), b);
            }
            numOfelements++;

        }
    }
    public void addNewLinear(String key, String value){

        if(openLinHash==null){
            this.openLinHash= new LKV[size];
            ledger = ledger + " : Linear Table ";

        }
        float loadFactor =  numOfelements/size;
        byte[] b = genterateBytearray(value);
        if(b!=null) {
            if (loadFactor < maxLoad)
                HashingWrapper.loadFileLinear(openLinHash, key.trim(), b);
            else {
                LKV[] temp = new LKV[(openLinHash.length * 2)];

                this.size = temp.length;
                openLinHash = HashingWrapper.reHashLinear(openLinHash, temp, key.trim(), b);
            }
            numOfelements++;

        }
    }

public void addNewLink(String key, String value){
    if(linkHash==null){
        this.linkHash = new LinkTable[size];
        ledger = ledger + " : Link Table ";

    }
        float loadFactor =  numOfelements/size;

    byte[] b = genterateBytearray(value);
    if(b!=null) {
        if (loadFactor < maxLoad)
            HashingWrapper.loadFileLinkedHash(linkHash, key.trim(), b);
        else {
            LinkTable[] temp = new LinkTable[(linkHash.length * 2)];

            this.size = temp.length;
            linkHash = HashingWrapper.reHash(linkHash, temp, key.trim(), b);
        }
        numOfelements++;

    }
}


public String find(String key){

    int hashValue = (HashingWrapper.HashCode(key)%size);
    String results ="";
            if(linkHash!=null)
      results= results+  "\n"+ HashingWrapper.findNlink(linkHash, key, hashValue);
    if(openADDHash!=null)
    results = results + "\n"+ HashingWrapper.findNLinear(openADDHash,key,hashValue);

    if(openLinHash!=null)
        results = results+"\n"+ HashingWrapper.findNLinear(openLinHash,key,hashValue);
    return results;

}
public static byte[] genterateBytearray(String s){ 
    if(!s.equals("")){
  try{  int lastPos=0;
    byte[] temp = new byte[s.length()];
    StringTokenizer tok = new StringTokenizer(s, ",");
    while(tok.hasMoreTokens()){
        temp[lastPos]= Byte.parseByte(tok.nextToken());
        lastPos++;
    }
    byte[] forReturn = new byte[lastPos];
    for(int i = 0;i<lastPos;i++){
        forReturn[i]= temp[i];
    }
    return forReturn;}
    catch(NumberFormatException e){
        JOptionPane.showMessageDialog(null, "numbers not formatted correctly ");
    }
    }
    else
        JOptionPane.showMessageDialog(null, "numbers not formatted correctly ");
    return null;
}
public LinkTable[] getLinkHash(){
    return linkHash;
}
public void setLinkHash(LinkTable[] linkHash){
    this.linkHash = linkHash;
}
    public LKV[] getQuadHash(){
        return openADDHash;
    }
    public LKV[] getOpenLinHash(){
        return openLinHash;
    }

    public void setQuadHash(LKV[] openADDHash){
        this.openADDHash = openADDHash;
    }
    public String getLedger(){
        return ledger;
    }




}
