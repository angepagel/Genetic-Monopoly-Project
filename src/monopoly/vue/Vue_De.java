package monopoly.vue;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import monopoly.modele.Des;

public class Vue_De extends Vue {

    private int num;
    private Des des;

    public Vue_De(Des des, int num, ImageView imgView) {
        super(imgView);
        this.des = des;
        this.num = num;
    }

    public void miseAJour() {
        Image spr_de;

        if (this.num == 1) {
            spr_de = new Image("file:src/monopoly/vue/data/image/dice_"+this.des.valDe1()+".png", true);
        }
        else {
            spr_de = new Image("file:src/monopoly/vue/data/image/dice_"+this.des.valDe2()+".png", true);
        }


        this.getImageView().setImage(spr_de);
    }

}
