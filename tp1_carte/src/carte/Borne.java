package carte;

public class Borne extends Carte {

    private int km;

    // Le constructeur doit être public pour créer des objets à l'extérieur
    public Borne(int km) {
        this.km = km;
    }

    // Getter pour obtenir la distance en kilomètres
    public int getKm() {
        return km;
    }

    // Setter pour modifier la distance en kilomètres (si nécessaire)
    public void setKm(int km) {
        this.km = km;
    }

    // Méthode toString pour retourner la distance sous forme de chaîne de caractères
    @Override
    public String toString() {
        return km + "KM";
    }
}
