package monopoly.modele;

/**
 * Classe gérant un chronomètre gérant les minutes et les secondes.
 */
public class Chronometre {

    private int secondes;
    private int minutes;
    private int heures;

    public Chronometre() {
        this.secondes = 0;
        this.minutes = 0;
        this.heures = 0;
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
        if (this.minutes == 60) {
            this.minutes = 0;
            this.addHeure();
        }
    }

    private void addHeure() {
        this.heures++;
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

    public int getHeures() {
        return heures;
    }

    public void setHeures(int heures) {
        this.heures = heures;
    }

    public String afficher() {
        String res;

        String affichageSecondes = Integer.toString(this.secondes);
        if (this.secondes < 10) {
            affichageSecondes = "0"+this.secondes;
        }

        String affichageMinutes = Integer.toString(this.minutes);
        if (this.minutes < 10) {
            affichageMinutes = "0"+this.minutes;
        }

        if (this.heures == 0) {
            res = affichageMinutes+":"+affichageSecondes;
        }
        else {
            res = Integer.toString(this.heures)+":"+affichageMinutes+":"+affichageSecondes;
        }

        return res;
    }

    @Override
    public String toString() {
        return this.afficher();
    }
}
