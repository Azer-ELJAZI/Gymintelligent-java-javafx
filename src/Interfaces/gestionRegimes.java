package Interfaces;

import static Interfaces.AdminInterface.l;
import static java.lang.ClassLoader.getSystemResourceAsStream;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import Models.Client;
import Models.Regime;
import Models.Regimes;

import java.util.HashMap;
import java.util.Map;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;

public class gestionRegimes {
    private static Scene scene2;
    private static Scene scene1;
    private static Stage window;
    private static Map<Double, Regime> mapExemple = new HashMap<>();
    private static Regimes r = new Regimes(mapExemple);

    public static void display() {
        r.callRegimeDEPrograme(r);
        window = new Stage();
        window.setTitle("Admin Interface");

        StackPane adminLayout = new StackPane();
        
        
        
        Label titleLabel = new Label("                                                        ***Gestion de Régimes***");
        titleLabel.setStyle("-fx-font-weight: bold; -fx-text-fill: red; -fx-font-size: 18px;");

          Menu titremenu = new Menu();
          titremenu.setGraphic(titleLabel);
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
        menuBar.getMenus().addAll(fileMenu, editMenu, helpMenu, difficultyMenu,titremenu);
      
       
         menuBar.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        
        
        
          Image image14 = new Image(getSystemResourceAsStream("image/regime.jpg"));
        ImageView imageView14 = new ImageView();
         image14.isBackgroundLoading() ;
        imageView14.setImage(image14);
 
           imageView14.setFitHeight(900);
        imageView14.setFitWidth(1350);

        
        

        Button ajouterRegimeButton = new Button("Ajouter un regime");
        ajouterRegimeButton.setOnAction(e -> window.setScene(scene2));
        ajouterRegimeButton.setPrefSize(400, 20);
        ajouterRegimeButton.setBackground(new Background(new BackgroundFill(Color.BEIGE, new CornerRadii(5), Insets.EMPTY)));

        Text resultText = new Text("");
        Button afficherRegimesButton = new Button("Afficher la liste des regimes ");
        afficherRegimesButton.setPrefSize(400, 20);
        afficherRegimesButton.setBackground(new Background(new BackgroundFill(Color.BURLYWOOD, new CornerRadii(5), Insets.EMPTY)));

        afficherRegimesButton.setOnAction(e -> {
            resultText.setText(r.afficherRegimes());
        });

        TextField regimeDeleteField1 = new TextField();
        regimeDeleteField1.setMaxWidth(400);
        regimeDeleteField1.setPromptText("imc de regime  à supprimer");

        Button supprimerRegimeByIMCBtn = new Button("Supprimer le regime par imc");
        supprimerRegimeByIMCBtn.setPrefSize(400, 20);
        supprimerRegimeByIMCBtn.setBackground(new Background(new BackgroundFill(Color.RED, new CornerRadii(5), Insets.EMPTY)));
        supprimerRegimeByIMCBtn.setOnAction(e -> {
            try {
                double regimeDeleteField = Double.parseDouble(regimeDeleteField1.getText());
                r.supprimerRegimeParIMC(regimeDeleteField);
            } catch (NumberFormatException ex) {
                System.out.println("Veuillez saisir un numéro de imc valide.");
            }
        });
        
         
          TextField imcToDisplayRegime = new TextField();
          imcToDisplayRegime.setMaxWidth(400);
imcToDisplayRegime.setPromptText("Enter imc");
// Add a Text to display the advice
Text RegimeText = new Text();
// Add Button to trigger afficherConseilByPhone
Button afficherRegimeBtn = new Button("Afficher regime avec imc ");
 afficherRegimeBtn.setPrefSize(400, 20);
        afficherRegimeBtn.setBackground(new Background(new BackgroundFill(Color.GOLD, new CornerRadii(5), Insets.EMPTY)));
afficherRegimeBtn.setOnAction(e -> {
    String imcText = imcToDisplayRegime.getText();
    if (!imcText.isEmpty()) {
        try {
            int imc = Integer.parseInt(imcText);
          r.chercherRegime(imc);
            RegimeText .setText(r.chercherRegime(imc) );
        } catch (NumberFormatException ex) {
            System.out.println("Veuillez entrer un imc valide");
        }
    } else {
        System.out.println("Veuillez entrer un imc de téléphone.");
    }
});
        
        
        
VBox vb21 = new VBox(10);

vb21.getChildren().addAll(
        
        
        
        imcToDisplayRegime,
        afficherRegimeBtn,
        new Label(""),
        RegimeText 
);


        VBox layout14 = new VBox(20);
        layout14.getChildren().addAll(
                menuBar,
          
                    
                ajouterRegimeButton,
                
                afficherRegimesButton,
                resultText,   
                vb21,
                new VBox(10, regimeDeleteField1, supprimerRegimeByIMCBtn)
            
        );

        StackPane layout1 = new StackPane();
        layout1.getChildren().addAll(imageView14,layout14);
        StackPane imageStackPane = new StackPane();
        imageStackPane.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(new StackPane(layout1));

        scene1 = new Scene(scrollPane, 1350, 700);

        Button backButton = new Button("Go back");
        backButton.setOnAction(e -> window.setScene(scene1));

        TextField imcField = new TextField();
         TextArea  regimeField = new  TextArea();
     
    
     
        Button ajouterRegimeBtn = new Button("Ajouter un regime");
        ajouterRegimeBtn.setOnAction(e -> ajouterRegime(imcField.getText(), regimeField.getText()));

        GridPane grid = new GridPane();
        grid.add(new Label("IMC:"), 0, 0);
        grid.add(imcField, 1, 0);

        grid.add(new Label("Régime:"), 0, 1);
        grid.add(regimeField, 1, 1);

        VBox vbox = new VBox(10);
        vbox.getChildren().addAll(new Label("Ajouter un Régime"), grid, ajouterRegimeBtn);
        
       



        StackPane layout2 = new StackPane();
        layout2.getChildren().addAll(vbox, backButton);

        scene2 = new Scene(layout2, 600, 500);
        window.setScene(scene1);
        window.show();
    }

    public gestionRegimes() {
    }

     static void ajouterRegime(String imc, String regime) {
        try {
            double imcValue = Double.parseDouble(imc);
            Regime nouveauRegime = new Regime(regime);
            r.ajouterRegime(imcValue, nouveauRegime);
            System.out.println("Régime ajouté : " + nouveauRegime);
        } catch (NumberFormatException ex) {
            System.out.println("Veuillez entrer un IMC valide.");
        }
    }
}
