public class Ship extends Board{

    private int startX;
    private int startY;
    private boolean horizontal;
    private boolean[] hit;

    public Ship(String symbol, int startX, int startY, boolean horizontal) {
        super(symbol);
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
}

