
package Interfaces;

import static Interfaces.AdminInterface.c5;
import static Interfaces.AdminInterface.c6;
import static Interfaces.AdminInterface.l;
import static Interfaces.gestionEmloyes.e1;
import static Interfaces.gestionEmloyes.m5;
import static Interfaces.gestionEmloyes.o5;
import static Interfaces.gestionEmloyes.o7;
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
import Models.Employes;
import Models.EmplyesException;
import Models.Medcin;
import static Models.Poste.CLIENT;
import Models.ProgrameEntrainement;
import Models.ProgramesEntrainement;
import Models.Regime;
import Models.Regimes;
public class ClientInterface {
      static Scene scene2 ;
      static Scene scene1 ;
      static  Stage window ;
        private static Map<Double, ProgrameEntrainement> mapExemple2 = new HashMap<>();
         
       private static  ProgramesEntrainement p=new ProgramesEntrainement(mapExemple2) ;
       static   Employes e1 = new Employes();
           static Medcin m5 =new  Medcin(880,2.5, "Ali ben ahmed",21,4);
           static Medcin m4 =new  Medcin(881,9, "Mostafa abedalkarim",29,10);
     static   Coach o5 =new  Coach(990,2.3,"Aziz ben jmaa",24,2); 
     static    Coach o7 = new    Coach(991,5.0, "Nihel lahmer ", 7,4);
       private static Map<Double, Regime> mapExemple = new HashMap<>();
    private static Regimes r = new Regimes(mapExemple);
          static listeClient l =new listeClient() ;

