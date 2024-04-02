public class Ship{

    private int startX;
    private int startY;
    private boolean horizontal;
    private boolean[] hit;

    public Ship(int startX, int startY, boolean horizontal) {
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

