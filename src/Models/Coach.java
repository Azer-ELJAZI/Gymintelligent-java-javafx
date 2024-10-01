/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.* ;


public final class Coach extends Employe{
    private int nbProgrames;

    
   
   /*  public Coach() {
        super(); // Appel du constructeur de la classe parente Employe pour saisir les informations communes

        Scanner scanner = new Scanner(System.in);
        System.out.println("Saisir de cordonnee du Coach ");
        System.out.print("Nombre de programmes : ");
        this.nbProgrames = scanner.nextInt();
        scanner.nextLine(); // Pour consommer la nouvelle ligne restante après nextInt()
    }
*/
     public Coach(int matricule, double prixH, String nom, int nb_H,int nbProgrames)  {
        super( matricule,prixH,nom ,nb_H) ;
        this.nbProgrames = nbProgrames;
      
    }

    @Override
    public double calculerPaye() {
        return super.calculerPaye() + nbProgrames; 
    }
   public void ajouterProgramme(Map mapProgrammes) {
       Scanner scanner = new Scanner(System.in);

        System.out.println("Veuillez saisir l'IMC : ");
         double imc = scanner.nextDouble();

        System.out.println("Veuillez saisir le programme d'entraînement : ");
        scanner.nextLine(); // Consommer la nouvelle ligne restante après la saisie de l'IMC
        String programme = scanner.nextLine();

        mapProgrammes.put(imc, programme);
        System.out.println("Programme ajouté pour l'IMC " + imc + ": " + programme);
        mapProgrammes.put(imc, programme);
        System.out.println("Programme ajouté pour l'IMC " + imc + ": " + programme);
    }
    public void nbProgrames(int nbProgrames) {
        this.nbProgrames = nbProgrames;
    }

    
    public int nbProgrames() {
        return nbProgrames;
    }
   
    
    
    


    

    public void enregistrerProgramme(Client client) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Veuillez saisir le programme d'entraînement pour le client " + client.getNom() + " " + client.getPrenom() + " : ");
        String programme = scanner.nextLine();

        // Spécifier le chemin complet du dossier où vous souhaitez enregistrer le fichier
        String cheminDossier = "C:\\Users\\ASUS\\Documents\\NetBeansProjects\\JavaFXApplication13\\Client";

        // Nom du fichier que vous souhaitez créer
        String nomFichier = client.getPhone() + ".txt";

        // Chemin complet du fichier
        String cheminFichier = cheminDossier + File.separator + nomFichier;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(cheminFichier))) {
              System.out.println("********************************************************************");
            writer.write("Coach : " + getNom() + "\n");
              System.out.println("********************************************************************");
            writer.write("Détails du client :\n");
            writer.write("Nom : " + client.getNom() + "\n");
            writer.write("Prénom : " + client.getPrenom() + "\n");
            writer.write("Age : " + client.getAge() + "\n");
            writer.write("Poids : " + client.getPoids() + "\n");
            writer.write("Longueur : " + client.getLongueur() + "\n");
            writer.write("Sexe : " + client.getSexe() + "\n");
            writer.write("IMC : " + client.getImc() + "\n");
            writer.write("Conseil : " + client.getConseil() + "\n");
            writer.write("Programme d'entraînement : " + programme + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Programme enregistré dans le fichier : " + cheminFichier);
    }

public void enregistrerProgramme2(int phone, String programme) {
    // Specify the directory path where you want to save the file
    String directoryPath = "C:\\Users\\ASUS\\Documents\\NetBeansProjects\\JavaFXApplication13\\Client";

    // Name of the file you want to create using the phone number
    String fileName = phone + ".txt";

    // Full path of the file
    String filePath = directoryPath + File.separator + fileName;

    // Check if the file already exists
    File file = new File(filePath);

    try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
        if (file.exists() && file.length() > 0) {
            // File is not empty, add a separator
            System.out.println("********************************************************************");
            writer.write("\n********************************************************************\n");
        } else {
            System.out.println("********************************************************************");
        }

        writer.write("Coach : " + getNom() + "\n");
        writer.write("Program details:\n");
        writer.write("Phone: " + phone + "\n");
        writer.write("Program: " + programme + "\n");
    } catch (IOException e) {
        e.printStackTrace();
    }

    System.out.println("Program saved in the file: " + filePath);
}

    
    
    
    


   public String afficherFichierPourCoach() {
    StringBuilder result = new StringBuilder();

    try {
        // Specify the directory path where the file is located
        String directoryPath = "C:\\Users\\ASUS\\Documents\\NetBeansProjects\\JavaFXApplication13\\Emplyer";
       
        // Create the file with the full path
        File fichierCoach = new File(directoryPath, matricule + ".txt");

        // Check if the coach's file exists
        if (!fichierCoach.exists()) {
            return "Le fichier du coach " + matricule + ".txt n'existe pas.";
        }

        result.append("Ce fichier contient les clients que vous avez concernés à faire un ProgrameEntrainement :\n");

        // Read and accumulate the content of the coach's file
        try (BufferedReader reader = new BufferedReader(new FileReader(fichierCoach))) {
            String ligne;
            while ((ligne = reader.readLine()) != null) {
                result.append(ligne).append("\n");
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }

    return result.toString();
}

}
