/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.util.Map;

/**
 *
 * @author ASUS
 */
public final class ProgramesEntrainement {
    private Map<Double ,ProgrameEntrainement> ProgramesEntrainementMap ;

    public ProgramesEntrainement()  {
    }
   
    
    public void callProgrames(ProgramesEntrainement pe) {
        ProgrameEntrainement PE1 = new ProgrameEntrainement("Programme 1 : Entraînement cardiovasculaire de 30 minutes, suivi de 15 minutes de musculation légère.");
        ProgrameEntrainement PE2 = new ProgrameEntrainement("Programme 2 : Circuit d'entraînement HIIT intense pendant 20 minutes, suivi de 10 minutes de stretching.");
        ProgrameEntrainement PE3 = new ProgrameEntrainement("Programme 3 : Entraînement en force axé sur les poids libres pendant 45 minutes.");
        ProgrameEntrainement PE4 = new ProgrameEntrainement("Programme 4 : Yoga et méditation pour la relaxation, d'une durée de 30 minutes.");
        ProgrameEntrainement PE5 = new ProgrameEntrainement("Programme 5 : Course à pied en plein air pendant 45 minutes, avec des intervalles de sprint.");
        ProgrameEntrainement PE6 = new ProgrameEntrainement("Programme 6 : Entraînement complet du corps avec des exercices polyvalents, d'une durée de 1 heure.");

        pe.ajouterProgrameEntrainement(19.0, PE1);
        pe.ajouterProgrameEntrainement(20.0, PE2);
        pe.ajouterProgrameEntrainement(21.5, PE3);
        pe.ajouterProgrameEntrainement(22.0, PE4);
        pe.ajouterProgrameEntrainement(23.5, PE5);
        pe.ajouterProgrameEntrainement(25.0, PE6);
        pe.ajouterProgrameEntrainement(19.0, PE1);
    }


    public ProgramesEntrainement(Map<Double, ProgrameEntrainement> ProgramesEntrainementMap) {
        this.ProgramesEntrainementMap = ProgramesEntrainementMap;
    }

    public Map<Double, ProgrameEntrainement> getRegimesMap() {
        return ProgramesEntrainementMap;
    }

    public void setProgramesEntrainementMap(Map<Double, ProgrameEntrainement> ProgramesEntrainementMap) {
        this.ProgramesEntrainementMap = ProgramesEntrainementMap;
    }
 public void ajouterProgrameEntrainement(Double imc,ProgrameEntrainement ProgrameEntrainement) { 
  ProgramesEntrainementMap. put(imc, ProgrameEntrainement) ;
 } 
 public void affivoidcherProgrameEntrainement(double imc){
     System.out.println("le ProgrameEntrainement correspondant de l imc " +imc+"est-->");
     System.out.println(ProgramesEntrainementMap.get(imc));
 }
    public void affivoidcherProgramesEntrainementMap(){
                 System.out.println("-------------------------------------------------------------------------------");

        System.out.println("Affichage de notres ProgramesEntrainementMap  :");
                 System.out.println("-------------------------------------------------------------------------------");

        for (Map.Entry<Double, ProgrameEntrainement> entry : ProgramesEntrainementMap.entrySet()) {
            System.out.println("IMC : " + entry.getKey() + ", -->: " + entry.getValue());
        }
  }
    public String afficherProgrammes() {
        StringBuilder result = new StringBuilder();
        result.append("-------------------------------------------------------------------------------\n");
        result.append("Affichage de nos Programmes d'Entraînement :\n");
        result.append("-------------------------------------------------------------------------------\n");

        for (Map.Entry<Double, ProgrameEntrainement> entry : ProgramesEntrainementMap.entrySet()) {
            result.append("IMC : ").append(entry.getKey()).append(", Programme : ").append(entry.getValue()).append("\n");
        }

        return result.toString();
    }
    public void supprimerProgrameParIMC(Double imc) {
        ProgramesEntrainementMap.remove(imc);
    }
    
    
       public String chercherPrograme(Double imc) {
        ProgrameEntrainement programe = ProgramesEntrainementMap.get(imc);
        if (programe != null) {
            return "Le programme correspondant de l'IMC " + imc + " est -->\n" + programe;
        } else {
            return "Aucun programme trouvé pour l'IMC " + imc;
        }
    }
       

}

