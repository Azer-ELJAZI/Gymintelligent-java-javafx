package Interfaces;

import static Interfaces.ClientInterface.window;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Sigin {

     static Scene scene2 ;
      static Scene scene1 ;
      static  Stage window ;


    public static void display() {
         Stage AdminStage = new Stage();
        window = AdminStage ;
          AdminStage.setTitle("Sigin Interface");
        Button btn = new Button();
        btn.setText("               Valider              ");

        Text a3 = new Text("");
        Text a1 = new Text("donner votre name!");
        Text a2 = new Text("donner votre Password!");
        TextField t1 = new TextField();
        PasswordField t2 = new PasswordField();

        Menu fileMenu = new Menu("File");
        MenuItem newFile = new MenuItem("New...");
        newFile.setOnAction(e -> System.out.println("Create a new file..."));
        fileMenu.getItems().add(newFile);
        fileMenu.getItems().add(new MenuItem("Open..."));
        fileMenu.getItems().add(new MenuItem("Save..."));
        fileMenu.getItems().add(new SeparatorMenuItem());
        fileMenu.getItems().add(new MenuItem("Settings..."));
        fileMenu.getItems().add(new SeparatorMenuItem());
        fileMenu.getItems().add(new MenuItem("Exit..."));

        // Edit menu
        Menu editMenu = new Menu("_Edit");
        editMenu.getItems().add(new MenuItem("Cut"));
        editMenu.getItems().add(new MenuItem("Copy"));
        MenuItem paste = new MenuItem("Paste");
        paste.setOnAction(e -> System.out.println("Pasting some crap"));
        paste.setDisable(true);
        editMenu.getItems().add(paste);

        // Help menu
        Menu helpMenu = new Menu("Help");
        CheckMenuItem showLines = new CheckMenuItem("Show Line Numbers");
        showLines.setOnAction(e -> {
            if (showLines.isSelected())
                System.out.println("Program will now display line numbers");
            else
                System.out.println("Hiding line number");
        });
        CheckMenuItem autoSave = new CheckMenuItem("Enable Autosave");
        autoSave.setSelected(true);
        helpMenu.getItems().addAll(showLines, autoSave);

        // Difficulty RadioMenuItems
        Menu difficultyMenu = new Menu("Contact");
        ToggleGroup difficultyToggle = new ToggleGroup();
        RadioMenuItem easy = new RadioMenuItem("26849579");
        RadioMenuItem medium = new RadioMenuItem("98659243");
        RadioMenuItem hard = new RadioMenuItem("azereljazi2020@gmail.com");
        easy.setToggleGroup(difficultyToggle);
        medium.setToggleGroup(difficultyToggle);
        hard.setToggleGroup(difficultyToggle);
        difficultyMenu.getItems().addAll(easy, medium, hard);

        // Main menu bar
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu, editMenu, helpMenu, difficultyMenu);
        menuBar.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

        // Set font style for Text objects
        Font font = Font.font("Arial", 18);
        a1.setFont(font);
        a2.setFont(font);
        a3.setFont(font);

        VBox v1 = new VBox(20);
        v1.getChildren().addAll(a1, t1, a2, t2, a3);
        StackPane root = new StackPane();
        v1.setPadding(new Insets(50, 50, 50, 50));

        Image backgroundImage = new Image("image/rouge.jpg");
        ImageView v = new ImageView(backgroundImage);
        v.setFitWidth(600);
        v.setFitHeight(350);

        root.getChildren().addAll(v, v1, btn, menuBar);
        root.setAlignment(btn, Pos.BOTTOM_RIGHT);
        root.setAlignment(menuBar, Pos.TOP_LEFT);
        root.setAlignment(v1, Pos.BOTTOM_CENTER);
        root.setPadding(new Insets(0, 0, 0, 0));

        v1.setTranslateY(0);
        btn.setTranslateX(-70);
        btn.setTranslateY(-70);
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                String username = t1.getText();
                String password = t2.getText();

                if ("azer".equals(username) && "azer".equals(password)) {
                    // Replace this line with the appropriate action
                    avantAdminInterface.display();
                      ((Stage) btn.getScene().getWindow()).close();
                } else {
                    a3.setText("Votre nom d'utilisateur ou mot de passe est incorrect.");
                }
            }
        });

        scene1 = new Scene(root, 500, 350);

        AdminStage.setScene(scene1);
        AdminStage.show();
    }
}