     static Client c6 =new Client(150.2,183,'F',22,"ranime","namli",29549579,"ali@gmail.com") ;
     static  Client c5 =new Client(50.2,183,'M',22,"azer","jazi",25849579,"azer@gmail.com") ;
       static Client c7 =new Client(80,175,'M',22,"iyed","ben slimen",55666777,"iyed@enicar.com") ;   
    public static void display() {
         try{
          e1.ajouterEmploye(m4);   
         e1.ajouterEmploye(m5);
        e1.ajouterEmploye(o7);
         e1.ajouterEmploye(o5);
           r.callRegimeDEPrograme(r);
            p.callProgrames(p);
        }
         catch(EmplyesException e){ 
        System.out.println(e.getMessage());    }
        Stage AdminStage = new Stage();
        window = AdminStage ;
        AdminStage.setTitle("client Interface");
        
        
        
        
           Label titleLabel = new Label("                                                              ***Welcom Client***");
        titleLabel.setStyle("-fx-font-weight: bold; -fx-text-fill: pink; -fx-font-size: 18px;");

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
        
        
        
        
        
        
        
       l.ajouterclient(c5);
           l.ajouterclient(c6);
             l.ajouterclient(c7);
        StackPane AdminLayout = new StackPane();
        
        Button butt =new Button("ajouter client");
        butt.setOnAction(e->window.setScene(scene2));
        butt.setPrefSize(400, 20);
        butt.setBackground(new Background(new BackgroundFill(Color.CHARTREUSE, new CornerRadii(5), Insets.EMPTY)));
        
          Image image14 = new Image(getSystemResourceAsStream("image/cc1.jpg"));
          
        ImageView imageView14 = new ImageView();
      
         image14.isBackgroundLoading() ;
        imageView14.setImage(image14);
 
           imageView14.setFitHeight(950);
        imageView14.setFitWidth(1350);
        
        
        TextField phoneToDisplayclient = new TextField();
phoneToDisplayclient.setMaxWidth(400);
phoneToDisplayclient.setPromptText("Enter phone number");
// Add a Text to display the advice
Text t = new Text();
Text conseilText1 = new Text();
// Add Button to trigger afficherConseilByPhone
Button afficherClientBtn = new Button("Afficher votre details");
 afficherClientBtn.setPrefSize(400, 20);
        afficherClientBtn.setBackground(new Background(new BackgroundFill(Color.DARKGRAY, new CornerRadii(5), Insets.EMPTY)));
afficherClientBtn.setOnAction(e -> {
    String phoneText = phoneToDisplayclient.getText();
    if (!phoneText.isEmpty()) {
        try {
            int phone = Integer.parseInt(phoneText);
         l.afficherDetailsClientByPhone(phone);
           conseilText1.setText( l.afficherDetailsClientByPhone(phone));
        } catch (NumberFormatException ex) {
            System.out.println("Veuillez entrer un numéro de téléphone valide.");
        }
    } else {
        System.out.println("Veuillez entrer un numéro de téléphone.");
    }
   
});
        
        
        
      
        Button affichercoatch =new Button("Afficher la liste des coach dispo  ") ;
          affichercoatch.setPrefSize(400, 20);
        affichercoatch.setBackground(new Background(new BackgroundFill(Color.ALICEBLUE, new CornerRadii(5), Insets.EMPTY)));
        
        affichercoatch.setOnAction(e->{
            t.setText(e1.afficherListeNomsMatriculesCoachs()); 
        });
        
      
        Button afficherMedcin =new Button("Afficher la liste des Medcis dispo  ") ;
          afficherMedcin.setPrefSize(400, 20);
        afficherMedcin.setBackground(new Background(new BackgroundFill(Color.ANTIQUEWHITE, new CornerRadii(5), Insets.EMPTY)));
        
        afficherMedcin.setOnAction(e->{
            t.setText(e1.afficherListeNomsMatriculesMedcins()); 
        });
        
        
        TextField matriculeField = new TextField();
        matriculeField.setMaxWidth(400);
matriculeField.setPromptText("matricule de emplyer");

TextField phoneField90 = new TextField();

        phoneField90.setMaxWidth(400);
phoneField90.setPromptText("votre phone");



Button afficherFichierBtn = new Button("Afficher votre fichier preparee");
 afficherFichierBtn.setPrefSize(400, 20);
        afficherFichierBtn.setBackground(new Background(new BackgroundFill(Color.DARKGREY, new CornerRadii(5), Insets.EMPTY)));
afficherFichierBtn.setOnAction(e -> {
    String phoneText88 = phoneField90.getText();
    if (!phoneText88.isEmpty()) {
        try {
            int phone = Integer.parseInt(phoneText88);
         l.afficherFichierPrepare(phone);
           t.setText( l.afficherFichierPrepare(phone));
        } catch (NumberFormatException ex) {
            System.out.println("Veuillez entrer un numéro de téléphone valide.");
        }
    } else {
        System.out.println("Veuillez entrer un numéro de téléphone.");
    }
   
});

Button choisirClientByPhoneBtn = new Button("choisir un empolyee ");


  choisirClientByPhoneBtn.setPrefSize(400, 20);
        choisirClientByPhoneBtn.setBackground(new Background(new BackgroundFill(Color.DEEPPINK, new CornerRadii(5), Insets.EMPTY)));
choisirClientByPhoneBtn.setOnAction(e -> {
    try {
        int phoneToDelete = Integer.parseInt(matriculeField.getText());
                int phone = Integer.parseInt(phoneField90.getText());
              try {
               l.getClientByPhone(phone).choisirEmploye2(phoneToDelete);
             } catch (Exception ex) {
        ex.printStackTrace();
    }
                 
          
                 
    } catch (NumberFormatException ex) {
        System.out.println("Veuillez saisir un numéro de téléphone valide.");
    }
});  

        VBox layout4= new VBox();
        
VBox vbox2 = new VBox(10);
vbox2.getChildren().add(phoneField90);
vbox2.getChildren().addAll(
       
        matriculeField,
        choisirClientByPhoneBtn,afficherFichierBtn
);

     



TextField phoneToDisplayConseil = new TextField();
phoneToDisplayConseil.setMaxWidth(400);
phoneToDisplayConseil.setPromptText("Enter phone number");
// Add a Text to display the advice

// Add Button to trigger afficherConseilByPhone
Button afficherConseilBtn = new Button("Afficher Conseil");
 afficherConseilBtn.setPrefSize(400, 20);
        afficherConseilBtn.setBackground(new Background(new BackgroundFill(Color.HOTPINK, new CornerRadii(5), Insets.EMPTY)));
afficherConseilBtn.setOnAction(e -> {
    String phoneText = phoneToDisplayConseil.getText();
    if (!phoneText.isEmpty()) {
        try {
            int phone = Integer.parseInt(phoneText);
         l.afficherConseilByPhone(phone);
           conseilText1.setText( l.afficherConseilByPhone(phone));
        } catch (NumberFormatException ex) {
            System.out.println("Veuillez entrer un numéro de téléphone valide.");
        }
    } else {
        System.out.println("Veuillez entrer un numéro de téléphone.");
    }
   
});
    
    
    
     TextField phoneToDisplayRegime = new TextField();
phoneToDisplayRegime.setMaxWidth(400);
phoneToDisplayRegime.setPromptText("Enter votre imc");

// Add Button to trigger afficherConseilByPhone
Button afficher14 = new Button("Afficher regime de l'application");
 afficher14.setPrefSize(400, 20);
       
 afficher14.setBackground(new Background(new BackgroundFill(Color.MISTYROSE, new CornerRadii(5), Insets.EMPTY)));
 
afficher14.setOnAction(e -> {
    String phoneText1 = phoneToDisplayRegime.getText();
    if (!phoneText1.isEmpty()) {
        try {
            int phone = Integer.parseInt(phoneText1);
  
           conseilText1.setText(r.chercherRegime(phone) );
        } catch (NumberFormatException ex) {
            System.out.println("Veuillez entrer un numéro de téléphone valide.");
        }
    } else {
        System.out.println("Veuillez entrer un numéro de téléphone.");
    }
});



   TextField phoneToDisplayprograme = new TextField();
phoneToDisplayprograme.setMaxWidth(400);
phoneToDisplayprograme.setPromptText("Enter  votre imc  ");

// Add Button to trigger afficherConseilByPhone
Button afficher1 = new Button("Afficher Programe d'entrenement de l'application");
 afficher1.setPrefSize(400, 20);
       
 afficher1.setBackground(new Background(new BackgroundFill(Color.CADETBLUE, new CornerRadii(5), Insets.EMPTY)));
 
afficher1.setOnAction(e -> {
    String phoneText16 = phoneToDisplayprograme.getText();
    if (!phoneText16.isEmpty()) {
        try {
            int phone5 = Integer.parseInt(phoneText16);
  
           conseilText1.setText(p.chercherPrograme(phone5+0.0) );
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
        
             phoneToDisplayprograme   ,afficher1,
        phoneToDisplayRegime,afficher14,
        phoneToDisplayConseil,
        afficherConseilBtn,
        
        new Label(""),
        conseilText1
);

        Text r =new Text("Gestion des Clients ") ;
        r.setFill(Color.BLUE); // Couleur rouge
         r.setStyle("-fx-font-size: 30px;-fx-underline: true;"); 
       r.setTranslateX(400);
     
       
       
        
        
          StackPane  layout1 = new StackPane ();
          
            VBox layout18 = new VBox(20);
          
          layout18.getChildren().addAll(menuBar,phoneToDisplayclient,afficherClientBtn,affichercoatch,afficherMedcin,t,vbox2,vbox8);
          
          
          layout1.getChildren().add(imageView14);
          layout1.getChildren().addAll(layout18);
          StackPane imageStackPane = new StackPane();
        imageStackPane.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
           ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(new StackPane(layout1));
        

        r.setTextAlignment(TextAlignment.CENTER);
        
        
      scene1 =new Scene(scrollPane,1350,700);
      
                 
          
            
            
        
      
       
       

        
        
      
       
       
         window.setScene(scene1);
      
 
        
     

        window.show();
     

        AdminStage.show();
    }
       
    
         

     
      
      
    }

