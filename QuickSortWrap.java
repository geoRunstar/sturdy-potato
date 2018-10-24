/**
 * Created by geordie on 12/5/17.
 */
public class QuickSortWrap {
  //  LKV[] table;





    public static LKV[] sort(LKV[] table) {


        quicksort(table, 0, table.length - 1);

        return table;
    }

    public static void swop( LKV[] table, int from, int to) {
        LKV temp = table[from];
        table[from] = table[to];
        table[to] = temp;

    }

    public static void quicksort(LKV[] table, int from, int to) {

        if (from >= to) return;

        while(table[from]==null){
            if(from<table.length)
            from++;
        }
        while (table[to]==null){
            if(to>0)
            to--;
        }

        LKV value = table[to];

        int counter = from;

        for (int i = from; i < to; i++) {

            if (table[i]==null || table[i].getKey().compareTo(value.getKey()) <= 0) {

                swop(table,i, counter);
                counter++;
            }
        }
        swop(table,counter, to);
        quicksort(table,from, counter - 1);
        quicksort(table, counter + 1, to);

    }
}