package Models;

import java.io.BufferedReader;
import static java.lang.Math.round;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

public final class Client extends User {

    private double poids;
    private double longueur;
    private char sexe; // Le sexe du client ('M' pour masculin, 'F' pour féminin)
    private double imc;
    private String conseil;

    public Client() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /*public Client() {
        super(); // Appel du constructeur de la classe parente User pour saisir les coordonnées communes

        Scanner scanner = new Scanner(System.in);
          System.out.println("Saisir de cordonnee du client ");
        System.out.print("Poids : ");
        this.poids = scanner.nextDouble();
        scanner.nextLine(); // Pour consommer la nouvelle ligne restante après nextDouble()

        System.out.print("Longueur : ");
        this.longueur = scanner.nextDouble();
        scanner.nextLine(); // Pour consommer la nouvelle ligne restante après nextDouble()

        System.out.print("Sexe (M/F) : ");
        this.sexe = scanner.next().charAt(0);

        // Calcul de l'IMC et détermination du conseil
        this.imc = Math.round(poids / (longueur * 0.0001 * longueur));
        this.conseil = determinerConseil(); // Assurez-vous que la méthode determinerConseil() est définie dans votre classe
    }
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.poids) ^ (Double.doubleToLongBits(this.poids) >>> 32));
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.longueur) ^ (Double.doubleToLongBits(this.longueur) >>> 32));
        hash = 53 * hash + this.sexe;
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.imc) ^ (Double.doubleToLongBits(this.imc) >>> 32));
        hash = 53 * hash + Objects.hashCode(this.conseil);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Client other = (Client) obj;
        if (Double.doubleToLongBits(this.poids) != Double.doubleToLongBits(other.poids)) {
            return false;
        }
        if (Double.doubleToLongBits(this.longueur) != Double.doubleToLongBits(other.longueur)) {
            return false;
        }
        if (this.sexe != other.sexe) {
            return false;
        }
        if (Double.doubleToLongBits(this.imc) != Double.doubleToLongBits(other.imc)) {
            return false;
        }
        return Objects.equals(this.conseil, other.conseil);
    }

    public Client(double poids, double longueur, char sexe, int Age, String nom, String Prenom, int Phone, String AdresseMail) {
        super(Age, nom, Prenom, Phone, AdresseMail);

        this.poids = poids;
        this.longueur = longueur;
        this.sexe = sexe;
        this.imc = round(poids / (longueur * 0.0001 * longueur));

        this.conseil = determinerConseil();
    }

    public void choisirEmploye() {
        Scanner scanner = new Scanner(System.in);

        // Ask the user to enter the matricule of the employee
        System.out.println("Veuillez entrer le matricule de l'employé que vous souhaitez choisir : ");
        int matricule = scanner.nextInt();

        try {
            // Specify the directory path where you want to store the file
            String directoryPath = "C:\\Users\\ASUS\\Documents\\NetBeansProjects\\JavaFXApplication13\\Emplyer";

            // Create the directory if it doesn't exist
            File directory = new File(directoryPath);
            if (!directory.exists()) {
                directory.mkdirs();  // Create all necessary directories
            }

            // Create the file in the specified directory
            File fichierCoach = new File(directory, matricule + ".txt");

            // Check if the coach's file exists
            if (!fichierCoach.exists()) {
                fichierCoach.createNewFile();
            }

            // Add client details to the coach's file
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fichierCoach, true))) {
                writer.write("Détails du client :\n");
                writer.write("Nom : " + getNom() + "\n");
                writer.write("Prénom : " + getPrenom() + "\n");
                writer.write("Age : " + getAge() + "\n");
                writer.write("Poids : " + getPoids() + "\n");
                writer.write("Longueur : " + getLongueur() + "\n");
                writer.write("Sexe : " + getSexe() + "\n");
                writer.write("IMC : " + getImc() + "\n");
                writer.write("Conseil : " + getConseil() + "\n");
                writer.write("---------------------------\n");
            }

            System.out.println("Les détails du client ont été ajoutés au fichier du coach : " + matricule + ".txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void choisirEmploye2(int matricule) {
        try {
            // Specify the directory path where you want to store the file
            String directoryPath = "C:\\Users\\ASUS\\Documents\\NetBeansProjects\\JavaFXApplication13\\Emplyer";

            // Create the directory if it doesn't exist
            File directory = new File(directoryPath);
            if (!directory.exists()) {
                directory.mkdirs();  // Create all necessary directories
            }

            // Create the file in the specified directory
            File fichierCoach = new File(directory, matricule + ".txt");

            // Check if the coach's file exists
            if (!fichierCoach.exists()) {
                fichierCoach.createNewFile();
            }

            // Add client details to the coach's file
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fichierCoach, true))) {
                if (fichierCoach.length() > 0) {
                    // File is not empty, add a separator
                    writer.write("\n********************************************************************\n");
                }

                writer.write("Détails du client :\n");
                writer.write("Nom : " + getNom() + "\n");
                writer.write("Prénom : " + getPrenom() + "\n");
                writer.write("Age : " + getAge() + "\n");
                writer.write("Poids : " + getPoids() + "\n");
                writer.write("Longueur : " + getLongueur() + "\n");
                writer.write("Sexe : " + getSexe() + "\n");
                writer.write("IMC : " + getImc() + "\n");
                writer.write("Conseil : " + getConseil() + "\n");
                writer.write("phone:" + getPhone() + "\n");
            }

            System.out.println("Les détails du client ont été ajoutés au fichier du coach : " + matricule + ".txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void afficherFichierPrepare(int Phone) {
        try {
            // Specify the directory path where the file is located
            String directoryPath = "C:\\Users\\ASUS\\Documents\\NetBeansProjects\\JavaFXApplication13\\Client";

            // Create the file with the full path
            File fichierCoach = new File(directoryPath, Phone + ".txt");

            // Check if the coach's file exists
            if (!fichierCoach.exists()) {
                System.out.println("Le fichier du coach " + Phone + " n'existe pas.");
                return;
            }

            // Read and display the content of the coach's file
            try (BufferedReader reader = new BufferedReader(new FileReader(fichierCoach))) {
                String ligne;
                while ((ligne = reader.readLine()) != null) {
                    System.out.println(ligne);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public double getPoids() {
        return this.poids;
    }

    public double getLongueur() {
        return this.longueur;
    }

    public char getSexe() {
        return this.sexe;
    }

    public double getImc() {
        return this.imc;
    }

    public String getConseil() {
        return this.conseil;
    }

    public void setPoids(double poids) {
        this.poids = poids;
    }

    public void setLongueur(double longueur) {
        this.longueur = longueur;
    }

    public void setSexe(char sexe) {
        this.sexe = sexe;
    }

    public void setImc(double imc) {
        this.imc = imc;
    }

    public void setConseil(String conseil) {
        this.conseil = conseil;
    }

    @Override
    public String toString() {
        return "ce client admet un imc " + imc + "\n" + "no donne les cosail suivant " + determinerConseil();
    }

    public String determinerConseil() {

        String conseil = "";

        double seuilMin;
        double seuilMax;

        if (this.sexe == 'M') {
            seuilMin = 20;
            seuilMax = 25;
        } else if (this.sexe == 'F') {
            seuilMin = 19;
            seuilMax = 24;
        } else {
            seuilMin = 0;
            seuilMax = 0;
        }

        if (this.imc < seuilMin) {

            double kgAGagner = seuilMin * (this.longueur * 0.0001 * this.longueur) - this.getPoids();

            kgAGagner = Math.round(kgAGagner * 1);

            conseil = "Vous devez gagner du poids. Vous devriez prendre " + kgAGagner + " kg pour avoir un IMC de " + seuilMin + ".";

            conseil += "\nVoici un programme d'entraînement pour gagner du poids :\n";
            conseil += "- Faites de la musculation au moins 3 fois par semaine, en travaillant tous les groupes musculaires.\n";
            conseil += "- Augmentez progressivement l'intensité et la durée de vos séances.\n";
            conseil += "- Reposez-vous suffisamment entre les séances pour favoriser la récupération musculaire.\n";
            conseil += "- Consommez plus de calories que vous n'en dépensez, en privilégiant les aliments riches en protéines, en glucides et en lipides de bonne qualité.\n";
            conseil += "- Buvez beaucoup d'eau pour rester hydraté.\n";
        } // Sinon, si l'IMC du client est supérieur au seuil maximum, il doit perdre du poids
        else if (this.imc > seuilMax) {
            // Calculer le nombre de kilos à perdre pour atteindre le seuil maximum
            double kgAPerdre = this.poids - seuilMax * (this.longueur * 0.0001 * this.longueur);
            // Arrondir le nombre de kilos à deux décimales
            kgAPerdre = Math.round(kgAPerdre * 1);
            // Construire le conseil avec le nombre de kilos à perdre
            conseil = "Vous devez perdre du poids. Vous devriez perdre " + kgAPerdre + " kg pour avoir un IMC de " + seuilMax + ".";
            // Ajouter un programme d'entraînement pour perdre du poids
            conseil += "\nVoici un programme d'entraînement pour perdre du poids :\n";
            conseil += "- Faites du cardio au moins 3 fois par semaine, en choisissant une activité qui vous plaît (course, vélo, natation, etc.).\n";
            conseil += "- Augmentez progressivement l'intensité et la durée de vos séances.\n";
            conseil += "- Faites de la musculation au moins 2 fois par semaine, en travaillant tous les groupes musculaires.\n";
            conseil += "- Consommez moins de calories que vous n'en dépensez, en privilégiant les aliments riches en protéines, en fibres et en lipides de bonne qualité.\n";
            conseil += "- Évitez les aliments transformés, sucrés ou gras.\n";
            conseil += "- Buvez beaucoup d'eau pour rester hydraté et éliminer les toxines.\n";
        } // Sinon, l'IMC du client est dans la norme, il doit maintenir son poids
        else {
            // Construire le conseil avec le félicitation
            conseil = "Félicitations, vous avez un IMC normal. Vous devez maintenir votre poids.";
            // Ajouter un programme d'entraînement pour maintenir son poids
            conseil += "\nVoici un programme d'entraînement pour maintenir votre poids :\n";
            conseil += "- Faites du cardio au moins 2 fois par semaine, en choisissant une activité qui vous plaît (course, vélo, natation, etc.).\n";
            conseil += "- Faites de la musculation au moins 2 fois par semaine, en travaillant tous les groupes musculaires.\n";
            conseil += "- Variez vos séances pour éviter la routine et la stagnation.\n";
            conseil += "- Consommez autant de calories que vous en dépensez, en privilégiant les aliments riches en protéines, en glucides et en lipides de bonne qualité.\n";
        }
        return conseil;

    }

    public void afficherDetailsEmployes(Employes e) {
        e.afficherDetailsEmployes();

    }

    public void saisirCoordonneesClient() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Saisir les coordonnées du client :");

        // Saisie des informations
        System.out.print("Nom : ");
        String nom = scanner.nextLine();

        System.out.print("Prénom : ");
        String prenom = scanner.nextLine();

        System.out.print("Âge : ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Pour consommer la nouvelle ligne restante après nextInt()

        System.out.print("Poids : ");
        double poids = scanner.nextDouble();
        scanner.nextLine(); // Pour consommer la nouvelle ligne restante après nextDouble()

        System.out.print("Longueur : ");
        double longueur = scanner.nextDouble();
        scanner.nextLine(); // Pour consommer la nouvelle ligne restante après nextDouble()

        System.out.print("Sexe (M/F) : ");
        char sexe = scanner.next().charAt(0);

        System.out.print("Poste : ");
        String poste = scanner.nextLine();

        System.out.print("Numéro de téléphone : ");
        int phone = scanner.nextInt();
        scanner.nextLine(); // Pour consommer la nouvelle ligne restante après nextInt()

        System.out.print("Adresse e-mail : ");
        String adresseMail = scanner.nextLine();

        // Calcul de l'IMC et détermination du conseil
        double imc = Math.round(poids / (longueur * 0.0001 * longueur));
        String conseil = determinerConseil(); // Assurez-vous que la méthode determinerConseil() est définie dans votre classe

    }

    public void afficherClient(Client client) {
        System.out.println("Coordonnées du client :");
        System.out.println("Nom : " + client.getNom());
        System.out.println("Prénom : " + client.getPrenom());
        System.out.println("Âge : " + client.getAge());
        System.out.println("Poids : " + client.getPoids());
        System.out.println("Longueur : " + client.getLongueur());
        System.out.println("Sexe : " + client.getSexe());

        System.out.println("Numéro de téléphone : " + client.getPhone());
        System.out.println("Adresse e-mail : " + client.getAdresseMail());

        // Add IMC and Conseil if available
        if (client.getImc() != 0.0) {
            System.out.println("IMC : " + client.getImc());
            System.out.println("Conseil : " + client.getConseil());
        }
    }

}
