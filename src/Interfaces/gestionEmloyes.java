
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
import Models.Coach;
import Models.Employes;
import Models.EmplyesException;
import Models.Medcin;
import static Models.Poste.CLIENT;
public class gestionEmloyes {
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
          
        
        AdminStage.setTitle("Admin Interface");
       
        StackPane AdminLayout = new StackPane();
        
        
        
        
         
        Label titleLabel = new Label("                                                        ***Gestion des Emplyees***");
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
        
        
        
        
        Button butt =new Button("ajouter Employer ");
        
        butt.setOnAction(e->window.setScene(scene2));
         
        
        butt.setPrefSize(400, 20);
        butt.setBackground(new Background(new BackgroundFill(Color.CHARTREUSE, new CornerRadii(5), Insets.EMPTY)));
       
        
        Text  t =new Text(""); 
        
        Button afficheremployers =new Button("Afficher la liste des empolyees  ") ;
          afficheremployers.setPrefSize(400, 20);
        afficheremployers.setBackground(new Background(new BackgroundFill(Color.AQUA, new CornerRadii(5), Insets.EMPTY)));
        
        afficheremployers.setOnAction(e->{
            t.setText(e1.afficherEmployes()); 
        });
        
        
        
          Text  t1 =new Text(""); 
        
        Button afficheremployersselonSalaire =new Button("Afficher la liste des empolyees triee selon les salaires  ") ;
          afficheremployersselonSalaire.setPrefSize(400, 20);
        afficheremployersselonSalaire.setBackground(new Background(new BackgroundFill(Color.BEIGE, new CornerRadii(5), Insets.EMPTY)));
        
        afficheremployersselonSalaire.setOnAction(e->{
            t.setText(e1.afficherEmployeSorteeParSalaire(e1)); 
        });
        
        
         Text  t2 =new Text(""); 
        
        Button afficheremployersselonHeure =new Button("Afficher la liste des employer triee selon les heurs travilee  ") ;
          afficheremployersselonHeure.setPrefSize(400, 20);
        afficheremployersselonHeure.setBackground(new Background(new BackgroundFill(Color.GREENYELLOW, new CornerRadii(5), Insets.EMPTY)));
        
        afficheremployersselonHeure.setOnAction(e->{
            t.setText(e1.afficherEmployeSorteeParHeureTravaille(e1)); 
        });
        
        Button afficheremployersselonHeureplus20 =new Button("Afficher la liste des employer  qui travilee plus que 20h triee selon les heurs travilee  ") ;
          afficheremployersselonHeureplus20.setPrefSize(400, 20);
        afficheremployersselonHeureplus20.setBackground(new Background(new BackgroundFill(Color.GREENYELLOW, new CornerRadii(5), Insets.EMPTY)));
        
        afficheremployersselonHeureplus20.setOnAction(e->{
            t.setText(e1.afficherEmployeSorteeParHeureTravailleplusque20()); 
        });
        
        
        
        TextField matriculeToDeleteField = new TextField();
        matriculeToDeleteField.setMaxWidth(400);
matriculeToDeleteField.setPromptText("matricule de emplyer à supprimer");

Button supprimerEmployerByPhoneBtn = new Button("Supprimer le employer  par matricule");
  supprimerEmployerByPhoneBtn.setPrefSize(400, 20);
        supprimerEmployerByPhoneBtn.setBackground(new Background(new BackgroundFill(Color.GREEN, new CornerRadii(5), Insets.EMPTY)));
supprimerEmployerByPhoneBtn.setOnAction(e -> {
    try {
        int matriculeToDelete = Integer.parseInt(matriculeToDeleteField.getText());
        e1.supprimerEmploye(matriculeToDelete);   
    } catch (NumberFormatException ex) {
        System.out.println("Veuillez saisir un matricule  valide.");
    }
});  

        VBox layout4= new VBox();
        
VBox vbox2 = new VBox(10);
vbox2.getChildren().addAll(
       
        matriculeToDeleteField,
        supprimerEmployerByPhoneBtn
);

     



TextField matriculeToDisplaySalaire = new TextField();
matriculeToDisplaySalaire.setMaxWidth(400);
matriculeToDisplaySalaire.setPromptText("Enter matricule number");
// Add a Text to display the advice
Text conseilText = new Text();
// Add Button to trigger afficherConseilByPhone
Button afficherSalaireBtn = new Button("Afficher l'employee ");
 afficherSalaireBtn.setPrefSize(400, 20);
        afficherSalaireBtn.setBackground(new Background(new BackgroundFill(Color.DARKSEAGREEN, new CornerRadii(5), Insets.EMPTY)));
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


// Add all elements to the layout
VBox vbox8 = new VBox(10);
vbox8.getChildren().addAll(
        
        
        
        matriculeToDisplaySalaire,
        afficherSalaireBtn,
        new Label(""),
        conseilText
);

        Text r =new Text("Gestion des Employers ") ;
        r.setFill(Color.BLUE); // Couleur rouge
         r.setStyle("-fx-font-size: 30px;-fx-underline: true;"); 
       r.setTranslateX(400);
     
       
       
