package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Controller {

    @FXML
    private TextField input;

    @FXML
    private TextField input2;

    private Map<String, String> engMap = new HashMap<>();
    private Map<String, String> ltMap = new HashMap<>();


    public void translate(ActionEvent event){
        if(engMap.isEmpty()|| ltMap.isEmpty()){
            ReadFile readFile = new ReadFile(engMap,ltMap);
            readFile.ReadFile();
        }
        String inp = input.getText();
        String inp2 = input2.getText();

        String engTransl = engMap.get(inp);
        String ltTransl = ltMap.get(inp2);

        if (engTransl!=null ){

            input2.setText(engTransl);
        }
        else {
            input.setText(ltTransl);
        }
    }
}
