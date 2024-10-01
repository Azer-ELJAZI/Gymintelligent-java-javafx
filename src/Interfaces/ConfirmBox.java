/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ConfirmBox {
    static boolean anser ;
    public static boolean display(String title,String message){
       Stage window = new Stage();
       window.initModality(Modality.APPLICATION_MODAL);
       window.setTitle(title);
       window.setMinHeight(50);
       window.setMinWidth(250);
         
       Label label =new Label();
       label.setText(message);
       
       Button yes =new Button("yes");
       yes.setPrefSize(80, 25);
      Button no =new Button("no");
        no.setPrefSize(80, 25);
      yes.setOnAction(e->{
          anser = true ;
          window.close();
      });
         no.setOnAction(e->{
          anser = false ;
          window.close();
      });

      
       HBox layout =new HBox(30) ;
       layout.getChildren().addAll(yes,no);
       layout.setAlignment(Pos.CENTER) ;
        VBox layout1 =new VBox(30) ;
        layout1.getChildren().addAll(label,layout);
       Scene scene =new Scene(layout1);
       window.setScene(scene);
       window.showAndWait();
       return anser ;
       
     
    }
    
}
