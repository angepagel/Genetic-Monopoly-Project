package monopoly.modele;

import java.util.Random;

public class Des {
    private int de1;
    private int de2;
    private Random random;

    public Des() {
        random = new Random();
    }

    public int lancer() {
        de1 = random.nextInt(5) + 1;
        de2 = random.nextInt(5) + 1;
        return sommeDes();
    }

    public int valDe1() {
        return de1;
    }

    public int valDe2() {
        return de2;
    }

    public int sommeDes() {
        return  de1 + de2;
    }

    public boolean estDouble() {
        return (de1 == de2);
    }
}
