package Interfaces;

import static java.lang.ClassLoader.getSystemResourceAsStream;
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

/**
 *
 * @author ASUS
 */
public class avantAdminInterface extends Application {
    private static Scene scene2;

    public static void display() {
        Stage primaryStage = new Stage();

        Button Bt = new Button("Gestion de Client ");
        
        Image icon61 = new Image("image/aze.png");
        Image icon62 = new Image("image/employericon.png");
          Image icon63 = new Image("image/materelicon.png");
          Image icon64 = new Image("image/regimeicon.png");
          Image icon65 = new Image("image/programeicon.png");
         
          
          
          
          
          
ImageView iconView61 = new ImageView(icon61);
iconView61.setFitWidth(70); 
iconView61.setFitHeight(50); 
 Bt.setGraphic(iconView61);
        Button Bt1 = new Button("Gestion de Emplyee ");
ImageView iconView62 = new ImageView(icon62);
iconView62.setFitWidth(70); 
iconView62.setFitHeight(50); 
 Bt1.setGraphic(iconView62);
        Button Bt2 = new Button("Gestion de Materal ");
 ImageView iconView63 = new ImageView(icon63);
iconView63.setFitWidth(70); 
iconView63.setFitHeight(50); 
 Bt2.setGraphic(iconView63);
        
        Button Bt3 = new Button("Gestion de  Regimes ");
      ImageView iconView64 = new ImageView(icon64);
iconView64.setFitWidth(70); 
iconView64.setFitHeight(50); 
 Bt3.setGraphic(iconView64);  
        Button Bt4 = new Button("Gestion de  Programes  d'entrenement ");
ImageView iconView65 = new ImageView(icon65);
iconView65.setFitWidth(70); 
iconView65.setFitHeight(50); 
 Bt4.setGraphic(iconView65);
        
              
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
        
        
Bt.setOnMouseEntered(e -> {
    // Changer la couleur de fond en rose
    Bt.setStyle("-fx-background-color: deeppink;-fx-text-fill: blue; -fx-font-weight: bold");
});

// Événement de sortie de la souris
Bt.setOnMouseExited(e -> {
    // Rétablir la couleur de fond par défaut
    Bt.setStyle("");
});
                       
Bt1.setOnMouseEntered(e -> {
    // Changer la couleur de fond en rose
    Bt1.setStyle("-fx-background-color: deeppink;-fx-text-fill: blue; -fx-font-weight: bold");
});

// Événement de sortie de la souris
Bt1.setOnMouseExited(e -> {
    // Rétablir la couleur de fond par défaut
    Bt1.setStyle("");
});
                       
Bt2.setOnMouseEntered(e -> {
    // Changer la couleur de fond en rose
    Bt2.setStyle("-fx-background-color: deeppink;-fx-text-fill: blue; -fx-font-weight: bold");
});

// Événement de sortie de la souris
Bt2.setOnMouseExited(e -> {
    // Rétablir la couleur de fond par défaut
    Bt2.setStyle("");
});
                       
Bt3.setOnMouseEntered(e -> {
    // Changer la couleur de fond en rose
    Bt3.setStyle("-fx-background-color: deeppink;-fx-text-fill: blue; -fx-font-weight: bold");
});

// Événement de sortie de la souris
Bt3.setOnMouseExited(e -> {
    // Rétablir la couleur de fond par défaut
    Bt3.setStyle("");
});
                       
Bt4.setOnMouseEntered(e -> {
    // Changer la couleur de fond en rose
    Bt4.setStyle("-fx-background-color: deeppink;-fx-text-fill: blue; -fx-font-weight: bold");
});

// Événement de sortie de la souris
Bt4.setOnMouseExited(e -> {
    // Rétablir la couleur de fond par défaut
    Bt4.setStyle("");
});
                       

        
        
        Bt.setPrefSize(250, 50);
        Bt1.setPrefSize(250, 50);
        Bt2.setPrefSize(250, 50);
        Bt3.setPrefSize(250, 50);
        Bt4.setPrefSize(250, 50);

        VBox buttonBox = new VBox(20);
        buttonBox.getChildren().addAll(Bt, Bt1, Bt2, Bt3, Bt4);
     

        Bt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("admin button clicked!");
                AdminInterface.display();
            }
        });
        Bt1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("admin button clicked!");
                gestionEmloyes.display();
            }
        });
          Bt2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Gestion materiel  button clicked!");
                GestionMateriel.display();
            }
        });
        Bt3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("admin button clicked!");
                gestionRegimes.display();
            }
        });
         Bt4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("admin button clicked!");
                GestionPrograme.display();
            }
        });
         
        Image image1 = new Image(getSystemResourceAsStream("image/h.jpg"));
        ImageView imageView1 = new ImageView(image1);
        VBox imageBox = new VBox(20);
        imageBox.getChildren().add(imageView1);
       
         Image im = new Image(getSystemResourceAsStream("image/w.png"));
        ImageView imag = new ImageView(im);
        VBox imBox = new VBox(20);
        imBox.getChildren().add(imag);
        imBox.setAlignment(Pos.TOP_CENTER);
           imBox.setPadding(new Insets(27, 27, 27, 27));
        
        
          HBox parentBox = new HBox(70);
          
        parentBox.getChildren().addAll( imageBox,buttonBox);
        parentBox.setAlignment(Pos.BOTTOM_CENTER);
        parentBox.setPadding(new Insets(170, 50, 50, 50));
        
        
          StackPane layout2 =new StackPane();
           layout2.getChildren().addAll(imBox,parentBox,menuBar);
           
           layout2.setAlignment(menuBar,Pos.TOP_LEFT);
          layout2.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY)));
              menuBar.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

        Scene scene2 = new Scene( layout2,900, 540);
       
        primaryStage.setScene(scene2);
        primaryStage.show();
    }

   

    @Override
    public void start(Stage primaryStage) {
        // This method will be empty as the display method is now static
    }
}
