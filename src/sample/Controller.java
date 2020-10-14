package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Controller {
    @FXML TextArea textReceta;
    @FXML Label lbLineas;
    @FXML
    protected void initialize(){
        try{
            File f=new File("src/sample/archivo.txt");
            BufferedReader br=new BufferedReader(new FileReader(f));
            String line="";
            while((line=br.readLine())!=null){
                textReceta.appendText(line+"\n");
            }
        } catch (Exception e) {
            textReceta.setText(e.getLocalizedMessage());
        }
    }
    public void procesar(ActionEvent event){
        String[]lines=textReceta.getText().split("\n");
        lbLineas.setText("Número de líneas: "+String.valueOf(lines.length));
        boolean encontrado=false;
        for(int i=0;i<lines.length;i++){
            if(lines[i].contains("queso")){
                String[]quesos=lines[i].split(" ");
                System.out.println("Cantidad de queso: "+quesos[0]);
            }
            if(lines[i].contains("manzanas")){
                String[]manzanas=lines[i].split(" ");
                System.out.println("Unidad de medida para manzanas: "+manzanas[1]);
            }
            if(encontrado){
                System.out.println(lines[i]);
            }
            if(lines[i].contains("***")){
                encontrado=true;
                System.out.println("Procedimiento:");
            }
        }
    }
}
