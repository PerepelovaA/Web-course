import sun.security.jca.GetInstance;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * Created by user on 13.10.2016.
 */
public class Indexer {

    private static Indexer instance;
    private HashMap<String,HashSet<Integer>> indexer;
    FileManager fm = new FileManager();

    private void Indexer(){


        indexer = new HashMap<String, HashSet<Integer>>();

        int index=0;

        String[] arr;
        long b = System.currentTimeMillis();
        Integer i=1;
        HashSet values= new HashSet() ;
       // for(int i=0;i<10;i++){
                arr = fm.getFull_files().get(i).split(" ");
                values.add(i);
                for(int j=0;j<arr.length;j++) {
                    if(indexer.get(arr[j])==null)
                        indexer.put(arr[j],values);
                    else
                    indexer.get(arr[j]).add(i);
                }
                values.clear();
                // возможно нужно сразу из буфера читать строку и разбирать ее на кусочки, а не хранить
        long e = System.currentTimeMillis();
        System.out.println("Time is:"+(e-b));
        //}
    }
    public static Indexer getInstance(){

        if( instance==null)
            instance = new Indexer();
        return instance;
    }
    public List<String> search(String word){

        ArrayList<String> results = new ArrayList<String>();
        HashSet<Integer> file_num = new HashSet<Integer>();
        if(indexer.get(word)!=null)
            file_num = indexer.get(word);
        else
            System.out.println("No file which contains this word!!");
        for (Integer i:file_num) {
           results.add(fm.getFull_files().get(i));
        }
        return results;
    }
}
