package prod;

import java.util.HashMap;
import java.util.Map;

public class Chaine {
    private String code;
    private String nom;
    private Map<String, Float> elementsEntree;
    private Map<String, Float> elementsSortie;
    private Integer niveauActivite;

    public Chaine(String code, String nom, Map<String, Float> elementsEntree, Map<String, Float> elementsSortie, Integer niveauActivite) {
        this.code = code;
        this.nom = nom;
        this.elementsEntree = new HashMap<>(elementsEntree);
        this.elementsSortie = new HashMap<>(elementsSortie);
        this.niveauActivite = niveauActivite;
    }

    public String getCode(){
        return this.code;
    }
    public String getNom(){
        return this.nom;
    }

    public Map<String, Float> getElementsEntree() {
        return elementsEntree;
    }

    public Map<String, Float> getElementsSortie() {
        return elementsSortie;
    }

    public Integer getNiveauActivite(){
        return this.niveauActivite;
    }

    public void afficher(){
        System.out.println("Code : "+code+" Nom : "+nom+" Entrée : "+elementsEntree+" Sortie : "+elementsSortie+" Niveau de production : "+niveauActivite);
    }

    public void modifNiveauProduction(Integer nb){
        this.niveauActivite=nb;
    }

    public static void main(String[] args) {
        Map<String, Float> elementsEntree = new HashMap<>();
        elementsEntree.put("E004", 1f);
        elementsEntree.put("E002", 0.5f);
        elementsEntree.put("E003", 0.1f);

        Map<String, Float> elementsSortie = new HashMap<>();
        elementsSortie.put("E007", 4f);

        Chaine c = new Chaine("C002", "Coques", elementsEntree, elementsSortie, 1);
        c.afficher();
        c.modifNiveauProduction(3);
        c.afficher();
    }
}
