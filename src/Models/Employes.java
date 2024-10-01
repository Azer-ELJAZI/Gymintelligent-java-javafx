/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public final class Employes {
    private List<Employe> listeEmployes;

    public Employes() {
        this.listeEmployes = new LinkedList<>();
    }

    
    public void ajouterEmploye(Employe employe) throws EmplyesException {
    if (! listeEmployes.add(employe)) {
 throw new EmplyesException("Joueur déjà dans cette équipe"); } }

    public double calculerSalaireTotal() {
        double salaireTotal = 0.0;
        for (Employe employe : listeEmployes) {
            salaireTotal += employe.calculerPaye();
        }
        return salaireTotal;
    }
    public void supprimerEmploye(int matricule) {
        Iterator<Employe> iterator = listeEmployes.iterator();
        while (iterator.hasNext()) {
            Employe employe = iterator.next();
            if (employe.getMatricule() == matricule) {
                iterator.remove();
                System.out.println("Employé avec le matricule " + matricule + " supprimé.");
                return;
            }
        }
        System.out.println("Aucun employé trouvé avec le matricule " + matricule + ".");

    }
    public void afficherDetailsEmployes() {
        System.out.println("Détails des employés :");
        for (Employe employe : listeEmployes) {
            System.out.println("Matricule : " + employe.getMatricule());
            System.out.println("Nom : " + employe.getNom());
            System.out.println("Poste : " + (employe instanceof Coach ? "Coach" : "Medcin"));
            System.out.println("Salaire : " + employe.calculerPaye());
            System.out.println("---------------------------");
        }
    }
    public void afficherListeNomsMedcins() {
        System.out.println("Liste des noms des Medcins :");
        for (Employe employe : listeEmployes) {
            if (employe instanceof Medcin) {
                System.out.println(employe.getNom());
            }
        }
    }
     public void afficherListeNomsCoachs() {
        System.out.println("Liste des noms des Coachs :");
        for (Employe employe : listeEmployes) {
            if (employe instanceof Coach) {
                System.out.println(employe.getNom());
            }
        }
    }
     public String afficherListeNomsMatriculesMedcins() {
    StringBuilder result = new StringBuilder("Liste des noms avec matricules pour les Medcins :\n");
    for (Employe employe : listeEmployes) {
        if (employe instanceof Medcin) {
            result.append("Matricule : ").append(employe.getMatricule()).append(", Nom : ").append(employe.getNom()).append("\n");
        }
    }
    return result.toString();
}

public String afficherListeNomsMatriculesCoachs() {
    StringBuilder result = new StringBuilder("Liste des noms avec matricules pour les Coachs :\n");
    for (Employe employe : listeEmployes) {
        if (employe instanceof Coach) {
            result.append("Matricule : ").append(employe.getMatricule()).append(", Nom : ").append(employe.getNom()).append("\n");
        }
    }
    return result.toString();
}

    public List <Employe> getEmployes(){
    return listeEmployes;}
       
    public String afficherEmployeSorteeParSalaire(Employes e) {
    Collections.sort(e.getEmployes(), (a1, a2) -> (int) (a1.calculerPaye() - a2.calculerPaye()));

    StringBuilder result = new StringBuilder();
    result.append("Salaires payés pour les employés par ordre croissant:\n");

    for (Employe t : e.getEmployes()) {
        result.append(t.getNom()).append(" a un Salaire de : ").append(t.calculerPaye()).append("\n");
    }


    return result.toString();
}

public String afficherEmployeSorteeParHeureTravaille(Employes e) {
    Collections.sort(e.getEmployes(), (j1, j2) -> (int) (j1.getNb_H() - j2.getNb_H()));

    StringBuilder result = new StringBuilder();
    result.append("Les heures travaillées par employé par ordre croissant:\n");

    e.getEmployes().forEach((joueur) ->
            result.append(joueur.getNom()).append(" travaille ").append(joueur.getNb_H()).append(" heures\n"));

    return result.toString();
}

    
    
     public String afficherEmployes() {
    StringBuilder result = new StringBuilder("Détails de tous les employés :\n");

    for (Employe employe : listeEmployes) {
        result.append("Matricule : ").append(employe.getMatricule()).append("\n");
        result.append("Nom : ").append(employe.getNom()).append("\n");
        result.append("Poste : ").append(employe instanceof Coach ? "Coach" : "Medcin").append("\n");
        result.append("Salaire : ").append(employe.calculerPaye()).append("\n");
  
    }

    return result.toString();
}
    public String afficherSalaireByMatricule(int matricule) {
    StringBuilder result = new StringBuilder();
    for (Employe employe : listeEmployes) {
        if (employe.getMatricule() == matricule) {
            result.append("Matricule : ").append(employe.getMatricule()).append("\n");
            result.append("Nom : ").append(employe.getNom()).append("\n");
            result.append("Salaire : ").append(employe.calculerPaye()).append("\n");
            return result.toString();
        }
    }
    result.append("Aucun employé trouvé avec le matricule ").append(matricule).append(".");
    return result.toString();
}

    
    public Employe chercherEmployerByMatricule(int matricule) {
    for (Employe employe : listeEmployes) {
        if (employe.getMatricule() == matricule) {
            return employe;
        }
    }
    System.out.println("Aucun employé trouvé avec le matricule " + matricule + ".");
    return null;
}
    public Coach chercherCoachByMatricule(int matricule) {
    for (Employe employe : listeEmployes) {
        if (employe instanceof Coach && employe.getMatricule() == matricule) {
            return (Coach) employe;
        }
    }
    System.out.println("Aucun coach trouvé avec le matricule " + matricule + ".");
    return null;
}


    public Medcin chercherMedcinByMatricule(int matricule) {
    for (Employe employe : listeEmployes) {
        if (employe instanceof Medcin && employe.getMatricule() == matricule) {
            return (Medcin) employe;
        }
    }
    System.out.println("Aucun Medcin trouvé avec le matricule " + matricule + ".");
    return null;
}
public String afficherEmployeSorteeParHeureTravailleplusque20() {
    // Filtrer les employés qui travaillent plus de 20 heures
    List<Employe> employesPlusDe20Heures = listeEmployes.stream()
            .filter(employe -> employe.getNb_H() > 20)
            .peek(employe -> employe.setNb_H(employe.getNb_H() + 1)) // Ajouter 1 heure de travail
            .collect(Collectors.toList());

    // Trier la liste par heure travaillée
    Collections.sort(employesPlusDe20Heures, (j1, j2) -> (int) (j1.getNb_H() - j2.getNb_H()));

    // Construire la chaîne de caractères pour l'affichage
    StringBuilder result = new StringBuilder();
    result.append("Les heures travaillées par employé (plus de 20 heures et +1 heure) par ordre croissant:\n");

    employesPlusDe20Heures.forEach(employe ->
            result.append(employe.getNom()).append(" travaille ").append(employe.getNb_H()).append(" heures\n"));

    return result.toString();
}

}
   



