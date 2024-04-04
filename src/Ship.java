public class Ship extends Board{

    private int startX;
    private int startY;
    private boolean horizontal;
    private boolean[] hit;

    public Ship(String symbol, int startX, int startY, boolean horizontal) {
        super("\uD83D\uDEA2");
        this.startX = startX;
        this.startY = startY;
        this.horizontal = horizontal;
        hit = new boolean[3];
    }

    public boolean isHorizontal() {
        return horizontal;
    }

    public int getStartX() {
        return startX;
    }

    public int getStartY() {
        return startY;
    }

    public boolean isSunk() {
        for (boolean isHit : hit) {
            if (!isHit) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String getSymbol() {
        if (isHit()) {
            if (hasShip()) {
                return "❌";
            } else {
                return "⭕";
            }
        }
        return "";
    }
}

