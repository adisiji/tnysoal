package nb.scode.tanyasoal.models;

/**
 * Created by User on 12/27/2016.
 */

public class AtmCard {
    private String name;
    private int img;

    public AtmCard(String name, int img){
        this.name = name;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public int getImg() {
        return img;
    }
}
