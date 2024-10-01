package Models;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static Models.Poste.CLIENT;

public final class Admin {
   

     public static void main(String[]args){
         
          try{
            
           Map<Double, Regime> mapExemple = new HashMap<>();
           Map<Double, ProgrameEntrainement> mapExemple2 = new HashMap<>();
           Regimes r=new Regimes(mapExemple) ;
           ProgramesEntrainement p=new ProgramesEntrainement(mapExemple2) ;
        // Client c1 =new Client(CLIENT,40.2,183,'M',22,"azer","jazi",26849579,"zdzf") ;
         // Client c2 =new Client(CLIENT,400.2,183,'M',22,"ali","namli",25549579,"ali@gmail.com") ;
         //System.out.println(c1.getImc());
        // c1.choisirCoach(7);
        // c2.choisirCoach(14);
         
             
         //c1.afficherFichierCoach(14);
        // System.out.println("-------------------------------------------------------------------------------");
        // System.out.println(c1);
        /*
        
         


         
       
        //System.out.println("-------------------------------------------------------------------------------");
        // r.affivoidcherRegime(c1.getImc());
        // System.out.println("-------------------------------------------------------------------------------");

         //r.affivoidcherRegime(22.0);
         //System.out.println("-------------------------------------------------------------------------------");
*/
/*
         r.affivoidcherRegimes();
        ProgrameEntrainement p1=new ProgrameEntrainement("selon votre imc faire la muscilation 4 fois par semaine  avec cardio") ;
        p.ajouterProgrameEntrainement(20.0, p1);
        p.affivoidcherProgrameEntrainement(20);
        p.affivoidcherProgrameEntrainement(c1.getImc());
         Employes employes = new Employes();

        Coach coach1 = new Coach(40, 9, 1,"John Doe", 5);
        Coach coach2 = new Coach(35,7,5.0, "Jane Smith", 7);

        Medcin medcin1 = new Medcin(40,8,30, "Dr. James Brown", 2);
        Medcin medcin2 = new Medcin(30,3,5.0, "Dr. Emily White",  3);

        employes.ajouterEmploye(coach1);
        employes.ajouterEmploye(coach2);
        employes.ajouterEmploye(medcin1);
        employes.ajouterEmploye(medcin2);
         employes.afficherDetailsEmployes();
        double salaireTotal = employes.calculerSalaireTotal();
        System.out.println("Le salaire total de tous les employés est : " + salaireTotal);
        employes.afficherListeNomsCoachs();
        employes.afficherListeNomsMedcins();
        employes.supprimerEmploye(8);
        employes.afficherListeNomsMatriculesCoachs();
        employes.afficherListeNomsMatriculesMedcins();
        salaireTotal = employes.calculerSalaireTotal();
        System.out.println("Le salaire total après suppression est : " + salaireTotal); 
*/
        //Coach o1 =new Coach(14,"ali") ;
         //o1.afficherFichierCoach();
        //o1.ajouterProgramme( mapExemple2);
        //p.affivoidcherProgrameEntrainement(14);
        //Medcin m1 =new Medcin(7 ,"hasen") ;
       // m1.afficherFichierMedcin();
        //o1.enregistrerProgramme(c1);
       // c1.choisirCoach(7);
        //c1.afficherFichierPrepare(26849579);
         
        Client c6 =new Client(150.2,183,'F',22,"ranime","namli",29549579,"ali@gmail.com") ;
        Medcin m5 =new  Medcin(777,2.5, "ali",20,4);
        Coach o5 =new  Coach(888,2.3,"aziz",4,2);
       
         Coach o7 = new    Coach(35,5.0, "Jane Smith", 7,4);
         
         System.out.println(c6);
         System.out.println(m5);
         System.out.println(o7);
         Employes e = new Employes();
          e.ajouterEmploye(m5);
        e.ajouterEmploye(o7);
        c6.afficherDetailsEmployes(e);
        c6.choisirEmploye();
        c6.choisirEmploye();
        m5.afficherFichierPourMedcin();
        o7.afficherFichierPourCoach();
       o7.enregistrerProgramme(c6);
       m5.enregistrerProgramme(c6);
       c6.afficherFichierPrepare(c6.getPhone());
       c6.afficherFichierPrepare(c6.getPhone());
          System.out.println("_--------------------------_") ;
          
         
     e.supprimerEmploye(777);
     e.supprimerEmploye(888);
       c6.afficherDetailsEmployes(e);
     //Tri par matchs coroissants
   
         /*
      //  Client c5 =new Client(,50.2,183,'M',22,"azer","jazi",25849579,"azer@gmail.com") ;
        Client c6 =new Client(150.2,183,'F',22,"ranime","namli",29549579,"ali@gmail.com") ;
        Medcin m5 =new  Medcin(777,2.5, "ali",20,4);
        Coach o5 =new  Coach(888,2.3,"aziz",4,2);
        
      
       
        Employes e = new Employes();
      
        e.ajouterEmploye(m5);
        e.ajouterEmploye(o5);
        c5.afficherDetailsEmployes(e);
        c5.choisirEmploye();
        c6.choisirEmploye();
        m5.afficherFichierPourMedcin();
        o5.afficherFichierPourCoach();
       o5.enregistrerProgramme(c6);
       m5.enregistrerProgramme(c5);
       c5.afficherFichierPrepare(c5.getPhone());
       c6.afficherFichierPrepare(c6.getPhone());
          System.out.println("_--------------------------_") ;
     Tri par matchs coroissants
   
   
       
    e.AfficherEmplyeeSorteeParHeuretraville(e);
    e.AfficherEmplyeeSorteeParSalaire(e);
     e.supprimerEmploye(777);
     e.supprimerEmploye(888);
       c5.afficherDetailsEmployes(e);
            
*/
        
     
     
          }
        catch(EmplyesException e){ 
        System.out.println(e.getMessage());    }
        
        }    

}



        
     

