package sample;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by RimaLinaburgyte on 6/15/2017.
 */
public class ReadFile {

    private Map<String, List<String>> engMap;
    private Map<String, List<String>> ltMap;

    ReadFile(Map<String, List<String>> engMap, Map<String, List<String>> ltMap){
        this.engMap = engMap;
        this.ltMap = ltMap;
    }

    public void ReadFile(){

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("zodziai.txt")));
            String line=null;
            while((line=bufferedReader.readLine())!=null){
                String[] elements = line.split("-");
                if (elements.length == 2){

                    addItemMap(elements[0], elements[1], engMap);
                    addItemMap(elements[1], elements[0], ltMap);

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void addItemMap(String key, String value, Map<String, List<String>> map){

        List<String> words = map.get(key);// gauti value is map'o pagal key
        if (words==null){
            words = new ArrayList<>();
        }
        words.add(value); //i lista ideda reiksme
        map.put(key, words); //idedam lista i map'a

    }
}
