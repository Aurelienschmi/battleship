package bo;

public class Player {

    private PlayerBoard Board;
    private PlayerBoard AttackBoard;

    public Player(){
        Board = new PlayerBoard(10);
        AttackBoard = new PlayerBoard(10);
            }


    public PlayerBoard getBoard() {
        return Board;
    }
    public PlayerBoard getAttackBoard() {
        return AttackBoard;
    }



    public void updateAttackBoardOnSunk(Boat bo) {
        int x = bo.getX();
        int y = bo.getY();
        int sens = bo.getDirection();

        for (int j = 0; j < bo.getLenght(); j++) {
            if (sens == 0) {
                getAttackBoard().grilled[x][y + j] = "Z ";
            } else {
                getAttackBoard().grilled[x + j][y] = "Z ";
            }
        }
    }

}


