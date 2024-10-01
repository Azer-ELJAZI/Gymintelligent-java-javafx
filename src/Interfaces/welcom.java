/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package Interfaces;

import static java.lang.ClassLoader.getSystemResourceAsStream;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import Interfaces.AdminInterface;
import javafx.geometry.Insets;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;

import javafx.application.Application;
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
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author ASUS
 */
public class welcom extends Application {

    Stage window;
    Button button;
    Scene scene1, scene2;

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.getIcons().add(new Image("image/zz.png"));
        window.setTitle("HEALTH CLUB");
        window.setOnCloseRequest(e -> closeP());

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
            if (showLines.isSelected()) {
                System.out.println("Program will now display line numbers");
            } else {
                System.out.println("Hiding line number");
            }
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
        MenuBar menuBar2 = new MenuBar();
        menuBar2.getMenus().addAll(fileMenu, editMenu, helpMenu, difficultyMenu);
        menuBar.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        menuBar2.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

        Button open = new Button("Start");
        Image icon = new Image("image/hi.png");

// Créer une vue d'image pour afficher l'icône
        ImageView iconView = new ImageView(icon);
        iconView.setFitWidth(70); // Ajuster la largeur de l'icône
        iconView.setFitHeight(70); // Ajuster la hauteur de l'icône

// Ajouter l'icône à côté du texte du bouton
        open.setGraphic(iconView);

        open.setOnMouseEntered(e -> {
            // Changer la couleur de fond en rose
            open.setStyle("-fx-background-color: DodgerBlue;-fx-text-fill: blue; -fx-font-weight: bold");
        });

// Événement de sortie de la souris
        open.setOnMouseExited(e -> {
            // Rétablir la couleur de fond par défaut
            open.setStyle("");
        });

        open.setBackground(new Background(new BackgroundFill(Color.CHARTREUSE, new CornerRadii(5), Insets.EMPTY)));
        open.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(5), new BorderWidths(2))));

        open.setPrefSize(400, 70);
        open.setTranslateX(120);
        open.setTranslateY(30);
        open.setOnAction(e -> window.setScene(scene2));

        button = new Button("close");

        Image icon6 = new Image("image/bye.png");

// Créer une vue d'image pour afficher l'icône
        ImageView iconView6 = new ImageView(icon6);
        iconView6.setFitWidth(70); // Ajuster la largeur de l'icône
        iconView6.setFitHeight(70); // Ajuster la hauteur de l'icône

// Ajouter l'icône à côté du texte du bouton
        button.setGraphic(iconView6);

        button.setOnMouseEntered(e -> {
            // Changer la couleur de fond en rose
            button.setStyle("-fx-background-color: DodgerBlue;-fx-text-fill: blue; -fx-font-weight: bold");
        });

