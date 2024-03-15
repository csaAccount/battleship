public class Player extends Board{
    private String name;
    public Player(String name) {
        super(name.substring(0, 1));
    }
}
