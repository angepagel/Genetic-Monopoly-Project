package monopoly.modele;

/**
 * Classe gérant un chronomètre gérant les minutes et les secondes.
 */
public class Chronometre {

    private int secondes;
    private int minutes;

    public Chronometre() {
        this.secondes = 0;
        this.minutes = 0;
    }

    public void addSeconde() {
        this.secondes++;
        if (this.secondes == 60) {
            this.secondes = 0;
            this.addMinute();
        }
    }

    private void addMinute() {
        this.minutes++;
    }

    public int getSecondes() {
        return secondes;
    }

    public void setSecondes(int secondes) {
        this.secondes = secondes;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public String afficher() {
        String affichageSecondes = Integer.toString(this.secondes);
        if (this.secondes < 10) {
            affichageSecondes = "0"+this.secondes;
        }

        String affichageMinutes = Integer.toString(this.minutes);
        if (this.minutes < 10) {
            affichageMinutes = "0"+this.minutes;
        }

        return affichageMinutes+":"+affichageSecondes;
    }

    @Override
    public String toString() {
        return this.afficher();
    }
}