// Événement de sortie de la souris
        button.setOnMouseExited(e -> {
            // Rétablir la couleur de fond par défaut
            button.setStyle("");
        });

        button.setBackground(new Background(new BackgroundFill(Color.RED, new CornerRadii(5), Insets.EMPTY)));
        button.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(5), new BorderWidths(2))));

        button.setOnAction(e -> {
            e.consume();
            closeP();

        });
        Text text = new Text();
        text.setText(" ");
        text.setStyle("-fx-underline: true;-fx-font-size: 50px;");
        text.setFill(Color.RED); // Couleur rouge

        Image image10 = new Image(getSystemResourceAsStream("image/ttttt.jpg"));
        ImageView imageView10 = new ImageView();
        image10.isBackgroundLoading();
        imageView10.setImage(image10);

        HBox titleBox = new HBox();
        titleBox.getChildren().add(imageView10);
        titleBox.setAlignment(javafx.geometry.Pos.TOP_CENTER);

        Text a = new Text();
        a.setText("If you want to exit ,click close :");
        a.setFill(Color.BLACK); // Couleur rouge
        a.setStyle("-fx-font-size: 20px;");

        HBox close = new HBox();
        close.getChildren().add(a);
        a.setTranslateX(120); // déplace le texte de 100 unités vers la droite
        a.setTranslateY(140);

        Text b = new Text();
        b.setText("HEALTH_CLUB  is ready to start a new challenge !");
        b.setFill(Color.BLUE); // Couleur rouge
        b.setStyle("-fx-font-size: 25px;");
        b.setTranslateX(130); // déplace le texte de 100 unités vers la droite
        b.setTranslateY(-140);

        Text c = new Text();
        c.setText("If you want to start ,click Start :");
        c.setFill(Color.BLACK); // Couleur rouge
        c.setStyle("-fx-font-size: 20px;");
        c.setTranslateX(120); // déplace le texte de 100 unités vers la droite
        c.setTranslateY(-40);

        Image image = new Image(getSystemResourceAsStream("image/zz.png"));
        ImageView imageView = new ImageView();
        image.isBackgroundLoading();
        imageView.setImage(image);

        Image backgroundImage = new Image("image/tttt.jpg"); // Remplacez par le chemin de votre image

        // Créer une vue d'image pour l'arrière-plan
        ImageView backgroundView = new ImageView(backgroundImage);

        StackPane layout = new StackPane();
        layout.getChildren().addAll(backgroundView, titleBox, imageView, button, a, c, open, menuBar);
        StackPane.setAlignment(menuBar, javafx.geometry.Pos.TOP_LEFT);
        StackPane.setAlignment(backgroundView, javafx.geometry.Pos.BOTTOM_RIGHT);
        StackPane.setAlignment(imageView, javafx.geometry.Pos.BOTTOM_LEFT);
        backgroundView.setTranslateX(180);
        backgroundView.setTranslateY(130);
        backgroundView.setFitHeight(500);
        backgroundView.setFitWidth(550);
        imageView.setFitHeight(350);
        imageView.setFitWidth(300);

        imageView10.setTranslateY(30);

        imageView.setTranslateX(+30.0);
        imageView.setTranslateY(-30.0);

        button.setPrefSize(400, 70);
        button.setTranslateX(120);
        button.setTranslateY(200);
        layout.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY)));
        Scene scene1 = new Scene(layout, 900, 650);

        Button button2 = new Button("go back -->");
        button2.setBackground(new Background(new BackgroundFill(Color.RED, new CornerRadii(5), Insets.EMPTY)));
        button2.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(5), new BorderWidths(2))));
        button2.setOnAction(e -> window.setScene(scene1));

        Image image1 = new Image(getSystemResourceAsStream("image/zz.png"));
        ImageView imageView1 = new ImageView(image1);
        imageView1.setTranslateX(-150.0);

        Text choix = new Text();
        choix.setText(" Identifier vous !");
        choix.setStyle("-fx-font-size: 50px;;-fx-underline: true;");
        choix.setFill(Color.RED); // Couleur rouge

        choix.setTranslateY(-200);

        Image iden = new Image("image/iden.jpg"); // Remplacez par le chemin de votre image

        // Créer une vue d'image pour l'arrière-plan
        ImageView iden1 = new ImageView(iden);

        iden1.setTranslateY(-155);
        iden1.setFitWidth(600); // Ajuster la largeur de l'icône
        iden1.setFitHeight(150);

        Button adminBtn = new Button("Je suis l'admin");

        Button clientBtn = new Button(" Je suis un client");
        Button coachBtn = new Button("Je suis un Coach");
        Button medcinBtn = new Button("je suis un Medcin");

        adminBtn.setPrefSize(250, 50);
        clientBtn.setPrefSize(250, 50);
        coachBtn.setPrefSize(250, 50);
        medcinBtn.setPrefSize(250, 50);

        Image icon1 = new Image("image/adminicon.png");

// Créer une vue d'image pour afficher l'icône
        ImageView iconView1 = new ImageView(icon1);
        iconView1.setFitWidth(50); // Ajuster la largeur de l'icône
        iconView1.setFitHeight(35); // Ajuster la hauteur de l'icône

// Ajouter l'icône à côté du texte du bouton
        adminBtn.setGraphic(iconView1);

        Image icon2 = new Image("image/clienticon.png");

