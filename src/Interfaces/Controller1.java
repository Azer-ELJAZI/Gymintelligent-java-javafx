package Interfaces;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Controller1 {
    private Stage window;
    private Scene scene1, scene2;

    public Controller1(Stage primaryStage) {
        this.window = primaryStage;
        initScenes();
        initWelcomeScene();
        initSecondScene();
    }

    private void initScenes() {
     
        initWelcomeScene();
        initSecondScene();
    }

    private void initWelcomeScene() {
       
        Menu fileMenu = new Menu("File");
        MenuItem newFile = new MenuItem("New...");
        newFile.setOnAction(e -> System.out.println("Create a new file..."));
        fileMenu.getItems().add(newFile);
   
        Button open = new Button("Start");
       

        StackPane layout = new StackPane();
        layout.getChildren().addAll();
   
        scene1 = new Scene(layout, 900, 650);
    }
      
       
        
        
    
    
    private void initSecondScene() {
       
    }

    public void showWelcomeScene() {
        window.setScene(scene1);
    }

    public void showSecondScene() {
        window.setScene(scene2);
    }

    private void closeProgram() {
        Boolean answer = ConfirmBox.display("Question", "Vous voulez vraiment Quitter?");
        if (answer) window.close();
    }
}
