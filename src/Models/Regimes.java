/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.util.Map;


public final class Regimes {
   private Map<Double ,Regime > RegimesMap ;

    public Regimes() {
    }
   

    public Regimes(Map<Double, Regime> RegimesMap) {
        this.RegimesMap = RegimesMap;
    }

    public Map<Double, Regime> getRegimesMap() {
        return RegimesMap;
    }

    public void setRegimesMap(Map<Double, Regime> RegimesMap) {
        this.RegimesMap = RegimesMap;
    }
 public void ajouterRegime(Double imc,Regime regime) { 
  RegimesMap. put(imc, regime) ;
 } 
  public void callRegimeDEPrograme(Regimes r){
    Regime R1 = new Regime("Vous êtes considéré comme ayant un poids normal. "
         + "Maintenez une alimentation équilibrée, riche en fruits, légumes, protéines maigres et grains entiers."+"\n"+" Assurez-vous de rester actif physiquement.") ;
         Regime R2 = new Regime(" Toujours dans la plage de poids normal. Continuez à favoriser une alimentation équilibrée avec une variété de nutriments."
           + "\n"+" Considérez vos besoins individuels en fonction de votre niveau d'activité et de votre métabolisme.");
        Regime R3 = new Regime("Vous êtes toujours dans la plage de poids normal.Le maintien d'une alimentation saine et d'un mode de vie actif est essentiel.Regime 3");
        Regime R4 = new Regime("Bien que toujours dans la plage de poids normal, il peut être utile de surveiller votre alimentation et de maintenir un mode de vie actif pour éviter une prise de poids non souhaitée.");
        Regime R5 = new Regime("Regime 5");
        Regime R6 = new Regime("Petit-déjeuner :portion de flocons d'avoine avec des fruits frais  +Collation du matin :  Une poignée de noix ou d'amandes. Déjeuner :" +
"- Salade mixte avec des légumes variés et une vinaigrette légère à base d'huile d'olive.");
        r.ajouterRegime(19.0, R1);
        r.ajouterRegime(20.0, R2);
        r.ajouterRegime(21.5, R3);
        r.ajouterRegime(22.0, R4);
        r.ajouterRegime(23.5, R5);
        r.ajouterRegime(25.0, R6);
        r.ajouterRegime(19.0, R1);
    }
 public String chercherRegime(double imc) {
    StringBuilder result = new StringBuilder();
    result.append("Le régime correspondant de l'IMC ").append(imc).append(" est -->\n");
    result.append(RegimesMap.get(imc)).append("\n");
    return result.toString();
}

public String afficherRegimes() {
    StringBuilder result = new StringBuilder();
    result.append("---------------------------------------------------------------------------------------\n");
    result.append("Affichage de nos Régimes :\n");
    result.append("----------------------------------------------------------------------------------------\n");

    for (Map.Entry<Double, Regime> entry : RegimesMap.entrySet()) {
        result.append("IMC : ").append(entry.getKey()).append(", -->: ").append(entry.getValue()).append("\n");
    }

    return result.toString();
}
public void supprimerRegimeParIMC(double imc) {
    // Utilisation de la méthode remove pour supprimer l'entrée associée à l'IMC spécifié
    RegimesMap.remove(imc);
}
}
