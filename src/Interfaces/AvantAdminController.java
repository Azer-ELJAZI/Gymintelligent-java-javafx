package Interfaces;

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
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.SeparatorMenuItem;
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
import javafx.stage.Stage;

public class AvantAdminController {
    private static Scene scene2;

    public static void display() {
        Stage primaryStage = new Stage();

        Button Bt = createButton("Gestion de Client ", "image/aze.png");
        Button Bt1 = createButton("Gestion de Employe", "image/employericon.png");
        Button Bt2 = createButton("Gestion de Materiel", "image/materelicon.png");
        Button Bt3 = createButton("Gestion de Regimes", "image/regimeicon.png");
        Button Bt4 = createButton("Gestion de Programes d'entrenement", "image/programeicon.png");

        MenuBar menuBar = createMenuBar();

        Bt.setOnAction(e -> AdminInterface.display());
   
        Bt2.setOnAction(e -> GestionMateriel.display());
   
        Bt4.setOnAction(e -> GestionPrograme.display());

        VBox buttonBox = new VBox(20);
        buttonBox.getChildren().addAll(Bt, Bt1, Bt2, Bt3, Bt4);

        Image image1 = new Image("image/h.jpg");
        ImageView imageView1 = new ImageView(image1);
        VBox imageBox = new VBox(20);
        imageBox.getChildren().add(imageView1);

        Image im = new Image("image/w.png");
        ImageView imag = new ImageView(im);
        VBox imBox = new VBox(20);
        imBox.getChildren().add(imag);
        imBox.setAlignment(Pos.TOP_CENTER);
        imBox.setPadding(new Insets(27, 27, 27, 27));

        HBox parentBox = new HBox(70);
        parentBox.getChildren().addAll(imageBox, buttonBox);
        parentBox.setAlignment(Pos.BOTTOM_CENTER);
        parentBox.setPadding(new Insets(170, 50, 50, 50));

        StackPane layout2 = new StackPane();
        layout2.getChildren().addAll(imBox, parentBox, menuBar);

        layout2.setAlignment(menuBar, Pos.TOP_LEFT);
        layout2.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        menuBar.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

        Scene scene2 = new Scene(layout2, 900, 540);

        primaryStage.setScene(scene2);
        primaryStage.show();
    }

    private static Button createButton(String text, String imagePath) {
        Button button = new Button(text);

        Image iconImage = new Image(imagePath);
        ImageView iconView = new ImageView(iconImage);
        iconView.setFitWidth(70);
        iconView.setFitHeight(50);
        button.setGraphic(iconView);

        button.setOnMouseEntered(e -> button.setStyle("-fx-background-color: deeppink;-fx-text-fill: blue; -fx-font-weight: bold"));
        button.setOnMouseExited(e -> button.setStyle(""));

        button.setPrefSize(250, 50);

        return button;
    }

    private static MenuBar createMenuBar() {
        Menu fileMenu = new Menu("File");
        fileMenu.getItems().addAll(new MenuItem("New..."), new MenuItem("Open..."), new MenuItem("Save..."),
                new SeparatorMenuItem(), new MenuItem("Settings..."), new SeparatorMenuItem(), new MenuItem("Exit..."));

        Menu editMenu = new Menu("_Edit");
        editMenu.getItems().addAll(new MenuItem("Cut"), new MenuItem("Copy"), createPasteMenuItem());

        Menu helpMenu = new Menu("Help");
        CheckMenuItem showLines = new CheckMenuItem("Show Line Numbers");
        CheckMenuItem autoSave = new CheckMenuItem("Enable Autosave");
        helpMenu.getItems().addAll(showLines, autoSave);

        Menu difficultyMenu = new Menu("Contact");
        ToggleGroup difficultyToggle = new ToggleGroup();
        RadioMenuItem easy = new RadioMenuItem("26849579");
        RadioMenuItem medium = new RadioMenuItem("98659243");
        RadioMenuItem hard = new RadioMenuItem("azereljazi2020@gmail.com");
        easy.setToggleGroup(difficultyToggle);
        medium.setToggleGroup(difficultyToggle);
        hard.setToggleGroup(difficultyToggle);
        difficultyMenu.getItems().addAll(easy, medium, hard);

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu, editMenu, helpMenu, difficultyMenu);
        return menuBar;
    }

    private static MenuItem createPasteMenuItem() {
        MenuItem paste = new MenuItem("Paste");
        paste.setOnAction(e -> System.out.println("Pasting some crap"));
        paste.setDisable(true);
        return paste;
    }
}
