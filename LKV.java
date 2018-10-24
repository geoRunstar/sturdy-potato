/**
 * Created by geordie on 11/19/17.
 */
public class LKV
{

    private String key ;
    private byte[] associatedPtr;


    public LKV() {


}
    public LKV (String k, byte[] p) {

        key = k; associatedPtr = p;
    }


    public void setAPtr(byte[] p) {


    associatedPtr = p;


    }
    public byte[] getAPtr() {

    return associatedPtr; }

    public void setKey(String k) {
        key = k; }

        public String getKey() {

            return key;
        }


}
