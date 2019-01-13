package monopoly.modele;

import monopoly.modele.cartes.*;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Gestionnaire des cartes.
 */
public class GestionnaireCartes {
    /**
     * Liste des cartes chance.
     */
    private ArrayList<Carte> chance;

    /**
     * Liste des cartes caisse de communauté.
     */
    private ArrayList<Carte> caisse;

    public GestionnaireCartes() {
        initialisation();
    }

    public void initialisation() {
        chance = new ArrayList<>();
        caisse = new ArrayList<>();

        // Initialisation des cartes chance.
        chance.add(new Carte_AvancerVers("Gare de Lyon"));
        chance.add(new Carte_Gagner(100, "Vous avez gagné le prix de mots croisés.\nRecevez 100€."));
        chance.add(new Carte_AllerPrison());
        chance.add(new Carte_Payer(20, "Amende pour ivresse.\n20€."));
        chance.add(new Carte_SortiePrison_Chance());
        chance.add(new Carte_ReculerCases(3));
        chance.add(new Carte_AvancerVers("Boulevard de la Villette"));
        chance.add(new Carte_PayerMaisons(40,115,"Vous êtes imposé pour les réparations de voirie à raison de :\n40€ par maison et 115€ par hôtel."));
        chance.add(new Carte_Gagner(150, "Votre immeuble et votre prêt rapportent.\nVous devez toucher 150€."));
        chance.add(new Carte_AvancerVers("Avenue Henri-Martin"));
        chance.add(new Carte_Payer(15, "Amende pour excès de vitesse.\n15€."));
        chance.add(new Carte_PayerMaisons(25, 100, "Faites des réparations dans toutes vos maisons.\nVersez pour chaquqe maison 25€.\nVersez pour chaque hôtel 100€."));
        chance.add(new Carte_Gagner(50, "La banque vous verse un dividende de 50€."));
        chance.add(new Carte_AvancerVers("Rue de la Paix", "Rendez-vous à la Rue de la Paix."));
        chance.add(new Carte_Payer(150, "Payez pour frais de scolarité 150€."));
        chance.add(new Carte_AvancerVers("Départ", "Avancez jusqu'à la case \"Départ\"."));

        // Initialisation des cartes caisse de communauté.
        caisse.add(new Carte_Payer(50, "Payez la note du médecin\n50€."));
        caisse.add(new Carte_Anniversaire(10));
        caisse.add(new Carte_Payer(100, "Payez à l'hôpital\n100€."));
        caisse.add(new Carte_AvancerVers("Départ","Placez-vous sur la case \"Départ\"."));
        caisse.add(new Carte_Gagner(200, "Erreur de la banque en votre faveur.\nRecevez 200€."));
        caisse.add(new Carte_SortiePrison_Caisse());
        caisse.add(new Carte_AmendeOuChance(10));
        caisse.add(new Carte_Gagner(50, "La vente de votre stock vous rapporte 50€."));
        caisse.add(new Carte_AllerPrison());
        caisse.add(new Carte_Gagner(100, "Vous héritez de 100€."));
        caisse.add(new Carte_Gagner(100, "Vous reçevez votre revenu annuel\n100€."));
        caisse.add(new Carte_Gagner(20, "Les contributions vous remboursent la somme de 20€."));
        caisse.add(new Carte_Gagner(25, "Recevez votre intérêt sur l'emprunt à 7%.\n25€."));
        caisse.add(new Carte_Payer(50, "Payez votre police d'assurance s'élevant à 50€."));
        caisse.add(new Carte_Gagner(10, "Vous avez gagné le deuxième Prix de Beauté.\nRecevez 10€."));

        // On mélange les cartes
        Collections.shuffle(chance);
        Collections.shuffle(caisse);
    }

    /**
     * Permet de piocher une carte chance.
     * @return La carte piochée.
     */
    public Carte piocherChance() {
        Carte pioche = chance.get(0);
        chance.remove(0);

        return pioche;
    }

    /**
     * Permet de piocher une carte caisse de communauté.
     * @return La carte piochée.
     */
    public Carte piocherCaisseCommunaute() {
        Carte pioche = caisse.get(0);
        caisse.remove(0);

        return pioche;
    }

    /**
     * Permet de remettre une carte chance sous le paquet.
     * @param c La carte qui doit être remise.
     */
    public void remettreChance(Carte c) {
        chance.add(c);
    }

    /**
     * Permet de remettre une carte caisse de communauté sous le paquet.
     * @param c La carte qui doit être remise.
     */
    public void remettreCaisseCommunaute(Carte c) {
        caisse.add(c);
    }

    /**
     * Un joueur pioche une carte chance et effectue l'action qu'elle indique.
     * @param j Le joueur qui effectue l'action.
     */
    public void actionChance(Joueur j) {
        Carte carte = piocherChance();
        if(!carte.affichageInclus()) {
            Jeu.getInstance().getControleurJeuMessage().afficherMessage("Chance", carte.getTexte());
        }
        carte.action(j);
        if(carte.usageImmediat()) {
            remettreChance(carte);
        }
    }

    /**
     * Un joueur pioche une carte caisse de communauté et effectue l'action indiquée.
     * @param j Le joueur qui effectue l'action.
     */
    public void actionCaisseCommunaute(Joueur j) {
        Carte carte = piocherCaisseCommunaute();
        if(!carte.affichageInclus()) {
            Jeu.getInstance().getControleurJeuMessage().afficherMessage("Caisse de communauté", carte.getTexte());
        }
        carte.action(j);
        if(carte.usageImmediat()) {
            remettreCaisseCommunaute(carte);
        }
    }
}