// Créer une vue d'image pour afficher l'icône
        ImageView iconView2 = new ImageView(icon2);
        iconView2.setFitWidth(75); // Ajuster la largeur de l'icône
        iconView2.setFitHeight(55); // Ajuster la hauteur de l'icône

// Ajouter l'icône à côté du texte du bouton
        clientBtn.setGraphic(iconView2);

        Image icon3 = new Image("image/coachicon.png");

// Créer une vue d'image pour afficher l'icône
        ImageView iconView3 = new ImageView(icon3);
        iconView3.setFitWidth(60); // Ajuster la largeur de l'icône
        iconView3.setFitHeight(35); // Ajuster la hauteur de l'icône

// Ajouter l'icône à côté du texte du bouton
        coachBtn.setGraphic(iconView3);

        Image icon4 = new Image("image/medcinicon.png");

// Créer une vue d'image pour afficher l'icône
        ImageView iconView4 = new ImageView(icon4);
        iconView4.setFitWidth(55); // Ajuster la largeur de l'icône
        iconView4.setFitHeight(35); // Ajuster la hauteur de l'icône

// Ajouter l'icône à côté du texte du bouton
        medcinBtn.setGraphic(iconView4);

        adminBtn.setOnMouseEntered(e -> {
            // Changer la couleur de fond en rose
            adminBtn.setStyle("-fx-background-color: DodgerBlue;-fx-text-fill: blue; -fx-font-weight: bold");
        });

// Événement de sortie de la souris
        adminBtn.setOnMouseExited(e -> {
            // Rétablir la couleur de fond par défaut
            adminBtn.setStyle("");
        });

        clientBtn.setOnMouseEntered(e -> {
            // Changer la couleur de fond en rose
            clientBtn.setStyle("-fx-background-color: DodgerBlue;-fx-text-fill: blue; -fx-font-weight: bold");
        });

// Événement de sortie de la souris
        clientBtn.setOnMouseExited(e -> {
            // Rétablir la couleur de fond par défaut
            clientBtn.setStyle("");
        });

        coachBtn.setOnMouseEntered(e -> {
            // Changer la couleur de fond en rose
            coachBtn.setStyle("-fx-background-color: DodgerBlue;-fx-text-fill: blue; -fx-font-weight: bold");
        });

// Événement de sortie de la souris
        coachBtn.setOnMouseExited(e -> {
            // Rétablir la couleur de fond par défaut
            coachBtn.setStyle("");
        });

        medcinBtn.setOnMouseEntered(e -> {
            // Changer la couleur de fond en rose
            medcinBtn.setStyle("-fx-background-color: DodgerBlue;-fx-text-fill: blue; -fx-font-weight: bold");
        });

// Événement de sortie de la souris
        medcinBtn.setOnMouseExited(e -> {
            // Rétablir la couleur de fond par défaut
            medcinBtn.setStyle("");
        });

        VBox buttonBox = new VBox(20);
        buttonBox.getChildren().addAll(adminBtn, clientBtn, coachBtn, medcinBtn);
        buttonBox.setTranslateX(300);
        buttonBox.setTranslateY(180);

        adminBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("admin  button clicked!");
                Sigin.display();
            }
        });

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
                CoachInterface.display();
            }
        });

        medcinBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Medcin button clicked!");
                MedcinInterface.display();
            }
        });

        StackPane layout2 = new StackPane();
        layout2.getChildren().addAll(imageView1, buttonBox, button2, iden1, menuBar2);
        imageView1.setTranslateY(60);

        scene2 = new Scene(layout2, 600, 500);

        StackPane.setAlignment(button2, javafx.geometry.Pos.BOTTOM_RIGHT);
        layout2.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY)));
        StackPane.setAlignment(backgroundView, Pos.CENTER);
        layout2.setAlignment(menuBar2, Pos.TOP_LEFT);

        primaryStage.setScene(scene1);
        primaryStage.show();

    }

    private void closeP() {
        Boolean anser = ConfirmBox.display("Qestion", "Vous voulez vraiment Quittez?");
        if (anser) {
            window.close();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}
