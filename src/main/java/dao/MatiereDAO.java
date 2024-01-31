package dao;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Matiere;

import java.io.BufferedReader;
import java.io.FileReader;

public class MatiereDAO {
    public static ObservableList<Matiere> getAll(String path) {
        ObservableList<Matiere> listMatieres = FXCollections.observableArrayList();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            boolean headerSkipped = false; // Pour sauter l'en-tête

            while ((line = br.readLine()) != null) {
                if (!headerSkipped) {
                    headerSkipped = true;
                    continue; // Ignorer l'en-tête
                }

                String[] parts = line.split(","); // À adapter selon le délimiteur utilisé dans votre fichier CSV

                String code = parts[0].trim();
                String nom = parts[1].trim();
                int quantite = "NA".equals(parts[2].trim()) ? 0 : Integer.parseInt(parts[2].trim());
                String unite = parts[3].trim();
                double achat = "NA".equals(parts[4].trim()) ? 0.0 : Double.parseDouble(parts[4].trim());
                double vente = "NA".equals(parts[5].trim()) ? 0.0 : Double.parseDouble(parts[5].trim());

                listMatieres.add(new Matiere(code, nom, quantite, unite, achat, vente));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listMatieres;
    }
}
