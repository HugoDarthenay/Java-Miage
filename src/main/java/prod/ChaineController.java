package prod;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ChaineController {

    @FXML
    private TableView<Chaine> tableView;

    @FXML
    private TableColumn<Chaine, String> c1Column;

    @FXML
    private TableColumn<Chaine, String> c2Column;

    @FXML
    private TableColumn<Chaine, Map<String, Float>> c2Column1;

    @FXML
    private TableColumn<Chaine, Map<String, Float>> c2Column2;

    @FXML
    private TableColumn<Chaine, Integer> c2Column3;

    public void initialize() {
        c1Column.setCellValueFactory(new PropertyValueFactory<>("code"));
        c2Column.setCellValueFactory(new PropertyValueFactory<>("nom"));
        c2Column1.setCellValueFactory(new PropertyValueFactory<>("elementsEntree"));
        c2Column2.setCellValueFactory(new PropertyValueFactory<>("elementsSortie"));
        c2Column3.setCellValueFactory(new PropertyValueFactory<>("niveauActivite"));

        // Appel à une méthode pour charger les données depuis le fichier CSV
        loadCsvData();
    }

    private void loadCsvData() {
        String csvFile = "src/main/java/prod/chaines.csv";
        String line = "";
        String csvSeparator = ";";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] data = line.split(csvSeparator);

                // Extraire les données de chaque champ du CSV
                String code = data[0];
                String nom = data[1];
                Map<String, Float> elementsEntree = parseElements(data[2]);
                Map<String, Float> elementsSortie = parseElements(data[3]);
                Integer niveauActivite = 1; // Vous pouvez initialiser cela à partir du CSV si nécessaire

                // Créer un objet Chaine avec les données extraites et l'ajouter à la TableView
                tableView.getItems().add(new Chaine(code, nom, elementsEntree, elementsSortie, niveauActivite));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Map<String, Float> parseElements(String elementString) {
        Map<String, Float> elements = new HashMap<>();

        // Supprimer les espaces indésirables
        elementString = elementString.trim();

        // Vérifier si la chaîne est vide ou nulle
        if (elementString.isEmpty()) {
            return elements;
        }

        // Supprimer les parenthèses
        elementString = elementString.substring(1, elementString.length() - 1);

        // Diviser la chaîne en paires code-quantité
        String[] pairs = elementString.split(",");
        for (String pair : pairs) {
            // Extraire le code et la quantité de la paire
            String[] keyValue = pair.split(",");
            if (keyValue.length == 2) {
                String code = keyValue[0].trim();
                Float quantity = Float.parseFloat(keyValue[1].trim());
                elements.put(code, quantity);
            }
        }

        return elements;
    }


}
