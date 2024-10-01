/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */

    public  sealed class Employe  implements Salarie  permits Coach,Medcin {
        int matricule ;
        String  nom ;
        int nb_H ;
        double prixH ;
        
        public Employe() {
        System.out.println("Saisir de cordonnee du Employe ");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Matricule : ");
        this.matricule = scanner.nextInt();
        scanner.nextLine(); // Pour consommer la nouvelle ligne restante après nextInt()

        System.out.print("Nom : ");
        this.nom = scanner.nextLine();

        System.out.print("Nombre d'heures : ");
        this.nb_H = scanner.nextInt();
        scanner.nextLine(); // Pour consommer la nouvelle ligne restante après nextInt()

        System.out.print("Prix par heure : ");
        this.prixH = scanner.nextDouble();
        scanner.nextLine(); // Pour consommer la nouvelle ligne restante après nextDouble()
    }

    public Employe(int matricule, String nom) {
        this.matricule = matricule;
        this.nom = nom;
    }

    public Employe(int matricule, double prixH, String nom, int nb_H) {
        this.matricule = matricule;
        this.nom = nom;
        this.nb_H = nb_H;
        this.prixH = prixH;
    }
  
    public int getMatricule() {
        return matricule;
    }

    public void setMatricule(int matricule) {
        this.matricule = matricule;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNb_H() {
        return nb_H;
    }

    public void setNb_H(int nb_H) {
        this.nb_H = nb_H;
    }

    public double getPrixH() {
        return prixH;
    }

    public void setPrixH(double prixH) {
        this.prixH = prixH;
    }

    @Override
    public String toString() {
        return "Employe{" + "matricule=" + matricule + ", nom=" + nom + ", nb_H=" + nb_H + ", prixH=" + prixH + '}';
    }
    @Override
     public double calculerPaye(){
         return nb_H*prixH ;
     }
    public void afficherDetailsEmployes(Employes e){
        e.afficherDetailsEmployes();
    }
    
    public String afficherFichierPourEmployer() {
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


