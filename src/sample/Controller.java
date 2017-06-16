package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Controller {

    @FXML
    private TextField input;

    @FXML
    private TextArea output;

    private Map<String, List<String>> engMap = new HashMap<>();
    private Map<String, List<String>> ltMap = new HashMap<>();


    public void translate(ActionEvent event){
        if(engMap.isEmpty()|| ltMap.isEmpty()){
            ReadFile readFile = new ReadFile(engMap,ltMap);
            readFile.ReadFile();
        }
        String word = input.getText();

        List<String> words = engMap.get(word);


        if (words==null){
            words = ltMap.get(word);

        }
        printResult(words);
    }

    private void printResult(List<String> words){
        if(words!=null && !words.isEmpty()){
            StringBuilder sb = new StringBuilder();
            for(String w: words){

                sb.append(w).append("\n");
            }
            output.setText(sb.toString());

        }
        else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Tokio zodzio juk nera!!!");
            alert.show();;

        }
    }


}
