package fr.gartox.mcdemineur;

import fr.gartox.mcdemineur.utils.SquareType;

/**
 * Created by Ewan on 07/05/2017.
 */
public class Square {

    private SquareType type;
    private boolean discover;
    private int position;

    public Square(SquareType type, int position) {
        this.setType(type);
        this.setDiscover(false);
        this.setPosition(position);
    }

    public SquareType getType() {
        return type;
    }

    public void setType(SquareType type) {
        this.type = type;
    }

    public boolean isDiscover() {
        return discover;
    }

    public void setDiscover(boolean discover) {
        this.discover = discover;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
