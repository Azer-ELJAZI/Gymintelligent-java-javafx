/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;
import java.util.Scanner ;
import java.util.*;
public abstract sealed class User permits Client {
    private int Age  ;
    private String nom  ;
    private String Prenom ;
    private int  Phone ;
    private Poste poste; 
    public User() {
        Scanner scanner = new Scanner(System.in);
                  System.out.println("Saisir de cordonnee du user ");


        System.out.print("Nom : ");
        this.nom = scanner.nextLine();

        System.out.print("Prénom : ");
        this.Prenom = scanner.nextLine();

        System.out.print("Âge : ");
        this.Age = scanner.nextInt();
        scanner.nextLine(); // Pour consommer la nouvelle ligne restante après nextInt()

        System.out.print("Numéro de téléphone : ");
        this.Phone = scanner.nextInt();
        scanner.nextLine(); // Pour consommer la nouvelle ligne restante après nextInt()

        System.out.print("Poste : ");
        this.poste = Poste.valueOf(scanner.nextLine());

        System.out.print("Adresse e-mail : ");
        this.AdresseMail = scanner.nextLine();
    }


    public User(int Age, String nom, String Prenom, int Phone, Poste poste, String AdresseMail) {
        this.Age = Age;
        this.nom = nom;
        this.Prenom = Prenom;
        this.Phone = Phone;
        this.poste = poste;
        this.AdresseMail = AdresseMail;
    }

    public User(int Age, String nom, String Prenom, int Phone, String AdresseMail) {
        this.Age = Age;
        this.nom = nom;
        this.Prenom = Prenom;
        this.Phone = Phone;
        this.AdresseMail = AdresseMail;
    }
    private String AdresseMail ;

    public int getAge() {
        return Age;
    }

    public void setAge(int Age) {
        this.Age = Age;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom(String Prenom) {
        this.Prenom = Prenom;
    }

    public int getPhone() {
        return Phone;
    }

    public void setPhone(int Phone) {
        this.Phone = Phone;
    }

    public String getAdresseMail() {
        return AdresseMail;
    }

    public void setAdresseMail(String AdresseMail) {
        this.AdresseMail = AdresseMail;
    }
    
}
