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
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public final class Medcin extends Employe{
    private int nbregimes;

    
    public Medcin() {
        super(); // Appel du constructeur de la classe parente Employe pour saisir les informations communes

        Scanner scanner = new Scanner(System.in);
        System.out.println("saisir les cordonnee de Medcin: ");
        System.out.print("Nombre de régimes : ");
        this.nbregimes = scanner.nextInt();
        scanner.nextLine(); // Pour consommer la nouvelle ligne restante après nextInt()
    }

       public Medcin(int matricule, double prixH, String nom, int nb_H,int nbProgrames)  {
        super( matricule,prixH,nom ,nb_H) ;
        this.nbregimes = nbregimes;
       }

    public int getMatricule() {
        return matricule;
    }
    
    
public void afficherFichierPourMedcin() {
    try {
        // Specify the directory path where the file is located
        String directoryPath = "C:\\Users\\ASUS\\Documents\\NetBeansProjects\\JavaFXApplication13\\Emplyer";

        // Create the file with the full path
        File fichierMedcin = new File(directoryPath, matricule + ".txt");

        // Check if the médecin's file exists
        if (!fichierMedcin.exists()) {
            System.out.println("Le fichier du médecin " + matricule + ".txt n'existe pas.");
            return;
        }

        // Display a message before reading and printing the content
        System.out.println("Ce fichier contient les clients que vous avez concernés à faire un régime :");

        // Read and display the content of the médecin's file
        try (BufferedReader reader = new BufferedReader(new FileReader(fichierMedcin))) {
            String ligne;
            while ((ligne = reader.readLine()) != null) {
                System.out.println(ligne);
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}

    public void enregistrerProgramme(Client client) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Veuillez saisir le Regime  pour le client " + client.getNom() + " " + client.getPrenom() + " : ");
        String programme = scanner.nextLine();

        // Spécifier le chemin complet du dossier où vous souhaitez enregistrer le fichier
        String cheminDossier = "C:\\Users\\ASUS\\Documents\\NetBeansProjects\\JavaFXApplication13\\Client";

        // Nom du fichier que vous souhaitez créer
        String nomFichier = client.getPhone() + ".txt";

        // Chemin complet du fichier
        String cheminFichier = cheminDossier + File.separator + nomFichier;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(cheminFichier))) {
              System.out.println("********************************************************************");
            writer.write("Medcin : " + getNom() + "\n");
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




    @Override
    public double calculerPaye() {
        return super.calculerPaye() + nbregimes; 
    }

    public void nbProgrames(int nbProgrames) {
        this.nbregimes = nbregimes;
    }

    
    public int nbProgrames() {
        return nbregimes;
    }

     public void enregistrerProgramme7(Client client, String programme) {
        // Specify the directory path where the file is located
        String directoryPath = "C:\\Users\\ASUS\\Documents\\NetBeansProjects\\JavaFXApplication13\\Client";

        // Create the file with the full path
        File fichierClient = new File(directoryPath, client.getPhone() + ".txt");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fichierClient))) {
            System.out.println("********************************************************************");
            writer.write("Medcin : " + getNom() + "\n");
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

        System.out.println("Programme enregistré dans le fichier : " + fichierClient);
    }
     
       Map<Double, Regime> mapExemple = new HashMap<>();
           Map<Double, ProgrameEntrainement> mapExemple2 = new HashMap<>();
           Regimes r=new Regimes(mapExemple) ;
           ProgramesEntrainement p=new ProgramesEntrainement(mapExemple2) ;
     
 public void enregistrerProgramme9(int phone, String programme) {
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

        writer.write("Medcin : " + getNom() + "\n");
        writer.write("Program details:\n");
        writer.write("Phone: " + phone + "\n");
        writer.write("Program: " + programme + "\n");
        Regime regime=new Regime(programme);
        r.ajouterRegime(getMatricule()+0.0, regime);
    } catch (IOException e) {
        e.printStackTrace();
    }

    System.out.println("Program saved in the file: " + filePath);
}



    public String afficherFichierPourMedcin(Client client) {
        // Specify the directory path where the file is located
        String directoryPath = "C:\\Users\\ASUS\\Documents\\NetBeansProjects\\JavaFXApplication13\\Client";

        // Create the file with the full path
        File fichierClient = new File(directoryPath, client.getPhone() + ".txt");

        // Check if the client's file exists
        if (!fichierClient.exists()) {
            return "Le fichier du client " + client.getPhone() + ".txt n'existe pas.";
        }

        // Display a message before reading and printing the content
        StringBuilder result = new StringBuilder();
        result.append("Ce fichier contient les informations du client " + client.getPhone() + " :\n");

        // Read and append the content of the client's file to the result
        try (BufferedReader reader = new BufferedReader(new FileReader(fichierClient))) {
            String ligne;
            while ((ligne = reader.readLine()) != null) {
                result.append(ligne).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result.toString();
    }
}