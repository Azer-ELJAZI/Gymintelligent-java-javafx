
package Interfaces;

import static java.lang.ClassLoader.getSystemResourceAsStream;
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
import static Models.Poste.CLIENT;
public class AdminInterface {
      static Scene scene2 ;
      static Scene scene1 ;
      static  Stage window ;
      static listeClient l =new listeClient() ;
     static Client c6 =new Client(150.2,183,'F',22,"ranime","namli",29549579,"ali@gmail.com") ;
     static  Client c5 =new Client(50.2,183,'M',22,"azer","jazi",25849579,"azer@gmail.com") ;
         
    public static void display() {
         l.ajouterclient(c5);
           l.ajouterclient(c6);
        Stage AdminStage = new Stage();
        window = AdminStage ;
        AdminStage.setTitle("Admin Interface");
        
        
        
        
        
        
        
        
           Label titleLabel = new Label("                                                        ***Gestion des Clients***");
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
        
        
       
        StackPane AdminLayout = new StackPane();
        
        Button butt =new Button("ajouter client");
        butt.setOnAction(e->window.setScene(scene2));
        butt.setPrefSize(400, 20);
        butt.setBackground(new Background(new BackgroundFill(Color.CHARTREUSE, new CornerRadii(5), Insets.EMPTY)));
        
          Image image14 = new Image(getSystemResourceAsStream("image/c.jpg"));
          
        ImageView imageView14 = new ImageView();
        imageView14.setRotate(180);
         image14.isBackgroundLoading() ;
        imageView14.setImage(image14);
 
           imageView14.setFitHeight(950);
        imageView14.setFitWidth(1350);
        
        
        
        Text  t =new Text(""); 
        Button afficherclient =new Button("Afficher la liste de client ") ;
          afficherclient.setPrefSize(400, 20);
        afficherclient.setBackground(new Background(new BackgroundFill(Color.AQUA, new CornerRadii(5), Insets.EMPTY)));
        
        afficherclient.setOnAction(e->{
            t.setText(l.afficherclients()); 
        });
        
        TextField phoneToDeleteField = new TextField();
        phoneToDeleteField.setMaxWidth(400);
phoneToDeleteField.setPromptText("Numéro de téléphone à supprimer");

Button supprimerClientByPhoneBtn = new Button("Supprimer le client par téléphone");
  supprimerClientByPhoneBtn.setPrefSize(400, 20);
        supprimerClientByPhoneBtn.setBackground(new Background(new BackgroundFill(Color.BLUE, new CornerRadii(5), Insets.EMPTY)));
supprimerClientByPhoneBtn.setOnAction(e -> {
    try {
        int phoneToDelete = Integer.parseInt(phoneToDeleteField.getText());
        l.supprimerClientByPhone(phoneToDelete);
    } catch (NumberFormatException ex) {
        System.out.println("Veuillez saisir un numéro de téléphone valide.");
    }
});  

        VBox layout4= new VBox();
        
VBox vbox2 = new VBox(10);
vbox2.getChildren().addAll(
       
        phoneToDeleteField,
        supprimerClientByPhoneBtn
);

     



TextField phoneToDisplayConseil = new TextField();
phoneToDisplayConseil.setMaxWidth(400);
phoneToDisplayConseil.setPromptText("Enter phone number");
// Add a Text to display the advice
Text conseilText = new Text();
// Add Button to trigger afficherConseilByPhone
Button afficherConseilBtn = new Button("Afficher Conseil");
 afficherConseilBtn.setPrefSize(400, 20);
        afficherConseilBtn.setBackground(new Background(new BackgroundFill(Color.CADETBLUE, new CornerRadii(5), Insets.EMPTY)));
afficherConseilBtn.setOnAction(e -> {
    String phoneText = phoneToDisplayConseil.getText();
    if (!phoneText.isEmpty()) {
        try {
            int phone = Integer.parseInt(phoneText);
          l.afficherConseilByPhone(phone);
            conseilText.setText( l.afficherConseilByPhone(phone));
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
        
        
        
        phoneToDisplayConseil,
        afficherConseilBtn,
        new Label(""),
        conseilText
);

        Text r =new Text("Gestion des Clients ") ;
        r.setFill(Color.BLUE); // Couleur rouge
         r.setStyle("-fx-font-size: 30px;-fx-underline: true;"); 
       r.setTranslateX(400);
     
       
       
        
        
          StackPane  layout1 = new StackPane ();
          
            VBox layout18 = new VBox(20);
          
          layout18.getChildren().addAll(menuBar,butt,afficherclient,t,vbox2,vbox8);
          
          
          layout1.getChildren().add(imageView14);
          layout1.getChildren().addAll(layout18);
          StackPane imageStackPane = new StackPane();
        imageStackPane.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
           ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(new StackPane(layout1));
        

        r.setTextAlignment(TextAlignment.CENTER);
        
        
      scene1 =new Scene(scrollPane,1350,700);
      
         Button button2 =new Button("go back");
         button2.setOnAction(e -> window.setScene(scene1)); 
         
            StackPane layout2 =new StackPane();
            
            
        TextField poidsField = new TextField();
        TextField longueurField = new TextField();
        TextField sexeField = new TextField();
        TextField ageField = new TextField();
        TextField nomField = new TextField();
        TextField prenomField = new TextField();
        TextField phoneField = new TextField();
        TextField adresseMailField = new TextField();
         Button ajouterClientBtn = new Button("Ajouter un client");
        ajouterClientBtn.setOnAction(e -> ajouterEmplyer(
          
                poidsField.getText(),
                longueurField.getText(),
                sexeField.getText(),
                ageField.getText(),
                nomField.getText(),
                prenomField.getText(),
                phoneField.getText(),
                adresseMailField.getText()
        ));
         GridPane grid = new GridPane();
        grid.add(new Label("Poids:"), 0, 0);
        grid.add(poidsField, 1, 0);
        grid.add(new Label("Longueur:"), 0, 1);
        grid.add(longueurField, 1, 1);
        grid.add(new Label("Sexe (M/F):"), 0, 2);
        grid.add(sexeField, 1, 2);
        grid.add(new Label("Age:"), 0, 3);
        grid.add(ageField, 1, 3);
        grid.add(new Label("Nom:"), 0, 4);
        grid.add(nomField, 1, 4);
        grid.add(new Label("Prenom:"), 0, 5);
        grid.add(prenomField, 1, 5);
        grid.add(new Label("Phone:"), 0, 6);
        grid.add(phoneField, 1, 6);
        grid.add(new Label("Adresse Mail:"), 0, 7);
        grid.add(adresseMailField, 1, 7);
    
          VBox vbox = new VBox(10); // Vertical box pour aligner les éléments verticalement avec 10 pixels d'espace
        vbox.getChildren().addAll(new Label("This is the Client Interface"), grid, ajouterClientBtn);
        
       

        
        
       layout2.getChildren().addAll(vbox,button2);
       
        scene2 =new Scene(layout2,600,500);
         window.setScene(scene1);
      
 
        
     

        window.show();
     

        AdminStage.show();
    }
       
    
         

        
      private static void  ajouterEmplyer( String poids ,String longueur, String sexe, String age, String nom, String prenom, String phone, String adresseMail) {
        // Convertir les chaînes en types appropriés
         
        double poidsValue = Double.parseDouble(poids);
        double longueurValue = Double.parseDouble(longueur);
        char sexeValue = sexe.charAt(0);
        int ageValue = Integer.parseInt(age);
        int phoneValue = Integer.parseInt(phone);
  

        // Créer un nouveau client avec les valeurs saisies
        Client nouveauClient = new Client(poidsValue, longueurValue,sexeValue,ageValue, nom, prenom, phoneValue , adresseMail);
   
        // Afficher les détails du client dans la console
        System.out.println("Client ajouté : " + nouveauClient);
        l.ajouterclient(nouveauClient);
        
   
       
    }

      
      
    }