        Image image14 = new Image(getSystemResourceAsStream("image/coach.png"));
        ImageView imageView14 = new ImageView();
         image14.isBackgroundLoading() ;
        imageView14.setImage(image14);
 
           imageView14.setFitHeight(900);
        imageView14.setFitWidth(1350);
      
        
        
          StackPane  layout1 = new StackPane ();
          layout1.getChildren().add(imageView14);
          VBox ll =new VBox(20) ;
          
          ll.getChildren().addAll(menuBar,butt,afficheremployers,afficheremployersselonHeure,afficheremployersselonSalaire,afficheremployersselonHeureplus20,t,vbox2,vbox8);
          layout1.getChildren().addAll(ll);
          StackPane imageStackPane = new StackPane();
        
          imageStackPane.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
           ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(new StackPane(layout1));
        

        r.setTextAlignment(TextAlignment.CENTER);
        
        
      scene1 =new Scene(scrollPane,1350,700);
      
         Button button2 =new Button("go back");
         button2.setOnAction(e -> window.setScene(scene1)); 
         
            StackPane layout2 =new StackPane();
            
         
            
        TextField MatriculeField = new TextField();    
        TextField PrixHField = new TextField();
        
        TextField nb_hField = new TextField();
        TextField nomField = new TextField();
     
        TextField nb_pField = new TextField();
   
         Button ajouteremployertBtn = new Button("Ajouter un Medcin");
        ajouteremployertBtn.setOnAction(e -> ajouterMedcin(
          
                MatriculeField.getText(),
                   
                   
                PrixHField.getText(),
                nomField.getText(),
                nb_hField.getText(),
                
            
                nb_pField.getText()
            
        ));
         Button ajouteremployertBtn2 = new Button("Ajouter un coach");
        ajouteremployertBtn2.setOnAction(e -> ajouterCoach(
          
                MatriculeField.getText(),
                   
                   
                PrixHField.getText(),
                nomField.getText(),
                nb_hField.getText(),
                
            
                nb_pField.getText()
            
        ));
         GridPane grid = new GridPane();
        grid.add(new Label("Matricule:"), 0, 0);
        grid.add(MatriculeField, 1, 0);
          
       
        grid.add(new Label("PrixH:"), 0, 2);
        grid.add(PrixHField, 1, 2);
        
         grid.add(new Label("nombres d'heurs:"), 0, 3);    
        grid.add(nb_hField, 1, 3);
        
        grid.add(new Label("Nom:"), 0, 4);
        grid.add(nomField, 1, 4);
        
       
        grid.add(new Label("nombre des programes:"), 0, 5);
        grid.add(nb_pField, 1, 5);
        
    
          VBox vbox = new VBox(10); // Vertical box pour aligner les éléments verticalement avec 10 pixels d'espace
        vbox.getChildren().addAll(new Label("This is the Client Interface"), grid, ajouteremployertBtn,ajouteremployertBtn2);
        
       

        
        
       layout2.getChildren().addAll(vbox,button2);
       
        scene2 =new Scene(layout2,600,500);
         window.setScene(scene1);
      
 
        
     

        window.show();
     

        AdminStage.show();
    }
       
    
         

        
    private static void ajouterMedcin(String matricule, String prix_h, String nom, String nb_h, String nb_p) {
    try {
        // Convertir les chaînes en types appropriés
        int matriculeValue = Integer.parseInt(matricule);
        double prix_hValue = Double.parseDouble(prix_h);
        int nb_hValue = Integer.parseInt(nb_h);
        int nb_pValue = Integer.parseInt(nb_p);

        // Créer un nouveau client avec les valeurs saisies
        Medcin nouveauMedcin = new Medcin(matriculeValue, prix_hValue, nom, nb_hValue, nb_pValue);

        // Afficher les détails du client dans la console
        System.out.println("Client ajouté : " + nouveauMedcin);

        try {
            e1.ajouterEmploye(nouveauMedcin);
        } catch (EmplyesException e) {
            System.out.println(e.getMessage());
        }

    } catch (NumberFormatException e) {
        System.out.println("Erreur de conversion : Veuillez saisir des valeurs numériques valides pour Matricule, PrixH, Nombres d'heures et Nombre des programmes.");
    }
}

      private static void ajouterCoach(String matricule, String prix_h, String nom, String nb_h, String nb_p) {
    try {
        // Convertir les chaînes en types appropriés
        int matriculeValue = Integer.parseInt(matricule);
        double prix_hValue = Double.parseDouble(prix_h);
        int nb_hValue = Integer.parseInt(nb_h);
        int nb_pValue = Integer.parseInt(nb_p);

        // Créer un nouveau client avec les valeurs saisies
        Coach nouveauMedcin = new Coach(matriculeValue, prix_hValue, nom, nb_hValue, nb_pValue);

        // Afficher les détails du client dans la console
        System.out.println("Client ajouté : " + nouveauMedcin);

        try {
            e1.ajouterEmploye(nouveauMedcin);
        } catch (EmplyesException e) {
            System.out.println(e.getMessage());
        }

    } catch (NumberFormatException e) {
        System.out.println("Erreur de conversion : Veuillez saisir des valeurs numériques valides pour Matricule, PrixH, Nombres d'heures et Nombre des programmes.");
    }
}
        
        
        
   
}


      
     
    

