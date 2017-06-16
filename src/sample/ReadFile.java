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
                    List<String> ltList = engMap.get(elements[0]);

                    if (ltList!=null){
                        ltList.add(elements[1]);
                        engMap.put(elements[0],ltList);
                    }
                    else{
                        ltList = new ArrayList<>();
                        ltList.add(elements[1]);
                        engMap.put(elements[0],ltList);
                    }

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
