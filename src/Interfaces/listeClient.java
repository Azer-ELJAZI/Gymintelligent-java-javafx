/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import Models.Client;


/**
 *
 * @author ASUS
 */
class listeClient {
    private List<Client> listeClient;
    
             public void ajouterclient(Client client) {
        if (this.listeClient == null) {
            this.listeClient = new ArrayList<>();
        }
        this.listeClient.add(client);
    }
            public String afficherclients() {
    StringBuilder result = new StringBuilder();

    if (this.listeClient != null && !this.listeClient.isEmpty()) {
        result.append("Liste des clients:\n");
        for (Client client : this.listeClient) {
            result.append(afficherClient(client)).append("\n");
        }
    } else {
        result.append("La liste des clients est vide.");
    }

    return result.toString();
}

// Assuming you have an afficherClient method defined in your class as mentioned in the previous response
private String afficherClient(Client client) {
    StringBuilder clientDetails = new StringBuilder();
    clientDetails.append("Coordonnées du client :\n")
                 .append("Nom : ").append(client.getNom()).append("\n")
                 .append("Prénom : ").append(client.getPrenom()).append("\n")
                 .append("Âge : ").append(client.getAge()).append("\n")
                 .append("Poids : ").append(client.getPoids()).append("\n")
                 .append("Longueur : ").append(client.getLongueur()).append("\n")
                 .append("Sexe : ").append(client.getSexe()).append("\n")
               
                 .append("Numéro de téléphone : ").append(client.getPhone()).append("\n")
                 .append("Adresse e-mail : ").append(client.getAdresseMail()).append("\n");

    // Add IMC and Conseil if available
    if (client.getImc() != 0.0) {
        clientDetails.append("IMC : ").append(client.getImc()).append("\n")
                     //.append("Conseil : ").append(client.getConseil()).append("\n")
                ;
    }

    return clientDetails.toString();
}

    public void supprimerClientByPhone(int phone) {
    if (this.listeClient != null && !this.listeClient.isEmpty()) {
        // Iterate over the list to find the client with the specified phone number
        Client clientToRemove = null;
        for (Client client : this.listeClient) {
            if (client.getPhone() == phone) {
                clientToRemove = client;
                break;
            }
        }

        // Remove the client if found
        if (clientToRemove != null) {
            this.listeClient.remove(clientToRemove);
            System.out.println("Client supprimé : " + clientToRemove);
        } else {
            System.out.println("Aucun client trouvé avec le numéro de téléphone : " + phone);
        }
    } else {
        System.out.println("La liste des clients est vide. Impossible de supprimer le client.");
    }
}
    public String afficherConseilByPhone(int phone) {
    StringBuilder result = new StringBuilder();

    if (this.listeClient != null) {
        for (Client client : this.listeClient) {
            if (client.getPhone() == phone) {
                result.append("Conseil du client (Numéro de téléphone ").append(phone)
                        .append(") : ").append(client.getConseil());
                return result.toString(); // Return the result as a String
            }
        }
        result.append("Aucun client trouvé avec le numéro de téléphone spécifié.");
    } else {
        result.append("La liste des clients est vide. Impossible d'afficher le conseil.");
    }

    return result.toString(); // Return the result as a String
}

    
    public Client getClientByPhone(int phone) {
    if (this.listeClient != null) {
        for (Client client : this.listeClient) {
            if (client.getPhone() == phone) {
                return client;
            }
        }
        System.out.println("Aucun client trouvé avec le numéro de téléphone spécifié.");
    } else {
        System.out.println("La liste des clients est vide. Impossible de récupérer le client.");
    }

    return null; // Return null if no client is found
}

    public Client retournecopiedeclient(int phone) {
    if (this.listeClient != null) {
        for (Client client : this.listeClient) {
            if (client.getPhone() == phone) {
                // Crée une copie du client
                Client clientCopie = new Client();
                clientCopie.setNom(client.getNom());
                clientCopie.setPrenom(client.getPrenom());
                clientCopie.setAge(client.getAge());
                clientCopie.setPoids(client.getPoids());
                clientCopie.setLongueur(client.getLongueur());
                clientCopie.setSexe(client.getSexe());
                clientCopie.setPhone(client.getPhone());
                clientCopie.setAdresseMail(client.getAdresseMail());
                clientCopie.setImc(client.getImc());
                // Note : Vous devrez peut-être également copier d'autres propriétés en fonction de votre implémentation

                return clientCopie;
            }
        }
        System.out.println("Aucun client trouvé avec le numéro de téléphone spécifié.");
    } else {
        System.out.println("La liste des clients est vide. Impossible de retourner la copie du client.");
    }

    return null; // Retourne null si aucun client n'est trouvé
}

    public String afficherDetailsClientByPhone(int phone) {
    StringBuilder result = new StringBuilder();

    if (this.listeClient != null) {
        for (Client client : this.listeClient) {
            if (client.getPhone() == phone) {
                result.append("Détails du client (Numéro de téléphone ").append(phone).append("):\n")
                        .append("Nom : ").append(client.getNom()).append("\n")
                        .append("Prénom : ").append(client.getPrenom()).append("\n")
                        .append("Âge : ").append(client.getAge()).append("\n")
                        .append("Poids : ").append(client.getPoids()).append("\n")
                        .append("Longueur : ").append(client.getLongueur()).append("\n")
                        .append("Sexe : ").append(client.getSexe()).append("\n")
                        .append("Numéro de téléphone : ").append(client.getPhone()).append("\n")
                        .append("Adresse e-mail : ").append(client.getAdresseMail()).append("\n")
                        .append("IMC : ").append(client.getImc()).append("\n")
                        .append("Conseil : ").append(client.getConseil()).append("\n");

                return result.toString(); // Return the result as a String
            }
        }
        result.append("Aucun client trouvé avec le numéro de téléphone spécifié.");
    } else {
        result.append("La liste des clients est vide. Impossible d'afficher les détails du client.");
    }

    return result.toString(); // Return the result as a String
}
 public String afficherFichierPrepare(int Phone) {
        StringBuilder result = new StringBuilder();

        try {
            // Specify the directory path where the file is located
            String directoryPath = "C:\\Users\\ASUS\\Documents\\NetBeansProjects\\JavaFXApplication13\\Client";

            // Create the file with the full path
            File fichierCoach = new File(directoryPath, Phone + ".txt");

            // Check if the coach's file exists
            if (!fichierCoach.exists()) {
                return "Le fichier du coach " + Phone + " n'existe pas.";
            }

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

