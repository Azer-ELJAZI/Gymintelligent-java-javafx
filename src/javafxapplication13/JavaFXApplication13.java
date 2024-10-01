
package javafxapplication13;

import Interfaces.MedcinInterface;
import Interfaces.ClientInterface;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class JavaFXApplication13 extends Application {

    @Override
    public void start(Stage primaryStage) {
        Button clientBtn = new Button("JE SUIS Client");
        Button coachBtn = new Button("Coach");
        Button medcinBtn = new Button("Medcin");

        // Event handlers for each button
        clientBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Client button clicked!");
                ClientInterface.display();
            }
        });

        coachBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Coach button clicked!");
                //CoachInterface.display();
            }
        });

        medcinBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Medcin button clicked!");
                MedcinInterface.display();
            }
        });

        // Welcome message
        javafx.scene.text.Text welcomeText = new javafx.scene.text.Text("Welcome to our application");
        welcomeText.setFill(Color.RED); // Couleur rouge
        welcomeText.setStyle("-fx-font-size: 20px;"); // Taille de la police

        HBox titleBox = new HBox();
        titleBox.getChildren().add(welcomeText);
        titleBox.setAlignment(javafx.geometry.Pos.TOP_CENTER);

        // Buttons container 
        
        HBox buttonBox = new HBox(20); // Vertical box to hold buttons with 20 pixels spacing
        buttonBox.getChildren().addAll(clientBtn, coachBtn, medcinBtn);
        buttonBox.setAlignment(javafx.geometry.Pos.CENTER);

        // Combined layout
        VBox root = new VBox(20); // Vertical box to hold titleBox and buttonBox with 20 pixels spacing
        root.setBackground(new Background(new BackgroundFill(Color.WHITESMOKE, CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY))); // Couleur de fond gris clair
        root.getChildren().addAll(titleBox, buttonBox);

        Scene scene = new Scene(root, 800, 350);

        primaryStage.setTitle("Home Interface");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
