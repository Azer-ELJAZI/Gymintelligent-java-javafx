
package Interfaces;

import static java.lang.ClassLoader.getSystemResourceAsStream;
import java.util.HashMap;
import java.util.Map;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
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
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import Models.Client;
import Models.Admin;
import Models.Coach;
import Models.Medcin;
import Models.Employes;
import Models.EmplyesException;
import Models.Medcin;
import static Models.Poste.CLIENT;
import Models.ProgrameEntrainement;
import Models.ProgramesEntrainement;
import Models.Regime;
import Models.Regimes;
public class MedcinInterface {
      static Scene scene2 ;
      static Scene scene1 ;
      static  Stage window ;
     
     
         static   Employes e1 = new Employes();
        
   
          static Medcin m5 =new  Medcin(880,2.5, "Ali ben ahmed",21,4);
           static Medcin m4 =new  Medcin(881,2.5, "Mostafa abedalkarim",21,4);
     static   Coach o5 =new  Coach(990,2.3,"Aziz ben jmaa",24,2); 
     static    Coach o7 = new    Coach(991,5.0, "Nihel lahmer ", 7,4);
         
    public static void display() {
       
        
        
        try{
         e1.ajouterEmploye(m5);
          e1.ajouterEmploye(m4);
         e1.ajouterEmploye(o7);
         e1.ajouterEmploye(o5);
        }
         catch(EmplyesException e){ 
        System.out.println(e.getMessage());    }
        
        
        
        Stage AdminStage = new Stage();
        
        window = AdminStage ;
          
        
        AdminStage.setTitle("medcin Interface");
       
        StackPane AdminLayout = new StackPane();
        
      
        
        
        
        Label titleLabel = new Label("                                                        ***Welcom Medcin***");
        titleLabel.setStyle("-fx-font-weight: bold; -fx-text-fill: green; -fx-font-size: 18px;");

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
        
        
        
        
       
        
        Text  t =new Text(""); 
        
       
      
        
        
        
        
        
          Text  t1 =new Text(""); 
        
      
       
        
         Text  t2 =new Text(""); 
        
       
        
        TextField matriculeToDisplaySalaire = new TextField();
matriculeToDisplaySalaire.setMaxWidth(400);
matriculeToDisplaySalaire.setPromptText("Enter matricule number");
        
        
       
TextField telfclient = new TextField();
telfclient.setMaxWidth(400);
telfclient.setPromptText("Enter phone number de votre client ");
 TextArea   programe = new  TextArea ();
programe.setMaxWidth(400);
programe.setMaxHeight(300);

programe.setPromptText("entrer regime   de votre client ");
// Add a Text to display the advice
gestionRegimes g =new gestionRegimes();
 Map<Double, Regime> mapExemple = new HashMap<>();
           Map<Double, ProgrameEntrainement> mapExemple2 = new HashMap<>();
           Regimes rh=new Regimes(mapExemple) ;
           ProgramesEntrainement p=new ProgramesEntrainement(mapExemple2) ;
          
// Add Button to trigger afficherConseilByPhone
Button  ajouterProgrameBtn = new Button("ajouter regime ");
 ajouterProgrameBtn.setPrefSize(400, 20);
        ajouterProgrameBtn.setBackground(new Background(new BackgroundFill(Color.YELLOW, new CornerRadii(5), Insets.EMPTY)));
ajouterProgrameBtn.setOnAction(e -> {
    String ProgrameText = programe.getText();
    String phoneText = telfclient.getText();
       String phoneText90 = matriculeToDisplaySalaire.getText();
    if (!phoneText.isEmpty()) {
        try {
             int a = Integer.parseInt(phoneText90);
            int atricule = Integer.parseInt(phoneText);
          e1.chercherMedcinByMatricule(a).enregistrerProgramme9(atricule, ProgrameText);
         
        g.ajouterRegime(phoneText90,ProgrameText);
            
        } catch (NumberFormatException ex) {
            System.out.println("Veuillez entrer un numéro de téléphone valide.");
        }
    } else {
        System.out.println("Veuillez entrer telfclient  .");
    }
});
        

     




// Add a Text to display the advice
Text conseilText = new Text();
// Add Button to trigger afficherConseilByPhone
Button afficherSalaireBtn = new Button("Afficher mon details ");
 afficherSalaireBtn.setPrefSize(400, 20);
        afficherSalaireBtn.setBackground(new Background(new BackgroundFill(Color.DARKORANGE, new CornerRadii(5), Insets.EMPTY)));
afficherSalaireBtn.setOnAction(e -> {
    String phoneText = matriculeToDisplaySalaire.getText();
    if (!phoneText.isEmpty()) {
        try {
            int atricule = Integer.parseInt(phoneText);
          e1.afficherSalaireByMatricule(atricule);
            conseilText.setText( e1.afficherSalaireByMatricule(atricule));
        } catch (NumberFormatException ex) {
            System.out.println("Veuillez entrer un numéro de téléphone valide.");
        }
    } else {
        System.out.println("Veuillez entrer un numéro de téléphone.");
    }
});
Button afficherfichierBtn = new Button("Afficher fichier de mon client ");
 afficherfichierBtn.setPrefSize(400, 20);
        afficherfichierBtn.setBackground(new Background(new BackgroundFill(Color.CORAL, new CornerRadii(5), Insets.EMPTY)));
afficherfichierBtn.setOnAction(e -> {
    String phoneText = matriculeToDisplaySalaire.getText();
    if (!phoneText.isEmpty()) {
        try {
            int atricule = Integer.parseInt(phoneText);
          e1.chercherMedcinByMatricule(atricule).afficherFichierPourEmployer();
            conseilText.setText( e1.chercherMedcinByMatricule(atricule).afficherFichierPourEmployer());
        } catch (NumberFormatException ex) {
            System.out.println("Veuillez entrer un numéro de téléphone valide.");
        }
    } else {
        System.out.println("Veuillez entrer un numéro de téléphone.");
    }
});

// Add all elements to the layout
VBox vbox8 = new VBox(10);
vbox8.getChildren().addAll(
        
        
        
        matriculeToDisplaySalaire,
        afficherSalaireBtn,afficherfichierBtn,
        new Label(""),
        conseilText,telfclient,programe,ajouterProgrameBtn
);

        Text r =new Text("welcom Mdcin ") ;
        r.setFill(Color.BLUE); // Couleur rouge
         r.setStyle("-fx-font-size: 30px;-fx-underline: true;"); 
       r.setTranslateX(400);
     
       
       
        Image image14 = new Image(getSystemResourceAsStream("image/rr2.jpg"));
        ImageView imageView14 = new ImageView();
         image14.isBackgroundLoading() ;
        imageView14.setImage(image14);
 
        imageView14.setFitHeight(1200);
        imageView14.setFitWidth(1350);
      
        
        
          StackPane  layout1 = new StackPane ();
          layout1.getChildren().add(imageView14);
          VBox ll =new VBox(20) ;
          
          ll.getChildren().addAll(menuBar,t,vbox8);
          layout1.getChildren().addAll(ll);
          StackPane imageStackPane = new StackPane();
        
          imageStackPane.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
           ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(new StackPane(layout1));
        

        r.setTextAlignment(TextAlignment.CENTER);
        
        
      scene1 =new Scene(scrollPane,1350,700);
      
     
       
         
            StackPane layout2 =new StackPane();
            
         
            
        TextField MatriculeField = new TextField();    
        TextField PrixHField = new TextField();
        
        TextField nb_hField = new TextField();
        TextField nomField = new TextField();
     
        TextField nb_pField = new TextField();
   
        
        
    
    
        
       

        
        
     
       
        scene2 =new Scene(layout2,600,500);
         window.setScene(scene1);
      
 
        
     

        window.show();
     

        AdminStage.show();
    }
       
    
         

        
    
}

        
        
        
   



      
     
    

