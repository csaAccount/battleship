import java.util.ArrayList;

public class Board {



















    public void setBoard(){
        String[] letters = {"A", "B", "C", "D", "E", "F", "G", "H", "I"};
        int num = 1;
        int idx = 0;
        for (String[] rows: board){
            for(String col: rows){
                col = letters[idx] + num;
            }
            num++;
            idx++;
        }
    }
}
