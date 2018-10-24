/**
 * Created by geordie on 11/21/17.
 */
public class HashingWrapper {

    private static int collisionCounter=0;


    public static void loadFileLinear(LKV[] hashTable, String s, byte[] b) {
        int hashValue = (HashCode(s) % hashTable.length);
        LKV newLKV = new LKV(s, b);
        int i = hashValue;
        while (hashTable[i] != null) {
            i = (i + 1) % hashTable.length;
            collisionCounter++;
        }
        hashTable[i] = newLKV;

    }

    public static void loadFileQuadratic(LKV[] hashTable, String s, byte[] b) {
        int hashValue = (HashCode(s) % hashTable.length);
        LKV newLKV = new LKV(s, b);
        int i = hashValue;

        int n = 1;
        while (hashTable[i] != null) {

            i = i + (n ^ 2);

            i = i % hashTable.length;

            n++;
            collisionCounter++;
        }

        hashTable[i] = newLKV;

    }



    public static int HashCode(String s) {

        int hash = 0;
        int g = 31;

        for (int i = 0; i < s.length(); i++){
            hash = g * hash + s.charAt(i);
        }

        hash = hash & 0x7fffffff;//make it positive

        return hash;


    }

    public static void loadFileLinkedHash(LinkTable[] linkHash, String s, byte[] b) {

        int hashValue = (HashCode(s) % linkHash.length);// gets the index position for the new element
        if (linkHash[hashValue] == null) {
            linkHash[hashValue] = new LinkTable();
        }
        else
            collisionCounter++;

        linkHash[hashValue].insert(new LinkElement(new LKV(s, b)));// adds it to the link list at the index position

    }

    public static LinkTable[] reHash(LinkTable[] linkHash, LinkTable[] linkreHash, String s, byte[] b) {// if the load factor is great than maxLoad resize has
        //     System.out.println("entered reHash method ");
        for (int i = 0; i < linkHash.length; i++) {
            if (linkHash[i] != null) {
                LinkElement temp = linkHash[i].getTop();
                while (temp != null) {//goes through linked list and re-adds each element with its new Hash value
                    loadFileLinkedHash(linkreHash, temp.getElement().getKey(), temp.getElement().getAPtr());
                    temp = temp.getNext();
                }
            }

        }
        loadFileLinkedHash(linkreHash, s, b);
        return linkreHash;

    }

    public static LKV[] reHashLinear(LKV[] hashTable, LKV[] reHash, String s, byte[] b) {// if the load factor is great than maxLoad resize has
        //  System.out.println("entered reHash method ");
        for (int i = 0; i < hashTable.length; i++) {
            if (hashTable[i] != null)
                loadFileLinear(reHash, hashTable[i].getKey(), hashTable[i].getAPtr());

        }
        loadFileLinear(reHash, s, b);
        return reHash;

    }



    public static LKV[] reHashQuad(LKV[] hashTable, LKV[] reHash, String s, byte[] b) {// if the load factor is great than maxLoad resize has
        // System.out.println("entered reHash method ");
        for (int i = 0; i < hashTable.length; i++) {
            if (hashTable[i] != null)
                loadFileQuadratic(reHash, hashTable[i].getKey(), hashTable[i].getAPtr());

        }
        loadFileQuadratic(reHash, s, b);
        return reHash;

    }




    public static void displayTable(LinkTable[] linkHash) {
        for (int i = 0; i < linkHash.length; i++) {
            if (linkHash[i] != null) {
                LinkElement temp = linkHash[i].getTop();
                while (temp != null) {
                    System.out.print("index key " + i + " : " + temp.getElement().getKey());
                    for (int j = 0; j < temp.getElement().getAPtr().length; j++) {
                        System.out.print(" : " + temp.getElement().getAPtr()[j]);
                    }
                    System.out.print("\n");
                    temp = temp.getNext();
                }
            }
        }

    }

    public static void displayTableQuad(LKV[] HashTable) {
        for (int i = 0; i < HashTable.length; i++) {
            if (HashTable[i] != null) {
                System.out.print("index key " + i + " " + HashTable[i].getKey());
                if (HashTable[i].getAPtr()!=null){
                for (int j = 0; j < HashTable[i].getAPtr().length; j++) {
                   System.out.print(" : " + HashTable[i].getAPtr()[j]);
                }
                System.out.print("\n");
            }

            }
        }
    }

    public static String findNlink(LinkTable[] linkHash, String key, int hashValue) {
        String result = " not found in hash ";

        if (linkHash[hashValue]!=null) {

        LinkElement temp = linkHash[hashValue].getTop();
        while (!temp.getElement().getKey().equals(key)) {
            temp = temp.getNext();
            if (temp == null) {

                return result;
            }
        }
        result = temp.getElement().getKey() + " " + hashValue;


        }
        return result;
    }

    public static String findNLinear(LKV[] hashTable, String key, int hashValue) {


        int i = hashValue;
        int b = i - 1;

        while (hashTable[i] == null || !hashTable[i].getKey().equals(key)) {

            if (i == b)
                return "not found in the hash";

            i = (i + 1) % hashTable.length;


        }

        return hashTable[i].getKey() + " : " + i;
    }


    public static int getCollisionCounter(){
        return collisionCounter;
    }
    public static void setCollisionCounter(int a){
        collisionCounter = a;
    }

}

