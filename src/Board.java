
import java.util.ArrayList;


class Board {
    private boolean hasShip;
    private boolean isHit;
    private String symbol;

    public Board(String symbol) {
        this.symbol = symbol;
    }

    public boolean hasShip() {
        return hasShip;
    }

    public void setShip(boolean hasShip) {
        this.hasShip = hasShip;
    }

    public boolean isHit() {
        return isHit;
    }

    public void setHit(boolean hit) {
        isHit = hit;
    }

    public String getSymbol() {
        if (isHit) {
            if (hasShip) {
                return "hit";
            } else {
                return "miss";
            }
        } else {
            return symbol;
        }
    }

    public void setSymbol(String newSymbol) {
        this.symbol = newSymbol;
    }
}


