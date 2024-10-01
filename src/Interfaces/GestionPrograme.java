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
import Models.ProgrameEntrainement;
import Models.ProgramesEntrainement;

public class GestionPrograme {
    private static Scene scene2;
    private static Scene scene1;
    private static Stage window;
    
      private static Map<Double, ProgrameEntrainement> mapExemple2 = new HashMap<>();

    public GestionPrograme() {
    }
         
       private static  ProgramesEntrainement p=new ProgramesEntrainement(mapExemple2) ;
    public static void display() {
      
        window = new Stage();
        window.setTitle("Admin Interface");
         p.callProgrames(p);
        StackPane adminLayout = new StackPane();
        
        
        
           Label titleLabel = new Label("                                                        ***Gestion des Programes***");
        titleLabel.setStyle("-fx-font-weight: bold; -fx-text-fill: blue; -fx-font-size: 18px;");

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
        
        
        
        
        
          Image image14 = new Image(getSystemResourceAsStream("image/gym.jpg"));
        ImageView imageView14 = new ImageView();
         image14.isBackgroundLoading() ;
        imageView14.setImage(image14);
 
           imageView14.setFitHeight(900);
        imageView14.setFitWidth(1350);

        
        
        Button ajouterRegimeButton = new Button("Ajouter un programe");
        ajouterRegimeButton.setOnAction(e -> window.setScene(scene2));
        ajouterRegimeButton.setPrefSize(400, 20);
        ajouterRegimeButton.setBackground(new Background(new BackgroundFill(Color.BLUE, new CornerRadii(5), Insets.EMPTY)));

        Text resultText = new Text("");
        Button afficherProgramesButton = new Button("Afficher la liste des Programe ");
        afficherProgramesButton.setPrefSize(400, 20);
        afficherProgramesButton.setBackground(new Background(new BackgroundFill(Color.AQUA, new CornerRadii(5), Insets.EMPTY)));

        afficherProgramesButton.setOnAction(e -> {
            resultText.setText(p.afficherProgrammes());
        });

        TextField pogrameDeleteField1 = new TextField();
        pogrameDeleteField1.setMaxWidth(400);
        pogrameDeleteField1.setPromptText("imc de programe  à supprimer");

        Button supprimerpogrameByIMCBtn = new Button("Supprimer le pograme par imc");
        supprimerpogrameByIMCBtn.setPrefSize(400, 20);
        supprimerpogrameByIMCBtn.setBackground(new Background(new BackgroundFill(Color.ORANGE, new CornerRadii(5), Insets.EMPTY)));
        supprimerpogrameByIMCBtn.setOnAction(e -> {
            try {
                double pogrameDelete = Double.parseDouble(pogrameDeleteField1.getText());
                p.supprimerProgrameParIMC(pogrameDelete);
            } catch (NumberFormatException ex) {
                System.out.println("Veuillez saisir un numéro de imc valide.");
            }
        });
        
         
          TextField imcToDisplayPrograme = new TextField();
          imcToDisplayPrograme.setMaxWidth(400);
imcToDisplayPrograme.setPromptText("Enter imc");
// Add a Text to display the advice
Text RegimeText = new Text();
// Add Button to trigger afficherConseilByPhone
Button afficherRegimeBtn = new Button("Afficher Programe avec imc ");
 afficherRegimeBtn.setPrefSize(400, 20);
        afficherRegimeBtn.setBackground(new Background(new BackgroundFill(Color.GOLDENROD, new CornerRadii(5), Insets.EMPTY)));
afficherRegimeBtn.setOnAction(e -> {
    String imcText = imcToDisplayPrograme.getText();
    if (!imcText.isEmpty()) {
        try {
            double imc = Integer.parseInt(imcText);
          p.chercherPrograme(imc);
            RegimeText .setText(p.chercherPrograme(imc) );
        } catch (NumberFormatException ex) {
            System.out.println("Veuillez entrer un imc valide");
        }
    } else {
        System.out.println("Veuillez entrer un imc de téléphone.");
    }
});
        
        
        
VBox vb21 = new VBox(10);

vb21.getChildren().addAll(
        
        
        
        imcToDisplayPrograme,
        afficherRegimeBtn,
        new Label(""),
        RegimeText 
);


StackPane layout1 = new StackPane();

        VBox layout14 = new VBox(20);
        layout14.getChildren().addAll(
                menuBar,
             
                    
                ajouterRegimeButton,
                
                afficherProgramesButton,
                resultText,   
                vb21,
                new VBox(10, pogrameDeleteField1, supprimerpogrameByIMCBtn)
            
        );
        layout1.getChildren().add(imageView14);
        layout1.getChildren().addAll(layout14);

        StackPane imageStackPane = new StackPane();
        imageStackPane.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(new StackPane(layout1));

        scene1 = new Scene(scrollPane, 1350, 700);

        Button backButton = new Button("Go back");
        backButton.setOnAction(e -> window.setScene(scene1));

        TextField imcField = new TextField();
         TextArea  regimeField = new  TextArea ();
     

    
        Button ajouterRegimeBtn = new Button("Ajouter un regime");
        ajouterRegimeBtn.setOnAction(e -> ajouterPrograme(imcField.getText(), regimeField.getText()));

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

     static void ajouterPrograme (String imc, String regime) {
        try {
            double imcValue = Double.parseDouble(imc);
            ProgrameEntrainement  nouveauRegime = new ProgrameEntrainement(regime);
            p.ajouterProgrameEntrainement(imcValue, nouveauRegime);
            System.out.println("Régime ajouté : " + nouveauRegime);
        } catch (NumberFormatException ex) {
            System.out.println("Veuillez entrer un IMC valide.");
        }
    }
}
